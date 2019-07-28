package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> arrays = new ArrayList<>(5);
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2};
        int[] arr3 = {1,2,3,4};
        int[] arr4 = {1,2,3,4,5,6,7};
        int[] arr5 = {};
        arrays.add(arr1);
        arrays.add(arr2);
        arrays.add(arr3);
        arrays.add(arr4);
        arrays.add(arr5);
        return arrays;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
