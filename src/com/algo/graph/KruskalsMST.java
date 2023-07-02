package com.algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsMST {

    // Defines edge structure
    static class Edge {
        int src, dest, weight;
 
        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
 
    // Defines subset element structure
    class UnionFind {
        int[] group, rank;
 
        public UnionFind(int n)
        {
        	group = new int[n];
        	rank = new int[n];
        	for(int i = 0; i < n; i++) {
		        this.group[i] = i;
		        this.rank[i] = 0;
        	}
        }
        
        // Function to unite two disjoint sets
        void union(int x, int y)
        {
            int groupX = find(x);
            int groupY = find(y);
     
            if (rank[y] < rank[x]) {
            	group[y] = groupX;
            }
            else if (group[x] < group[y]) {
            	group[x] = groupY;
            }
            else {
            	group[y] = groupX;
                rank[x]++;
            }
        }
     
        // Function to find group of a set
        int find(int i)
        {
            if (group[i] != i)
            	group[i] = find(group[i]);
     
            return group[i];
        }        
    }
 
    // Starting point of program execution
    public static void main(String[] args)
    {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
            List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                    new Edge(0, 3, 5), new Edge(1, 3, 15),
                    new Edge(2, 3, 4)));
 
        // Sort the edges in non-decreasing order
        // (increasing with repetition allowed)
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });
        
        KruskalsMST obj = new KruskalsMST();
        
        obj.kruskals(V, graphEdges);
    }
 
    // Function to find the MST
    private void kruskals(int V, List<Edge> edges)
    {
        int j = 0;
        int noOfEdges = 0;
 
        // Allocate memory for creating V subsets
        UnionFind uf = new UnionFind(V);
 
        // Allocate memory for results
        Edge results[] = new Edge[V];
  
        // Number of edges to be taken is equal to V-1
        while (noOfEdges < V - 1) {
 
            // Pick the smallest edge. And increment
            // the index for next iteration
            Edge nextEdge = edges.get(j);
            int x = uf.find(nextEdge.src);
            int y = uf.find(nextEdge.dest);
 
            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                results[noOfEdges] = nextEdge;
                uf.union(x, y);
                noOfEdges++;
            }
 
            j++;
        }
        
        // Print the contents of result[] to display the
        // built MST
        System.out.println(
            "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                               + results[i].dest + " == "
                               + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    } 
}
