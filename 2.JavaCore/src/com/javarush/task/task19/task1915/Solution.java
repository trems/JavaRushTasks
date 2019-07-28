package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        PrintStream consoleStream = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream byteArrayStream = new PrintStream(byteArrayOutputStream);
        System.setOut(byteArrayStream);
        testString.printSomething();
        System.setOut(consoleStream);


        for (Byte b : byteArrayOutputStream.toByteArray()) {
            fileOutputStream.write(b);
            System.out.print((char)(byte) b);
        }
        consoleReader.close();
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

