package com.ds.trees;

import java.util.Arrays;

public class MinHeap2 {
    private int[] heap;    // Array to store the heap elements
    private int size;      // Current number of elements in the heap
    private int capacity;   // Maximum capacity of the heap

    // Constructor to initialize the min-heap with a specified capacity
    public MinHeap2(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity]; // Create the array for the heap
        size = 0; // Initially, the heap is empty
    }

    // Method to insert a new key into the heap
    public void insert(int key) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full"); // Check if heap is full
        }
        heap[size] = key; // Place the new key at the end of the heap
        size++; // Increase the size of the heap
        heapifyUp(size - 1); // Restore the min-heap property
    }

    // Method to remove and return the minimum element from the heap
    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty"); // Check if heap is empty
        }
        int min = heap[0]; // The root contains the minimum element
        heap[0] = heap[size - 1]; // Replace root with the last element
        size--; // Decrease the size of the heap
        heapifyDown(0); // Restore the min-heap property
        return min; // Return the minimum element
    }

    // Method to peek at the minimum element without removing it
    public int peekMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty"); // Check if heap is empty
        }
        return heap[0]; // Return the root element
    }

    // Helper method to maintain the min-heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index)); // Swap with parent if current is smaller
            index = parent(index); // Move up to the parent's index
        }
    }

    // Helper method to maintain the min-heap property after deletion
    private void heapifyDown(int index) {
        int smallest = index; // Start with the current index
        int left = leftChild(index); // Get the left child's index
        int right = rightChild(index); // Get the right child's index

        // Check if the left child is smaller than the current smallest
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left; // Update smallest index
        }
        // Check if the right child is smaller than the current smallest
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right; // Update smallest index
        }
        // If the smallest is not the current index, swap and continue
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Recursively heapify down
        }
    }

    // Helper method to get the index of the parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Main method to demonstrate the min-heap functionality
    public static void main(String[] args) {
        MinHeap2 minHeap = new MinHeap2(10); // Create a min-heap with capacity 10
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
