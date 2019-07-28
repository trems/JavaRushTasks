package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> list = new HashMap<>();

        while (true) {
            Integer id;
            String input1 = reader.readLine();
            if (input1.isEmpty()) break;
            else id = Integer.parseInt(input1);

            String name = reader.readLine();
            if (name.isEmpty()) {
                list.put("", id);
                break;
            } else list.put(name, id);
            }



        for (HashMap.Entry<String, Integer> entry : list.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }


    }
}
