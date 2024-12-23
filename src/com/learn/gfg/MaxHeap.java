package com.learn.gfg;

import com.ds.Util;

public class MaxHeap {
	
	final static int MAX = 10;
	static int heap[] = new int[MAX];
    static int size = 0;


	public static void insert(int elm) {
		//System.out.println("Inserting size : "+size);
		if(size >= MAX) {
		 throw new RuntimeException("Overflow");
		}		
		heap[size] = elm;
		shiftUp(size);
		size++;
	}
	

	public static int extractMax() {
		if(size <= 0) {
			 throw new RuntimeException("Empty heap");
		}
		int max = heap[0];
		heap[0] = heap[size-1];
		size--;
		shiftDown(0);		
		return max;
	}	
	 

    private static void shiftDown(int index) {
		
    	while(index < size) {
    		int leftChild = 2*index + 1;
    		int rightChild = 2*index + 2;
    		int largest  = index;
    		
    		if(leftChild < size && heap[leftChild] > heap[largest]) {
    			largest = leftChild;
    		}
    		
    		if(rightChild < size && heap[rightChild] > heap[largest]) {
    			largest = rightChild;
    		}
    		
    		if(largest != index) {
    			swap(largest, index);
        		index = largest;
    		}else {
    			break;
    		}
    		
    	}
    	
	}


	private static void shiftUp(int index) {
		while(index > 0) {
			int parent = (index - 1)/2;
			if(heap[parent] < heap[index]) {
				swap( parent, index);
				index = parent;
			}else {
				break;
			}
		}
	}


    // Helper method to swap two elements in the heap
    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

	public static void main(String[] args) {
        Util.print(heap);
        insert(500);
        insert(10);
        insert(20);
        insert(50);
        insert(60);
        insert(5100);
        insert(10);
        insert(20);
        insert(50);
        insert(60);
        Util.print(heap);
        System.out.println("Max element "+extractMax());
        insert(5);
        Util.print(heap);
        System.out.println("Max element "+extractMax());
    }


}
