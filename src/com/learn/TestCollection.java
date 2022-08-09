package com.learn;

import java.util.Arrays;

import com.ds.LinkedList;
import com.ds.Util;

public class TestCollection {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(23);
		list.push(2);
		list.push(7);
		list.push(8);
		list.append(56);
		list.append(51);
		//list.append(1);
		list.traverse();
		list.reverse();
		System.out.println("Reverse"); 
		list.traverse();
		list.reverse2();
		System.out.println("Reverse"); 
		list.traverse();
		System.out.println(list.midElement());
		System.out.println("Second from last "+ list.nthFromLast(2));
		list.truncateList();
		list.traverse();
		list.push(0);
		list.push(2);
		list.push(1);
		list.push(0);
		list.push(1);
		list.push(0);
		list.traverse();
		System.out.println(list.getSize());
		Integer[] arr =  Arrays.stream(list.asArray())
                .boxed()
                .toArray(Integer[]::new);
		System.out.println(arr[5]);
		Util.traverse(arr);
		Util.bubbleSort(arr);
		Util.traverse(arr);
	}
}
