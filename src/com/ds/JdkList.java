package com.ds;

import java.util.LinkedList;

public class JdkList {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		print(list);
		
		list.removeLast();
		
		print(list);
		
		list.removeLast();
		
		print(list);
		
		list.removeLast();
		
		print(list);

	}
	
	static void print(LinkedList<Integer> list) {
		System.out.println();
		System.out.print("HEAD=>");
		for(Integer elm: list) {
			System.out.print(elm);
			System.out.print("<=>");
		}
	}

}
