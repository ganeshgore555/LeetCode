package com.algo.arrays;

import java.util.*;

public class TwoSubArraySumEqualsK {

	public static void main(String[] args) {
		int[] A = {1,2,3,2,4,5};
		int[] B = {7,1,2,5};
		int k = 7;
		System.out.println(new TwoSubArraySumEqualsK().twoSubArraySumEqualsK(A, B, k));	
	}

	public List<List<List<Integer>>> twoSubArraySumEqualsK(int[] A, int[] B, int k){
		List<List<List<Integer>>> result = new ArrayList<>();
		HashMap<Integer,List<List<Integer>>> subArrayA = new HashMap();
		HashMap<Integer,List<List<Integer>>> subArrayB = new HashMap();
		getPossibleSubArray(A, k, subArrayA);
		getPossibleSubArray(B, k, subArrayB);
		
		for(Integer keyA : subArrayA.keySet()) {
			for(Integer keyB : subArrayB.keySet()) {
				if((keyA + keyB) == k) {
					List<List<Integer>> listA = subArrayA.get(keyA);
					List<List<Integer>> listB = subArrayB.get(keyB);
					for(List<Integer> aSet  : listA) {
						for(List<Integer> bSet  : listB) {
							List<List<Integer>> temp = new ArrayList();
							temp.add(new ArrayList<>(aSet));
							temp.add(new ArrayList<>(bSet));
							result.add(temp);
						}
					}
				}
			}
		}		
		return result;
	}

	private void getPossibleSubArray(int[] arr, int k, HashMap<Integer, List<List<Integer>>> subsetArr) {
		for(int i = 0; i < arr.length; i++) {
			int currSum = 0;
			ArrayList<Integer> tempList = new ArrayList<>();
			for(int j = i; j < arr.length; j++) {
				if(currSum + arr[j] <= k) {
					currSum += arr[j];
					tempList.add(arr[j]);
					subsetArr.computeIfAbsent(currSum, value -> new ArrayList()).add(new ArrayList<>(tempList));
				}else {
					break;
				}
			}
		}
	}
	
	/*
	private void getPossibleSubset(int[] arr, int k, HashMap<Integer, List<List<Integer>>> subsetArr, ArrayList<Integer> tempList,  int index, int currSum) {
		if(index == arr.length) {
			subsetArr.computeIfAbsent(currSum, value -> new ArrayList()).add(new ArrayList<>(tempList));
			return;
		}
		getPossibleSubset(arr, k, subsetArr, tempList, index+1, currSum);
		if((currSum + arr[index]) <= k) {
			tempList.add(arr[index]);
			currSum = currSum + arr[index];
			getPossibleSubset(arr, k, subsetArr, tempList, index+1, currSum);
			tempList.remove(tempList.size()-1);
			currSum = currSum - arr[index];
		}
	}
	*/
}
