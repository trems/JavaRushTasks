package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        while (true) {
            filename = reader.readLine();
            if (filename.equals("exit")) break;
            new ReadThread(filename).start();

        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(filename);
                int readByte;
                while (fis.available() > 0) {
                    readByte = fis.read();
                    if (!map.containsKey(readByte)) {
                        map.put(readByte, 1);
                    } else map.put(readByte, (map.get(readByte)+1));
                }
                int maxValue = 0;
                int byteWithMaxValue = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxValue) {
                        maxValue = entry.getValue();
                        byteWithMaxValue = entry.getKey();
                    }
                }
                fis.close();
                resultMap.put(filename, byteWithMaxValue);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
