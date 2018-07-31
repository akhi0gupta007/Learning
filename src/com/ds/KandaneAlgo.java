package com.ds;

public class KandaneAlgo {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSubArraySum(a));

	}

	static int maxSubArraySum(int a[]) {

		int max_so_far = 0, max_ending = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0 && a[i] > max_so_far)
				max_so_far = a[i];
			max_ending = max_ending + a[i];

			if (max_ending < 0)
				max_ending = 0;
			else if (max_ending > max_so_far)
				max_so_far = max_ending;
			//
		}

		return max_so_far;

	}

}
