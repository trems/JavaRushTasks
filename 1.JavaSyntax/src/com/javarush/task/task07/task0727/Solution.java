package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            if (s.length() % 2 == 0) {
                s = s + " " + s;
            } else s = s + " " + s + " " + s;
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
