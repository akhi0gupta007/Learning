package com.learn.gfg;

public class RemoveDuplicateSorted {

	public static void main(String[] args) {

	}

	int removeDuplicates(int arr[], int n) {

		int res = arr[0];
		int resIndex = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] != res) {
				if (arr[resIndex] != arr[i]) {
					arr[resIndex] = arr[i];				
				}
				
				res = arr[i];
				resIndex++;
			} else {

			}
		}

		return n;

	}

}
