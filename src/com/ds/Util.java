package com.ds;

import java.util.Arrays;
import java.util.Random;

public class Util {

	public static void bubbleSort(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			boolean swap = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j - 1);
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public static void split(Integer arr[], Integer larr[], Integer rarr[], Integer mid) {		
		int j =0;
		for (int i = 0; i < arr.length; i++) {
			if (i < mid) {
				larr[i] = arr[i];
			} else {
				rarr[j] = arr[i];
				j++;
			}
		}

	}

	static void swap(Integer[] a, int indexX, int indexY) {
		int tmp = a[indexX];
		a[indexX] = a[indexY];
		a[indexY] = tmp;
	}

	public static void traverse(Integer[] a) {
		if (a.length == 0) {
			System.out.println("Empty list");
			return;
		}
		int i = 0;
		while (i < a.length) {
			System.out.print("->" + a[i]);
			i++;
		}
		System.out.println("\n");
	}

	public static int binarySearch(int elm, Integer[] a) {
		Util.bubbleSort(a);
		System.out.println("Traversing at Search");
		Util.traverse(a);
		int mid = -1,low= 0, high = (a.length - 1);
		for(int i = 0; i<a.length;i++){
			mid = low+ (high - low)/2;
			if(a[mid] == elm){
				return mid;
			}
			else if( elm < a[mid]){
				high = mid - 1;
			}
			else if (elm > a[mid]){
				low = mid + 1;
			}
			
		}
		
		return -1;
	}
	
	public static int firstOccurence(int elm, Integer[] a) {
		Util.bubbleSort(a);
		int result = -1;
		System.out.println("After sorting...");
		Util.traverse(a);
		int mid = -1,low= 0, high = (a.length - 1);
		for(int i = 0; i<a.length;i++){
			mid = low+ (high - low)/2;
			if(a[mid] == elm){
				result = mid;
				high = mid -1; // for last occurrence just make it low = mid + 1
			}
			else if( elm < a[mid]){
				high = mid - 1;
			}
			else if (elm > a[mid]){
				low = mid + 1;
			}
			
		}
		
		return result;
	}
	
	
	public static int lastOccurrence(Integer[] a,int elm) {
		int result = -1;
		
		if(!isSorted(a, a.length)) {
			bubbleSort(a);
		}
		
		int low = 0, high = a.length - 1, mid = low +  (high-low)/2;
		
		
		
		
		return result;
	}
	
	public static boolean isSorted(Integer[] arr, int size) {
		
		if(size == 0 || size == 1)
			return true;
		
		//unsorted pair found, checking last two elements of array
		if(arr[size-2] > arr[size - 1])
			return false;
		
		return isSorted(arr, size -1 );
		
	}
	
	
	public static Integer[] createArray(int size) {
		LinkedList list = new LinkedList();
		for(int i = 0;i < size;i++) {
			list.push(generateRandom());
		}		
		return Arrays.stream(list.asArray())
                .boxed()
                .toArray(Integer[]::new);
	}
	
	public static  int generateRandom() {
		Random ran = new Random();
		return ran.nextInt(99);
	}
	
	public static int binarySearchRecursive(int elm, int low,int high, int[] a) {
		int mid = low+ (high - low)/2;
		if(mid < 0)
			return -1;
		if(a[mid] == elm)
			return mid;
		else if (elm < a[mid]){
			return binarySearchRecursive(elm, low, mid -1 ,a);
		}
		else if (elm > a[mid]){
			return  binarySearchRecursive(elm, mid + 1, high -1 ,a);
		}
		
		return -1;
	}

}
