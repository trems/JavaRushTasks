package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            if (args[0].equals("-d")) {
                String filename = getFileName();
                deleteProduct(filename, args[1]);
            } else if (args[0].equals("-u")) {
                String filename = getFileName();
                updateProduct(filename, args);
            }
        }

    }

    public static String getFileName() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();
        return filename;
    }
    public static String buildResultString(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(args[1]);
        while (sb.length() < 8) sb.append(" ");
        sb.append(args[2]);
        while (sb.length() < 38) sb.append(" ");
        sb.append(args[3]);
        while (sb.length() < 46) sb.append(" ");
        sb.append(args[4]);
        while (sb.length() < 50) sb.append(" ");

        return sb.toString();
    }
    public static void deleteProduct(String filename, String productId) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        ArrayList<String> list = new ArrayList<>();
        String currentId;
        String currentLine;
        while ((currentLine = fileReader.readLine()) != null) {
            currentId = currentLine.substring(0,8).trim();
            if (!currentId.equals(productId)) {
                list.add(currentLine);
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
        for (String s : list) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileReader.close();
        fileWriter.close();
    }
    public static void updateProduct(String filename, String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        ArrayList<String> list = new ArrayList<>();
        String productId = args[1];
        String currentId;
        String currentLine;
        while ((currentLine = fileReader.readLine()) != null) {
            currentId = currentLine.substring(0,8).trim();
            if (!currentId.equals(productId)) {
                list.add(currentLine);
            } else {
                String result = buildResultString(args);
                list.add(result);
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
        for (String s : list) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileReader.close();
        fileWriter.close();
    }
}

