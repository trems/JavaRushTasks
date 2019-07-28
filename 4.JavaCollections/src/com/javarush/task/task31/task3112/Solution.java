package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/home/mike/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3112"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream downloadStream = url.openStream();
        Path tmpFile = Files.createTempFile("tmp", "-jr");
        Files.copy(downloadStream, tmpFile, StandardCopyOption.REPLACE_EXISTING);
        Path resultPath = Paths.get(downloadDirectory.toAbsolutePath().toString() + urlString.substring(urlString.lastIndexOf('/')));
        return Files.move(tmpFile, resultPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
