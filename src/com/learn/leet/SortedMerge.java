package com.learn.leet;

import com.ds.Util;

public class SortedMerge {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		if(nums2.length == 0) {
			return;
		}
		int tmp=-1;
		int i = 0, j = 0;
		while ( i < nums1.length && j < nums2.length) {

			if (nums1[i] > nums2[j]) {
				tmp = nums1[i];
				nums1[i] = nums2[j];
				shift(nums1, i, tmp);
				j++;				
			}
			i++;
		}
		
		while (i < nums1.length  && j < nums2.length ) {
			nums1[i]=nums2[j];
			i++;
			j++;
		}		
		
	}

	public void shift(int[] a, int pos, int elm) {
		int tmp = -1;
		for(int i = pos + 1; i < a.length;i++) {
			tmp = a[i];
			a[i] = elm;
			elm = tmp;
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		new SortedMerge().merge(nums1, 3, nums2, 3);
		Util.print(nums1);
		
		nums1=new int[] {1};
		nums2 = new int[] {};
		new SortedMerge().merge(nums1, 1, nums2, 0);
		Util.print(nums1);
		
		nums1=new int[] {0};
		nums2 = new int[] {1};
		new SortedMerge().merge(nums1, 0, nums2, 1);
		Util.print(nums1);
		
		nums1=new int[] {2,0};
		nums2 = new int[] {1};
		new SortedMerge().merge(nums1, 1, nums2, 1);
		Util.print(nums1);
		
		nums1=new int[] {1,2,4,5,6,0};
		nums2 = new int[] {3};
		new SortedMerge().merge(nums1, 5, nums2, 1);
		Util.print(nums1);
	}

	public void insert(int[] a, int pos, int elm) {
		for (int i = pos; i < a.length; i++) {
			if (a[i] == 0) {
				a[i] = elm;
				break;
			}
		}
	}

}
