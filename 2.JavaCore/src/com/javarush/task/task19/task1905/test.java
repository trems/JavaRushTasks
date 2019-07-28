package com.javarush.task.task19.task1905;

public class test {
    public static void main(String[] args) {
        String a = "+38(050)123-45-67";
        a = a.replaceAll("\\D", "");
//
        System.out.println(a);
    }
}
