package com.ds;

import java.util.ArrayList;
import java.util.List;

public class Manipulation {

	public static void main(String[] args) {

		String str = "aakmaakmakda";
//		int result = new Manipulation().solution1(str);
//		System.out.println(result);
		int arr[] = {6,42,11,7,1,42};
		int arr1[] = {13,13,1,6};
		int solution = new Manipulation().solution(7, 42, arr);
		System.out.println(solution);
		int solution2 = new Manipulation().solution(6, 13, arr1);
		System.out.println(solution2);
	}

	int solution(int X, int Y, int[] A) {
		int N = A.length;
		int result = -1;
		int nX = 0;
		int nY = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == X)
				nX += 1;
			else if (A[i] == Y)
				nY += 1;
			if (nX == nY)
				result = i;
			if (result > 0 && A[i] != X && A[i] != Y) {
				//result++;
			}

		}
		return result;
	}

	public int solution1(String S) {

		char[] arr = S.toCharArray();
		List<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < arr.length - 1; i++) {

			String diagram = String.valueOf(arr[i]) + String.valueOf(arr[i + 1]);

			int lastIndex = S.lastIndexOf(diagram);

			if (lastIndex != -1) {
				int lastChar = lastIndex + 1;
				int firstOccr = i + 1;
				int result = lastChar - firstOccr;
				results.add(result);

			}

		}

		int max = 0;

		System.out.println(results);
		for (Integer x : results) {
			if (x > max) {
				max = x;
			}

		}

		return max == 0 ? -1 : max;
	}

}
