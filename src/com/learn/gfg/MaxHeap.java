package com.learn.gfg;

import com.ds.Util;

import java.util.*;

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
		shiftDown(0,heap);
		return max;
	}	
	 

    private static void shiftDown(int index,int[] arr) {
		
    	while(index < size) {
    		int leftChild = 2*index + 1;
    		int rightChild = 2*index + 2;
    		int largest  = index;
    		
    		if(leftChild < size && arr[leftChild] > arr[largest]) {
    			largest = leftChild;
    		}
    		
    		if(rightChild < size && arr[rightChild] > arr[largest]) {
    			largest = rightChild;
    		}
    		
    		if(largest != index) {
    			swap(largest, index,arr);
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
				swap( parent, index,heap);
				index = parent;
			}else {
				break;
			}
		}
	}


    // Helper method to swap two elements in the heap
    private static void swap(int i, int j,int[] arr) {
        int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
    }

	public static void buildHeap(int[] arr)  {
		maxHeapify(arr);
		System.out.println("After Heaping: "+Arrays.toString(arr));
	}

	private static void maxHeapify(int[] arr) {
		int n = arr.length;
		for(int i=n/2 -1 ; i >= 0; i--) {
			int largest = i;
			int rightChild = 2 * i + 1;
			int leftChild = 2 * i + 2;

			if(leftChild < n && arr[largest] < arr[leftChild]) {
				largest = leftChild;
			}

			if(rightChild < n && arr[largest] < arr[rightChild]) {
				largest = rightChild;
			}
			if(largest != i){
				swap(largest, i,arr);
			}
		}
	}

	public static void  heapSort(int[] arr) {
		int n = arr.length;
		buildHeap(arr);
		for(int i = n-1; i >= 0; i--) {
			swap(i,0,arr);
			heapify(0,arr,i);
		}

	}

	private static void heapify(int i, int[] arr,int limit) {

		int size = arr.length;
		while(i < size) {

			int largest = i;
			int rightChild = 2 * i + 1;
			int leftChild = 2 * i + 2;

			if(leftChild < limit && arr[largest] < arr[leftChild]) {
				largest = leftChild;
			}

			if(rightChild < limit && arr[largest] < arr[rightChild]) {
				largest = rightChild;
			}

			if(largest != i) {
				swap(largest,i,arr);
				i++;
			}else{
				break;
			}
		}
	}

	public static boolean checkMaxHeap(int[] arr) {
		if(arr.length == 0 || arr.length == 1)
			return true;
		int size = arr.length;
		int i = 0;
		while(i < size) {
			int largest = i;
			int rightChild = 2 * i + 1;
			int leftChild = 2 * i + 2;

			if(leftChild < size && arr[largest] < arr[leftChild]) {
				return false;
			}
			if(rightChild < size && arr[largest] < arr[rightChild]) {
				return false;
			}

			i++;
		}

		return true;
	}



	public static void main(String[] args) {
		int[] arr ={10,15,50,4,20};
		System.out.println(Arrays.toString(arr));
		System.out.println(checkMaxHeap(arr));
		buildHeap(arr);
		System.out.println(checkMaxHeap(arr));
	//	heapSort(arr);
		System.out.println(Arrays.toString(arr));
//        Util.print(heap);
//        insert(5);
//        insert(8);
//        insert(9);
//        insert(12);
//        insert(14);
//        insert(8);
//		insert(20);
//		insert(40);
//        Util.print(heap);
    //    System.out.println("Max element "+extractMax());
    //    insert(5);
      //  Util.print(heap);
      //  System.out.println("Max element "+extractMax());
    }


}
