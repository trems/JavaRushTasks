package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        Arrays.sort(array);


        isGreaterThan("","");


    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
        int result = comparator.compare(a, b);

        return Boolean.parseBoolean(Integer.toString(result));
    }
}
