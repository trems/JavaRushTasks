package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = consoleReader.readLine();
        String file2 = consoleReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));

        ArrayList<Integer> list = new ArrayList<>();
        String readString;
        while (fileReader.ready()) {
            readString = fileReader.readLine();
            for (String s : readString.split(" ")) {
                try {
                    list.add(Integer.parseInt(s));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
            sb.append(" ");
        }
        fileWriter.write(sb.toString());
        consoleReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
