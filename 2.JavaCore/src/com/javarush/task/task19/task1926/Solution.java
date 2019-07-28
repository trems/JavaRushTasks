package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] strArr = line.split("");
            List<String> strList = Arrays.asList(strArr);
            Collections.reverse(strList);
            for (String s : strList) {
                System.out.print(s);
            }
            System.out.println();
        }
        reader.close();
        fileReader.close();
    }
}
