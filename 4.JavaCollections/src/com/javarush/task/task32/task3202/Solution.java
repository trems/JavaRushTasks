package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       //StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/home/mike/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task32/task3202/1"));
        StringWriter writer1 = getAllDataFromInputStream(null);
        System.out.println(writer.toString());
        System.out.println(writer1.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        StringWriter writer = new StringWriter();
        String s = "";
        try {
            if (is.available() > 0) {
                byte[] buf = new byte[is.available()];
                is.read(buf);
                s = new String(buf);
            }
        } catch (NullPointerException e) {
            writer.write(s);
        }

        writer.write(s);
        return writer;
    }
}