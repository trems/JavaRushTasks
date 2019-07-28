package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String txtFormat = ".txt";
        String fileFormat = fileName.substring(fileName.length()-4);
        if (fileFormat.equals(txtFormat)) {
            this.fileInputStream = new FileInputStream(fileName);
        } else {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {
    }
}

