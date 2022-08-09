package com.udemy;

import java.util.ArrayList;
import java.util.List;

import com.ds.TestProgram;

public class MergeSorted {

    public static List<Integer> merge(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                list.add(arr1[i]);
                i++;
            } else {
                list.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            list.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            list.add(arr2[j]);
            j++;
        }

        return list;
    }

    public static void merge2(int arr1[], int arr2[],int m) {
        int i = 0, j = 0;
        int empty_left = m;
        while (i < arr1.length && j < arr2.length) {
            int reached_empty = (arr1.length - empty_left);
            if(i == reached_empty){
                break;
            }

            if(arr1.length == 1 && arr1[i] == 0){
                   break; 
            }
            
            if (arr1[i] > arr2[j]) {
                replaceAndShift(arr1,arr2[j],i,m);                
                j++;
                i++;
                empty_left--;            
            }else{
                i++;
            }          

        }
        while(i < arr1.length && j < arr2.length){
            arr1[i] = arr2[j];
            i++;
            j++;
        }

    }

    private static void replaceAndShift(int[] arr1, int replace, int sf,int m) {
        System.out.printf("%nreplaceAndShift: replace : %d,sf : %d", replace,sf);
        System.out.println();
        TestProgram.printArray(arr1);        
        while(sf < arr1.length ){
            int temp = arr1[sf];
            arr1[sf] = replace;
            replace = temp;
            sf++;
        }
        System.out.println();
        System.out.println("Modified array after replace");
        TestProgram.printArray(arr1);
    }

    public static void main(String[] args) {
        //Test case 1
       /*  int arr1[]= {1,2,3,0,0,0};
        int arr2[]={2,5,6};
        merge2(arr1, arr2, 3);
        System.out.println("Final output");
        TestProgram.printArray(arr1); */

        //Test case 2
        int arr3[]= {-1,0,0,0,3,0,0,0,0,0,0};
        int arr4[]={-1,-1,0,0,1,2};
        merge2(arr3, arr4, 5);
        System.out.println("Final output");
        TestProgram.printArray(arr3);

    }
}
