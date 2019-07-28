package com.javarush.task.task19.task1903;

public class test {
    public static void main(String[] args) {
        String a = "501234567";
        while (a.length() < 10) {
            a = "0" + a;
        }
        String f = String.format("+%s(%s)%s-%s-%s", "38", a.substring(0,3),
                a.substring(3,6), a.substring(6,8), a.substring(8));
        System.out.println(f);
    }
}
