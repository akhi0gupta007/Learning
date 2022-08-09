package com.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

	public static void main(String[] args) {
		int sum = 18;
		int arr[] = { 1, 2, 3, 15, 4, 5, 6, 7, 8, 9 };
		// List<Integer> pairs = triplet(arr, sum);
		// System.out.println("Triplet: "+pairs);

		System.out.println(tripletsBetter(arr, sum));
	}

	public static List<Integer> triplet(Integer[] arr, int sum) {
		List<Integer> triplet = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int firstPair = arr[i];
			int sumPair = sum - firstPair;
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
			list.remove(i);
			List<Integer> pairs = pairs(list.toArray(new Integer[0]), sumPair);
			if (!pairs.isEmpty()) {
				triplet.addAll(pairs);
				triplet.add(firstPair);
				break;
			}
		}

		return triplet;
	}

	public static List<List<Integer>> tripletsBetter(int[] arr, int targetSum) {
		List<List<Integer>> triplets = new ArrayList<>();
		int[] sorted = Arrays.stream(arr).sorted().toArray();
		System.out.println("Before");
		print(sorted);
		int n = sorted.length;
		for (int i = 0; i < n - 3; i++) {
			int j = i + 1;
			int k = n - 1;

				while (j < k) {
				int current_sum = sorted[i];
				current_sum += sorted[j];
				current_sum += sorted[k];
				if (current_sum == targetSum) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(sorted[i]);
					triplet.add(sorted[j]);
					triplet.add(sorted[k]);
					triplets.add(triplet);
					j++;
					k--;
				}else if(current_sum < targetSum){
					j++;
				}else if(current_sum > targetSum){
					k--;
				}
			}

		}

		return triplets;
	}

	public static List<Integer> pairs(Integer[] arr, int sum) {
		// System.out.println("Recieved input as "+print(arr)+" sum "+sum);
		Set<Integer> set = new HashSet<>();
		List<Integer> pairs = new ArrayList<>();
		for (int i : arr) {
			int s = sum - i;
			if (set.contains(s)) {
				pairs.add(s);
				pairs.add(i);
				return pairs;
			} else {
				set.add(i);
			}
		}
		// System.out.println("Return result as "+pairs);
		return pairs;
	}

	private static void print(int[] arr) {
		StringBuffer buff = new StringBuffer();
		for (Integer i : arr) {
			buff.append(i);
			buff.append(" ");
		}
		System.out.println(buff.toString());
	}

}
