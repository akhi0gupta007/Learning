package com.learn;

import java.util.Arrays;

public class ArrayRotate {

	public static void main(String[] args) {
		Integer arr[] = {1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7};
		print(arr);
		rotate(arr,3);
		print(arr);
	}

	private static void rotate(Integer[] arr, int d) {
		int n = arr.length;
		Integer temp[] = new Integer[d]; 
		
		for(int i = 0; i< d ;i++ )
			temp[i] = arr[i];
		
		for(int i = 0; i< n;i++){
			if((i+d) >= n)
				break;
			arr[i] = arr[i+d];
		}
		
		for(int i = (n-1), j = (temp.length - 1) ; j >= 0 ;i--,j--){
			arr[i] = temp[j];
		}		

	}

	private static void print(Integer[] arr) {
		
		Arrays.asList(arr).forEach(elm -> System.out.print(elm));;
		System.out.println();
	}

}
