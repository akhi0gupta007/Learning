package com.learn.gfg;

import com.ds.Util;

public class SimpleQueue {

	public static final int MAX_CAPACITY = 4;

	private int[] arr = new int[MAX_CAPACITY];

	private int size = 0, front;

	public boolean isFull() {
		if (size >= MAX_CAPACITY)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty () {
		return size == 0;
	}
	
	public int getRear() {		
		return (front + size - 1) % MAX_CAPACITY;
	}
	
	public void enque(int data) {
		if(isFull())
		{
			System.err.println("Queue is full");
			return;
		}		
		int rear = getRear();
		rear = (rear + 1) % MAX_CAPACITY;
		arr[rear] = data;
		size++;		
	}
	
	public int deque() {
		int result = -1;
		if(isEmpty()) {
			System.err.println("Queue is empty");
			return -1;
		}
		result = arr[front];
		front  = (front + 1) % MAX_CAPACITY;
		size--;		
		return result;
	}
	
	public void print() {
		Util.print(arr);
	}
	
	
	
	public int getFront() {
		return front;
	}

	public static void main(String[] args) {
		SimpleQueue queue = new SimpleQueue();
		
		queue.enque(15);
		queue.enque(1);
		queue.enque(13);
		queue.enque(2);
		System.out.println(queue.deque());
		System.out.println(queue.deque());
		queue.enque(123);
		queue.print();
		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
	}

}
