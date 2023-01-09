package com.learn.gfg;

import com.ds.Util;

public class MaxHeap {
    static int arr[] = new int[100];
    static int size = 0;

    /**
     * @param data
     */
    static void insert(int data) {
        size++;
        if (size > 100)
            return;
        int index = size;
        arr[index] = data;
        while (index > 1) {
            int parent = index / 2;
            if (arr[parent] < arr[index]) {
                Util.swap2(arr, parent, index);
                index = parent;
            } else {
                return;
            }

        }

    }

    public static void main(String[] args) {
        Util.print(arr);
        insert(500);
        insert(10);
        insert(20);
        insert(50);
        insert(60);
        Util.print(arr);
    }
}
