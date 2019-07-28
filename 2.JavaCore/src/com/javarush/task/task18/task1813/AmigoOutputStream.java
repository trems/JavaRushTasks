package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutputStream;

    @Override
    public void write(int b) throws IOException {
        this.fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.fileOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.flush();
        String message = "JavaRush © All rights reserved.";
        this.write(message.getBytes());
        this.fileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
