package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String file = consoleReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        String currntLine;
        while (fileReader.ready()) {
            currntLine = fileReader.readLine();
            int counter = 0;
            for (String word : currntLine.split("\\s+")) {
                if (words.contains(word)) counter++;
            }
            if (counter == 2) System.out.println(currntLine);
        }
        consoleReader.close();
        fileReader.close();

    }
}
