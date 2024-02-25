package com.learn.gfg;

import java.util.LinkedList;
import java.util.Queue;


public class StackUsingQueue<E> {

	private Queue<E> q1 = new LinkedList<E>();
	private Queue<E> q2 = new LinkedList<E>();
	
	public E pop() {
		return q1.poll();
	}
	
	public E top() {
		return q1.peek();
	}
	
	public int size() {
		return q1.size();
	}
	
	public void push(E elm) {
		
		while(!q1.isEmpty()) {
			E tmp = q1.poll();
			q2.add(tmp);
		}
		
		q1.add(elm);
		
		while(!q2.isEmpty()) {
			E tmp = q2.poll();
			q1.add(tmp);
		}		
	}
	public void print() {
		q1.stream().forEach(x-> System.out.print(x+" "));
	}
	
	public static void main(String[] args) {
		StackUsingQueue<Integer> obj = new StackUsingQueue<Integer>();
		for(int i=1 ; i < 10000;i++) {
			obj.push(i);
		}

		obj.print();
		System.out.println();
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.top());
 
		
	}
}
