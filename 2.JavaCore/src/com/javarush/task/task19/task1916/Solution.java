package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = consoleReader.readLine();
        String file2 = consoleReader.readLine();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        while (fileReader1.ready()) {
            list1.add(fileReader1.readLine());
        }
        while (fileReader2.ready()) {
            list2.add(fileReader2.readLine());
        }
        int nextLine1 = 0;
        int nextLine2 = 0;

        for (int i = 0; i < list1.size()+list2.size(); i++) {
            try {
                if (nextLine1 == list1.size() && nextLine2 < list2.size()) {
                    lines.add(new LineItem(Type.ADDED, list2.get(nextLine2)));
                    nextLine2++;
                } else if (nextLine2 == list2.size() && nextLine1 < list1.size()) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(nextLine1)));
                    nextLine1++;
                } else if (list1.get(nextLine1).equals(list2.get(nextLine2))) {
                    lines.add(new LineItem(Type.SAME, list1.get(nextLine1)));
                    nextLine1++;
                    nextLine2++;
                } else if (list2.get(nextLine2).equals(list1.get(nextLine1 + 1))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(nextLine1)));
                    nextLine1++;
                } else if (list1.get(nextLine1).equals(list2.get(nextLine2 + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(nextLine2)));
                    nextLine2++;
                }
            } catch (IndexOutOfBoundsException e) {

            }

        }

//        for (LineItem i : lines) {
//            System.out.println(i);
//        }
        consoleReader.close();
        fileReader1.close();
        fileReader2.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + ", " + line;
        }
    }
}
