package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);
        HashMap<Integer, Integer> byteMap = new HashMap<>();
        int currentByte;
        while (fis.available() > 0) {
            currentByte = fis.read();
            if (!byteMap.containsKey(currentByte)) {
                byteMap.put(currentByte, 1);
            } else byteMap.put(currentByte, (byteMap.get(currentByte)+1));
        }
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {
            if (entry.getValue() == maxFreq) System.out.print(entry.getKey() + " ");
        }
        fis.close();

    }
}
