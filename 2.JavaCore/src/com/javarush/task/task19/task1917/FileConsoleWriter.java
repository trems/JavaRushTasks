package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    public static void main(String[] args) throws IOException {
//        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1917/1");
//
//        fileConsoleWriter.write(100);
//        fileConsoleWriter.write("String str");
//        char[] cbuf = {'c', 'b','u','f','1','2','3','4','5'};
//        fileConsoleWriter.write(cbuf);
//        fileConsoleWriter.write("String str", 3, 5);
//        fileConsoleWriter.write(cbuf, 2,2);
//        fileConsoleWriter.close();
    }

    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(String file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(String file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor id) {
        this.fileWriter = new FileWriter(id);
    }

    public void write(char[] cbuf) throws IOException {
        for (Character ch : cbuf) {
            System.out.print(ch);
        }

        fileWriter.write(cbuf);
    }

    public void write(String str) throws IOException {
        System.out.print(str);
        fileWriter.write(str);
    }

    public void write(int c) throws IOException {
        System.out.print(c);
        fileWriter.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off+len; i++) {
            System.out.print(cbuf[i]);
        }

        fileWriter.write(cbuf, off, len);
    }

    public void write(String str, int off, int len) throws IOException {
        char[] cbuf = str.toCharArray();
        for (int i = off; i < off+len; i++) {
            System.out.print(cbuf[i]);
        }
        fileWriter.write(str, off, len);
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
