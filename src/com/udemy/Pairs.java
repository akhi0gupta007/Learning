package com.udemy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

	public static void main(String[] args) {
		int sum = 4;
		int arr[] = {10,5,2,3,-6,11};
		List<Integer> pairs = pairs(arr,sum);
		System.out.println(pairs);
	}

	private static List<Integer> pairs(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		List<Integer> pairs = new ArrayList<>();
		for(int i:arr) {
			int s = sum - i;
			if(set.contains(s)) {
				pairs.add(s);
				pairs.add(i);
				return pairs;
			}else {
				set.add(i);
			}
		}
		return pairs;
	}

}
