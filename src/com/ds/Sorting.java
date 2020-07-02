package com.ds;

public class Sorting {
	static int a[] = { 3, 6, 5, 9, 2, 1, 8, 7, 4 };

	public static void main(String[] args) {
		Util.traverse(a);
		// mergeSort(a);
		quickSort(0, a.length - 1, a);
		Util.traverse(a);
	}

	public static void mergeSort(int a[]) {
		if (a.length == 1)
			return;
		int mid = a.length / 2 + a.length % 2;
		int[] larr = new int[mid];
		int[] rarr = new int[a.length - mid];
		Util.split(a, larr, rarr, mid);
		mergeSort(larr);
		mergeSort(rarr);
		merge(larr, rarr, a);
	}

	public static void quickSort(int start, int end, int a[]) {
		if (start < end) {
			int pIndex = partition(a, start, end);
			quickSort(start, pIndex - 1, a);
			quickSort(pIndex + 1, end, a);
		}
	}

	private static int partition(int[] a,int start,int end) {
		int pIndex = start;
		int i = start, temp = 0;
		while (i < end) {
			if (a[i] <= a[end]) {
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
			i++;
		}
		
		//swap pIndex with end
		temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;
		
		return pIndex;
	}

	public static void merge(int[] larr, int[] rarr, int[] marr) {
		int i = 0, j = 0, k = 0;
		int nL = larr.length, nR = rarr.length;
		while (i < nL && j < nR) {
			if (larr[i] < rarr[j]) {
				marr[k] = larr[i];
				i++;
			} else {
				marr[k] = rarr[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			marr[k] = larr[i];
			i++;
			k++;
		}
		while (j < nR) {
			marr[k] = rarr[j];
			j++;
			k++;
		}

	}

}
