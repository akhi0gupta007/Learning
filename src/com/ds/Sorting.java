package com.ds;

public class Sorting {
	static int a[] = { 3, 6, 5, 9, 2, 1, 8, 7, 4 };

	public static void main(String[] args) {
		int mid = a.length / 2 + a.length % 2;
		int[] larr = new int[mid];
		int[] rarr = new int[a.length - mid];
		Util.split(a, larr, rarr, mid);
		Util.traverse(larr);
		Util.traverse(rarr);
		merge(larr, rarr, a);
		Util.traverse(a);
		// mergeSort(a);
	}

	public static void mergeSort(int a[]) {
		if (a.length == 1)
			return;
		int mid = a.length / 2 + a.length % 2;
		int[] larr = new int[mid];
		int[] rarr = new int[a.length - mid];
		Util.split(a, larr, rarr, mid);
		Util.traverse(larr);
		Util.traverse(rarr);
		mergeSort(larr);
		mergeSort(rarr);

	}

	public static void merge(int[] larr, int[] rarr, int[] marr) {
		int i = 0, j = 0, k = 0;
		int nL = larr.length, nR = rarr.length, nM = marr.length;
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
