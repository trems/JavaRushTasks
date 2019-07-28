package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   //     String file = "/home/mike/IdeaProjects/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2209/1";
       String file = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder inputString = new StringBuilder();
        while (fileReader.ready()) {
            inputString.append(fileReader.readLine());
        }
        String[] words = inputString.toString().trim().replaceAll("\\s{2,}", " ").split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int loopCounter = 0;
        int needIterates = words.length * words.length;
        if (words.length == 0) return sb;

        while (true) {
            for (int i = 0; i < words.length; i++) {
                sb.append(words[i]);
                for (int j = 0; j < words.length; j++) {
                    if (!sb.toString().contains(words[j])) {
                        if (sb.substring(sb.length()-1).equalsIgnoreCase(words[j].substring(0, 1))) {
                            sb.append(" ").append(words[j]);
                        }
                    }
                    if (j == words.length-1 && loopCounter <= needIterates) {
                        j = 0;
                    }
                    loopCounter++;
                }
                loopCounter = 0;
                if (sb.length() > result.length()) result = new StringBuilder(sb);
                if (words.length != sb.toString().split(" ").length) sb.delete(0, sb.length());
                else return result;
            }
            return result;
        }

    }
}
