package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KandaneAlgo {

	public static void main(String[] args) {
		int[] a = { -163, -20 };
		int[] b = { 5, 1, 3, 2, 4};
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
			list.add(b[i]);
		}
		System.out.println(wave2(list));
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		boolean gtr = true;
		int tmp = 0;
		Integer[] a = new Integer[A.size()];
		a = A.toArray(a);
		for (int i = 0; i < a.length; i++) {
			if (i + 1 > a.length - 1)
				break;
			if (gtr && a[i] < a[i + 1]) {
				tmp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = tmp;
			}
			if (!gtr && a[i] > a[i + 1]) {
				tmp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = tmp;
			}
			gtr = !gtr;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}

	public static ArrayList<Integer> wave2(ArrayList<Integer> A) {
		boolean gtr = true;
		int tmp = 0;
		Collections.sort(A);
		for (int i = 0; i < A.size(); i++) {
			if (i + 1 > A.size() - 1)
				break;
			if (gtr && A.get(i) < A.get(i+1)) {
				tmp = A.get(i);
				A.set(i, A.get(i+1));
				A.set(i+1, tmp);
			}
			if (!gtr && A.get(i) > A.get(i+1)) {
				tmp = A.get(i);
				A.set(i, A.get(i+1));
				A.set(i+1, tmp);
			}
			gtr = !gtr;
		}
		
		return A;
	}
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int maxSubArray(final List<Integer> A) {
		Integer[] a = new Integer[A.size()];
		a = A.toArray(a);
		Integer max_so_far = -9999, max_ending = -9999;
		for (int i = 0; i < a.length; i++) {

			if (a[i] > 0 && a[i] > max_so_far) {
				max_so_far = a[i];
			}
			max_ending = max_ending + a[i];

			if (max_ending < 0) {
				max_ending = 0;
			} else if (max_ending > max_so_far) {
				max_so_far = max_ending;
			}
		}
		return max_so_far;
	}

	public static int kadaneAlgo(final List<Integer> A) {
		Integer[] a = new Integer[A.size()];
		a = A.toArray(a);
		int max_sum = a[0];
		int current_sum = max_sum;
		for (int i = 1; i < a.length; i++) {
			current_sum = Math.max(current_sum + a[i], a[i]);
			max_sum = Math.max(current_sum, max_sum);
		}

		return max_sum;
	}

}
