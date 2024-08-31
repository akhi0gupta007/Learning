package com.learn.gfg;

import java.util.ArrayList;
import java.util.List;

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
//		SimpleQueue queue = new SimpleQueue();
//		System.out.println("Enque");
//		queue.enque(15);
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Enque");
//		queue.enque(1);
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Enque");
//		queue.enque(13);
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Enque");
//		queue.enque(2);
//		System.out.println("Enque");
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Enque");
//		queue.enque(2);
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Deque");
//		System.out.println(queue.deque());
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Deque");
//		System.out.println(queue.deque());
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Deque");
//		System.out.println(queue.deque());
//		System.out.println("Deque");
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		
//		System.out.println(queue.deque());
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		System.out.println("Deque");
//		System.out.println(queue.deque());
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		queue.enque(123);
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
//		queue.print();
//		System.out.println("Front "+ queue.getFront()+" Rear : "+queue.getRear());
		
		List<Integer> existing = new ArrayList<>();
//        existing.add(1);
//        existing.add(2);
//        existing.add(3);
//        existing.add(4);
//        existing.add(5);

        List<Integer> newList = new ArrayList<>();
        newList.add(3);
        newList.add(4);
        newList.add(6);
        newList.add(7);

        // Create a copy of the old list
        List<Integer> filteredList = new ArrayList<>(existing);

        // Remove elements not present in the new list
        //filteredList.retainAll(newList);
        filteredList.removeAll(newList);

        System.out.println("Filtered list: " + filteredList);
        
        List<Integer> toBeAdded = new ArrayList<>(newList);
        toBeAdded.removeAll(existing);
        
        System.out.println("toBeAdded list: " + toBeAdded);
        
	}

}
