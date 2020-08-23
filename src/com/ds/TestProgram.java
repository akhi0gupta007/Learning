package com.ds;

import java.util.Arrays;
import java.util.HashSet;

public class TestProgram {

	public static void main(String[] args) {

		// input 21462675756 output : 214*6*2*67-5-7-56

		String input = "21462675756";
		System.out.println(createString(input));
		int a[] = { 1, 2, 3, 7, 5 };
		int b[] = {1, 4, 20, 3, 10, 5};
		// sortAndRemoveDuplicates(a);
		// shiftelements(a, 2);

		subArrayWithGivenSum(a, 12);
		subArrayWithGivenSum(b, 33);

	}

	private static void subArrayWithGivenSum(int[] a, int d) {

		int sum = 0, j = 0, n = a.length;

		for (int i = 0; i < n; i++) {
			sum = sum + a[i];

			if (sum > d) {

				while (j < i && sum > d) {
					sum = sum - a[j];
					j++;
				}
			}

			if (sum == d) {
				System.out.println("Start: " + (j + 1) + " End: " + (i + 1));
				break;
			}

		}

	}

	private static void shiftelements(int[] a, int d) {
		int[] tmp = new int[d];

		for (int i = 0; i < d; i++) {
			tmp[i] = a[i];
		}
		int n = a.length;

		for (int i = d; i < n; i++) {
			a[i - d] = a[i];
		}

		int offset = n - d;
		for (int i = offset, j = 0; i < n; i++, j++) {
			a[i] = tmp[j];
		}
		printArray(a);
	}

	public static void sortAndRemoveDuplicates(int[] a) {
		Arrays.sort(a);
		printArray(a);

		int tmp[] = new int[a.length];
		tmp[0] = a[0];

		for (int i = 1, j = 1; i < a.length; i++) {
			if (a[i] != a[i - 1]) {
				tmp[j] = a[i];
				j++;
			}
		}

		printArray(tmp);
	}

	static void printArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.print("]");

	}

	public static String createString(String input) {

		StringBuffer bfr = new StringBuffer();

		boolean prevElmEven = false, prevElmOdd = false;

		char arr[] = input.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			bfr.append(arr[i]);

			if (arr[i] % 2 == 0) {
				if (prevElmEven) {
					bfr.append("*");
					prevElmOdd = false;
				}
				prevElmEven = true;

			} else {
				if (prevElmOdd) {
					bfr.append("-");
					prevElmEven = false;
				}
				prevElmOdd = true;

			}

		}

		return new String(bfr);

	}

}
