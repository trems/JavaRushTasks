package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length > 1) {

            String resultFile = args[0];
            List<InputStream> inputStreamList = new ArrayList<>();
            ArrayList<String> paths = new ArrayList<>(args.length-1);
            for (int i = 1; i < args.length; i++) {
                paths.add(args[i]);
            }
            Collections.sort(paths, Comparator.comparing(o -> o.substring(o.lastIndexOf('.'))));
            for (String s : paths) {
                try {
                    inputStreamList.add(new FileInputStream(s));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


            try (ZipInputStream readZip = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreamList)));
                 FileOutputStream fos = new FileOutputStream(resultFile))
            {
                ZipEntry entry;
                while ( (entry = readZip.getNextEntry()) != null) {
                    byte[] buffer = new byte[1024];
                    int d;
                    while (true) {
                        d = readZip.read(buffer);
                        if (d == -1) break;
                        else fos.write(buffer, 0, d);
                    }
                    fos.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
