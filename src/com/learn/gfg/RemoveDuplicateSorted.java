package com.learn.gfg;

import com.ds.Util;

public class RemoveDuplicateSorted {

	public static void main(String[] args) {
		Integer arr[] = {10,20,20,30,30,30};
		System.out.println("Before");
		Util.traverse(arr);
		removeDuplicates(arr);
		System.out.println("After");
		Util.traverse(arr);

		Integer arr2[] = {0,8,5,0,10,0,20};
		System.out.println("Before");
		Util.traverse(arr2);
		zeroToEnd(arr2);
		System.out.println("After");
		Util.traverse(arr2);
	}

	static void zeroToEnd(Integer arr[]){
		int res = 0;
		
		for (int i = 1; i < arr.length; i++) {
				if(arr[i] != 0){
					arr[res] = arr[i];
					res++;
				}
		}

		System.out.println("Finally "+res);

		while(res < arr.length){
			arr[res] = 0;
			res++;
		}

	}

	static void removeDuplicates(Integer arr[]) {

		int res = arr[0];
		int resIndex = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != res) {
				if (arr[resIndex] != arr[i]) {
					arr[resIndex] = arr[i];				
				}
				
				res = arr[i];
				resIndex++;
			} else {
				arr[i] = -1;
			}
		}
		
		System.out.println("resIndex"+resIndex);
		//Util.traverse(arr);
		
		while(resIndex < arr.length) {
			arr[resIndex] = -1;
			resIndex++;
		}
	}

}
