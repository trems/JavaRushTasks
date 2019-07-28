package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       // PrintStream testStream = new PrintStream(byteArrayOutputStream);
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        //String result = byteArrayOutputStream.toString();
        System.setOut(consoleStream);
        //System.out.println(result.toUpperCase());
        System.out.println(byteArrayOutputStream.toString().toUpperCase());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
