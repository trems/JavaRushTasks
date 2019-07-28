package com.javarush.task.task19.task1914;

/* 
Решаем пример
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
        String result = byteArrayOutputStream.toString();
        result = result.replaceAll("\\n", "");
        String[] numbers = result.split(" ");
        switch (numbers[1]) {
            case "+":
                result = result + sum(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[2]));
                break;
            case "-":
                result = result + substraction(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[2]));
                break;
            case "*":
                result = result + multiply(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[2]));
                break;
        }
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
    public static int sum(int a, int b) {
        return a + b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static int substraction(int a, int b) {
        return a - b;
    }
}

