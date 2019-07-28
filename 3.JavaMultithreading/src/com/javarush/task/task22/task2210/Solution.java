package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {



    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        StringBuilder s = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            list.add(token);

            //s.append(stringTokenizer.nextToken()).append(delimiter);
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
