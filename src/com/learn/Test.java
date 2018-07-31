package com.learn;

public class Test {

//	public static void main(String[] args) {
//		String str = "Pankaj Kumar dsf kjhkjh sdfhj dskh kjdsfhd ksjh     j";
//		System.out.println(str.replaceAll("[\\s]", ""));
//		int arr[] = { 7, 1, 3 };
//		print(arr);
//
//		print(sort(arr));
//	}

	static int[] sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolean swap = false;
			for (int j = arr.length -1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
					swap = true;
				}
				 print(arr);
				if (!swap) {
					break;
				}
			}
		}
		return arr;

	}

	
	  private static int listToSort[] = new int[] { 7, 1, 3 };

	    public static void main(String[] args) {
	        print(listToSort);
	        bubbleSort(listToSort);
	    }

	    public static void print(int[] listToSort) {
	        for (int el : listToSort) {
	            System.out.print(el + ",");
	        }
	        System.out.println();
	    }

	    public static void swap(int[] listToSort, int iIndex, int jIndex) {
	        int temp = listToSort[iIndex];
	        listToSort[iIndex] = listToSort[jIndex];
	        listToSort[jIndex] = temp;
	    }

	    public static void bubbleSort(int[] listToSort) {
	        for (int i = 0; i < listToSort.length; i++) {
	            boolean swapped = false;
	            for (int j = listToSort.length - 1; j > i; j--) {
	                if (listToSort[j] < listToSort[j - 1]) {
	                    swap(listToSort, j, j - 1);
	                    swapped = true;
	                }
	            }
	            print(listToSort);
	            if (!swapped) {
	                break;
	            }
	        }
	    }


}
