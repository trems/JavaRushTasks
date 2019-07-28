package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream consoleStream = System.out;
        PrintStream arrayStream = new PrintStream(byteArrayOutputStream);
        System.setOut(arrayStream);
        int counter;
        testString.printSomething();
        System.setOut(consoleStream);
        String[] lines = byteArrayOutputStream.toString().split("\\n");
        for (int i = 0; i < lines.length; i++) {
            if (i != 0 && i % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
            System.out.println(lines[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
