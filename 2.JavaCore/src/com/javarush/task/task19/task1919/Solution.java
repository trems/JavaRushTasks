package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            TreeMap<String, Double> salaries = new TreeMap<>();

            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] arr = line.split(" ");
                if (!salaries.containsKey(arr[0])) {
                    salaries.put(arr[0], Double.parseDouble(arr[1]));
                } else salaries.put( arr[0], salaries.get(arr[0])+Double.parseDouble(arr[1]) );
            }
            for (Map.Entry<String, Double> entry : salaries.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            fileReader.close();

        }
    }
}
