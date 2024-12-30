package com.learn.gfg;

import com.ds.Util;

public class MinHeap {

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


    public static int extractMin() {
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
            int smallest  = index;

            if(leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if(rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if(smallest != index) {
                swap(smallest, index);
                index = smallest;
            }else {
                break;
            }

        }

    }


    private static void shiftUp(int index) {
        while(index > 0) {
            int parent = (index - 1)/2;
            if(heap[parent] > heap[index]) {
                swap( parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    public static void heapifyUp(int index) {
        if(index < 0) return;
        int parent = (index - 1)/2;
        if(heap[parent] > heap[index]) {
            swap( parent, index);
            heapifyUp(parent);
        }
    }


    // Helper method to swap two elements in the heap
    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void delete(int index) {
        if(size <= 0) {
            throw new RuntimeException("Empty heap");
        }

        heap[index] = heap[size-1];
        size--;
        heapifyUp(size);
    }


    public static void main(String[] args) {
        Util.print(heap);
        insert(5);
        insert(8);
        insert(9);
        insert(12);
        insert(14);
        insert(20);
        insert(40);
        Util.print(heap);
        delete(3);
        Util.print(heap);
        //    System.out.println("Max element "+extractMax());
        //    insert(5);
        //  Util.print(heap);
        //  System.out.println("Max element "+extractMax());
    }


}
