package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length >= 2) {
            String filename = args[0];
            Path fileToArchive = Paths.get(filename);
            String archive = args[1];
            //String targetArch = "/home/mike/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3105/testi/target.zip";
            HashMap<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();

            try (ZipInputStream readZip = new ZipInputStream(new FileInputStream(archive)))
            {
                ZipEntry entry;
                while ((entry = readZip.getNextEntry()) != null) {
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int d;
                    while (true) {
                        d = readZip.read(buffer);
                        if (d == -1) break;
                        else byteArray.write(buffer, 0, d);
                    }
                    //if (!("new/"+entry.getName()).equalsIgnoreCase("new/"+fileToArchive.getFileName())) map.put(entry, byteArray);
                    map.put(entry, byteArray);
                }
            }

            try (ZipOutputStream writeZip = new ZipOutputStream(new FileOutputStream(archive)))
            {
                writeZip.putNextEntry(new ZipEntry("new/"+fileToArchive.getFileName()));
                Files.copy(fileToArchive, writeZip);
                for(Map.Entry<ZipEntry, ByteArrayOutputStream> entry : map.entrySet()) {
                    if (!entry.getKey().getName().endsWith(fileToArchive.getFileName().toString())) {
                        writeZip.putNextEntry(new ZipEntry(entry.getKey().getName()));
                        writeZip.write(entry.getValue().toByteArray());
                    }
                }
                writeZip.finish();
            }

        }

    }
}
