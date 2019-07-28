package com.javarush.task.task17.task1721;

import java.awt.datatransfer.FlavorEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static String firstFile;
    static String secondFile;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstFile = reader.readLine();
        secondFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        while (fileReader.ready()) {
            allLines.add(fileReader.readLine());
        }
        fileReader = new BufferedReader(new FileReader(secondFile));
        while (fileReader.ready()) {
            forRemoveLines.add(fileReader.readLine());
        }
        reader.close();
        fileReader.close();
        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (String e : forRemoveLines) {
                allLines.remove(e);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

}
