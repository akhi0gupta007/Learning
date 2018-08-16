package com.learn;

import java.util.Arrays;

public class ArrayRotate {

	public static void main(String[] args) {
		Integer arr[] ={1,2,3,4,5,6,7};
		print(arr);
		rotate(arr,2);
		print(arr);
		Integer arr1[] = {1,2,3,4,5,6,7};
		print(arr1);
		rotateWithoutExtraSpace(arr1,2);
		print(arr1);
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
	
	/**
	 * @param arr
	 * @param d
	 */
	private static void rotateWithoutExtraSpace(Integer[] arr, int d) {
		int n = arr.length;
		int tmp = -1;
		for(int i = 0; i <= d;i++,d--){
			
			for(int j = 0; j < n;j++){
				if(tmp < 0)
					tmp= arr[j];
				if((j + 1)>= n)
					continue;				
				arr[j] = arr[j+1];				
			}
			
			arr[n-1] = tmp;
			tmp = -1;			
		}
	}

	private static void print(Integer[] arr) {
		Arrays.asList(arr).forEach(elm -> System.out.print(elm));;
		System.out.println();
	}

}
