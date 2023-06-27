package com.algo.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SimilarStringGroups {

	public static void main(String[] args) {
		//String[] strs = {"tars","rats","arts","star"};
		String[] strs = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
		System.out.println(new SimilarStringGroups().numSimilarGroups(strs));
	}
	
	// BFS
	
    public void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // Form the required graph from the given strings array.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }

        boolean[] visit = new boolean[n];
        int count = 0;
        // Count the number of connected components.
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, adj, visit);
                count++;
            }
        }

        return count;
    }
    
    
    // Union Find
    
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union_set(int x, int y) {
            int xset = find(x), yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }

    public int numSimilarGroupsUnionFind(String[] strs) {
        int n = strs.length;
        UnionFind dsu = new UnionFind(n);
        int count = n;
        // Form the required graph from the given strings array.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) && dsu.find(i) != dsu.find(j)) {
                    count--;
                    dsu.union_set(i, j);
                }
            }
        }

        return count;
    }
    
    
    
    
}
