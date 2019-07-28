package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int readByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            if (!map.containsKey(readByte)) {
                map.put(readByte, 1);
            } else {
                map.put(readByte, map.get(readByte)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println((char)(int) entry.getKey() + " " + entry.getValue());
        }
        fis.close();


    }
}
