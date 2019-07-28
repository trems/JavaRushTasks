package com.javarush.task.task21.task2101;

public class Test {
    public static void main(String[] args) {
        int i = 255;
        int ip = 192;
        int res = i & ip;
        System.out.println(Integer.toBinaryString(res));
    }
}
