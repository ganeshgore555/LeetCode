package com.algo.graph.bfs;

import java.util.*;

public class JumpGameIII {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
		int start = 5;
		System.out.println(new JumpGameIII().canReachBFS(arr, start));
		int[] arr1 = { 3, 0, 2, 1, 2 };
		int start1 = 3;
		System.out.println(new JumpGameIII().canReachBFS(arr1, start1));

	}

	public boolean canReachBFS(int[] arr, int start) {
		int n = arr.length;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int node = q.poll();
			// check if reach zero
			if (arr[node] == 0) {
				return true;
			}
			if (arr[node] < 0) {
				continue;
			}

			// check available next steps
			if (node + arr[node] < n) {
				q.offer(node + arr[node]);
			}
			if (node - arr[node] >= 0) {
				q.offer(node - arr[node]);
			}
			// mark as visited
			arr[node] = -arr[node];
		}
		return false;
	}

	public boolean canReachDFS(int[] arr, int start) {
		if (start >= 0 && start < arr.length && arr[start] >= 0) {
			if (arr[start] == 0) {
				return true;
			}
			arr[start] = -arr[start];
			return canReachDFS(arr, start + arr[start]) || canReachDFS(arr, start - arr[start]);
		}
		return false;
	}
}
