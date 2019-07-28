package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            sb.append( (char) fileReader.read() );
        }
        String inputedStr = sb.toString();
        String[] arr = inputedStr.split("\\W");

        int counter = 0;
        for (String s : arr) {
            if (s.equals("world")) {
                counter++;
            }
        }
        System.out.println(counter);
        reader.close();
        fileReader.close();
    }
}
