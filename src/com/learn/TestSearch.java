package com.learn;

import com.ds.LinkedList;
import com.ds.Util;

public class TestSearch {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(23);
		list.push(2);
		list.push(7);
		list.push(8);
		list.append(56);
		list.append(51);
		list.append(8);
		list.traverse();
		int a[] = list.asArray();
		Util.traverse(a);
		int position = Util.binarySearch(51,a);
		System.out.println("Found at "+position);
		Util.bubbleSort(a);
		position = Util.binarySearchRecursive(8, 0, a.length -1 , a);
		System.out.println("Found at "+position);
		position = Util.firstOccurence(8, a);
		System.out.println("Found at "+position);
	}

}
