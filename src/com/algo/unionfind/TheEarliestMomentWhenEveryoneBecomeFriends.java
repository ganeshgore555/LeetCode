package com.algo.unionfind;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

	public static void main(String[] args) {
		TheEarliestMomentWhenEveryoneBecomeFriends obj = new TheEarliestMomentWhenEveryoneBecomeFriends();
		int[][] logs = { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
				{ 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };
		int n = 6;
		System.out.println(obj.earliestAcq(logs, n));
	}

	public int earliestAcq(int[][] logs, int n) {

		// First, we need to sort the events in chronological order.
		Arrays.sort(logs, (a,b) -> a[0] - b[0]);

		// Initially, we treat each individual as a separate group.
		int groupCount = n;
		UnionFind uf = new UnionFind(n);

		for (int[] log : logs) {
			int timestamp = log[0], friendA = log[1], friendB = log[2];

			// We merge the groups along the way.
			if (uf.union(friendA, friendB)) {
				groupCount -= 1;
			}

			// The moment when all individuals are connected to each other.
			if (groupCount == 1) {
				return timestamp;
			}
		}

		// There are still more than one groups left,
		// i.e. not everyone is connected.
		return -1;
	}
}

class UnionFind {
	private int[] group;
	private int[] rank;

	public UnionFind(int size) {
		this.group = new int[size];
		this.rank = new int[size];
		for (int person = 0; person < size; ++person) {
			this.group[person] = person;
			this.rank[person] = 0;
		}
	}

	/** Return the id of group that the person belongs to. */
	public int find(int person) {
		if (this.group[person] != person)
			this.group[person] = this.find(this.group[person]);
		return this.group[person];
	}

	/**
	 * If it is necessary to merge the two groups that x, y belong to.
	 * 
	 * @return true: if the groups are merged.
	 */
	public boolean union(int a, int b) {
		int groupA = this.find(a);
		int groupB = this.find(b);
		boolean isMerged = false;

		// The two people share the same group.
		if (groupA == groupB)
			return isMerged;

		// Otherwise, merge the two groups.
		isMerged = true;
		// Merge the lower-rank group into the higher-rank group.
		if (this.rank[groupA] > this.rank[groupB]) {
			this.group[groupB] = groupA;
		} else if (this.rank[groupA] < this.rank[groupB]) {
			this.group[groupA] = groupB;
		} else {
			this.group[groupA] = groupB;
			this.rank[groupB] += 1;
		}

		return isMerged;
	}
}
