package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            TreeMap<String, Double> salaries = new TreeMap<>();

            String[] arr = new String[0];
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                arr = line.split(" ");
                if (!salaries.containsKey(arr[0])) {
                    salaries.put(arr[0], Double.parseDouble(arr[1]));
                } else salaries.put( arr[0], salaries.get(arr[0])+Double.parseDouble(arr[1]) );
            }
            double maxValue = salaries.get(arr[0]);

            for (Map.Entry<String, Double> entry : salaries.entrySet()) {
                if (maxValue < entry.getValue()) maxValue = entry.getValue();
            }
            for (Map.Entry<String, Double> entry : salaries.entrySet()) {
                if (entry.getValue() == maxValue) System.out.println(entry.getKey());
            }
            fileReader.close();

        }
    }
}
