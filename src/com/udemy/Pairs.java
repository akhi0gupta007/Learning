package com.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

	public static void main(String[] args) {
		int sum = 1;
		Integer arr[] = { 10, 5, 2, 3, -6, 11 };
		List<Integer> pairs = triplet(arr, sum);
		System.out.println("Triplet: "+pairs);		
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

	public static List<Integer> pairs(Integer[] arr, int sum) {
		System.out.println("Recieved input as "+print(arr)+" sum "+sum);
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
		System.out.println("Return result as "+pairs);
		return pairs;
	}

	private static String print(Integer[] arr) {
		StringBuffer buff = new StringBuffer();
		for(Integer i:arr) {
			buff.append(i);
			buff.append(" ");
		}
		return buff.toString();
	}

}
