package com.learn;

import com.ds.LinkedList2;
import com.ds.LinkedList2.Node;

import java.util.ArrayList;
import java.util.List;

public class TestDS {

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		List<Integer> list2 = new ArrayList<Integer>();
		//Integer[] arr = new Integer[al.size()];
		// arr = list2.toArray(arr);
		list.push(1);
		list.append(2);list.append(3);
//		list.append(3);list.append(4);
//		list.append(5);list.append(6);
		list.traverse();
		//list.reverse();
		//list.traverse();
		//list.traverseRecursion(list.getHead());
		list.reverseRecursion(list.getHead());
		System.out.println("After reverse");
		list.traverse();
		list.reverse();

		System.out.println("reset reverse");
		
		list.traverse();
	//	System.out.println("Mid");
		
		//System.out.println("result:"+ list.middleElement());
		
		Node reverseList = list.reverseList2(list.getHead());
		list.traverse2(list.newHead);
	}

}
