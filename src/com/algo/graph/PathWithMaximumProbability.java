package com.algo.graph;

public class PathWithMaximumProbability {

	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0,1},{1,2},{0,2}};
		double[] succProb = {0.5,0.5,0.2};
		int start = 0;
		int end = 2;
		System.out.println(new PathWithMaximumProbability().maxProbability(n, edges, succProb, start, end));
	}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {
                break;
            }
        }

        return maxProb[end];
    }
}
