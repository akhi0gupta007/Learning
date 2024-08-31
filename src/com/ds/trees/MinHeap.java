package com.ds.trees;

public class MinHeap {

	private static final int MAX = 6;
	int size = 0;
	int[] heap = new int[MAX];

	void insert(int data) {
		if (size == MAX) {
			throw new RuntimeException("Capacity Reached");
		}
		heap[size] = data;
		heapifyUp(size);
		size++;
	}

	private void heapifyDown(int index) {
		int smallest = index;
		int left = getLeftChild(index);
		int right = getRightChild(index);
		if (left < size && heap[smallest] > heap[left]) {
			smallest = left;
		}

		if (right < size && heap[smallest] > heap[right]) {
			smallest = right;
		}

		if (smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}

	}

	int extractMin() {
		if (size < 0) {
			throw new RuntimeException("Empty Heap");
		}
		int min = heap[0];
		heap[0] = heap[size - 1];
		heapifyDown(0);
		return min;
	}

	void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;

	}

	private void heapifyUp(int index) {
		while (index > 0 && heap[getParent(index)] > heap[index]) {
			swap(getParent(index), index);
			index = getParent(index);
		}

	}

	// Method to peek at the minimum element without removing it
	public int peekMin() {
		if (size == 0) {
			throw new RuntimeException("Heap is empty"); // Check if heap is empty
		}
		return heap[0]; // Return the root element
	}

	int getParent(int index) {
		return (index - 1) / 2;
	}

	int getLeftChild(int index) {
		return (2 * index + 1);
	}

	int getRightChild(int index) {
		return (2 * index + 2);
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(3); // Insert elements into the heap
		minHeap.insert(2);
		minHeap.insert(15);
		minHeap.insert(5);
		minHeap.insert(4);
		minHeap.insert(45);

		System.out.println("Minimum element: " + minHeap.peekMin()); // Peek minimum
		System.out.println("Extracted minimum: " + minHeap.extractMin()); // Extract minimum
		System.out.println("New minimum after extraction: " + minHeap.peekMin()); // Peek new minimum
	}

}
