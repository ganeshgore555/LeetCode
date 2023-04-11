package com.algo.graph;

public class IsBipartite {

	static int colors[];
	static int V; // number of edges
	public static void main(String[] args) {
		/*
		   (3)---(2)
	        |     |
	        |     |
	        |     |
	       (0)---(1)
	    */
     int graph[][] = {
         { 0, 1, 0, 1 },
         { 1, 0, 1, 0 },
         { 0, 1, 0, 1 },
         { 1, 0, 1, 0 },
     };     
     IsBipartite inst = new IsBipartite();
     System.out.println(inst.isBipartite(graph));
     
	}

	
    public boolean isBipartite(int[][] graph) {
    	V = graph.length;
        colors = new int[V];
        for(int i = 0; i < V; i++)
       	 colors[i] = 0;
    	int m = 2; // Variant of m coloring problem with m as 2, since vertices need to be divided into 2 groups for bipartite graph
        return isBipartiteUtil(graph, m, 0);
    }


	private boolean isBipartiteUtil(int[][] graph, int m, int edge) {
		if(edge == V) {
			return true;
		}
		
		for(int i = 1; i <= m; i++)
		{
			if(isSafe(graph, edge, i)) {
				colors[edge] = i;
				if(isBipartiteUtil(graph, m, edge+1))
					return true;
			}
			colors[edge] = 0;
		}
		return false;
	}


	private boolean isSafe(int[][] graph, int edge, int color) {
		for(int i = 0; i < V; i++)
			if(graph[edge][i] == 1 && colors[i] == color) {
				return false;
			}
		return true;
	}
}
