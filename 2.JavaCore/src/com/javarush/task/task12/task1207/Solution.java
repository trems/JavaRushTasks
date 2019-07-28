package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {

        print(4);
        print(new Integer(5));

    }

    //Напишите тут ваши методы
    static void print(int a) {
        System.out.println(a);
        System.out.println("int");
    }
    static void print(Integer a) {
        System.out.println(a);
        System.out.println("integer");
    }
}
