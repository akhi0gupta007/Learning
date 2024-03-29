package com.learn;

import java.util.Arrays;

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
		//list.traverse();
		Integer a[] = Arrays.stream(list.asArray())
                .boxed()
                .toArray(Integer[]::new);
		Util.traverse(a);
		System.out.println(Util.firstOccurence(8, a));
		
		Integer b[] = Util.createArray(10);
		Util.traverse(b);
		System.out.println("is Sorted "+Util.isSorted(a, a.length));
		System.out.println("is Sorted "+Util.isSorted(b, b.length));
		
	}

}
