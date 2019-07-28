package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    static int dirsCounter = 0;
    static int filesCounter = 0;
    static int size = 0;
    static Path root;

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (dir != root) {
            dirsCounter++;
        }

        return super.postVisitDirectory(dir, exc);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        filesCounter++;
        size += Files.size(file);
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        root = Paths.get(reader.readLine());
        if (!Files.isDirectory(root)) {
            System.out.println(root + " - не папка");
            return;
        } else {
            Files.walkFileTree(root, solution);

            System.out.println("Всего папок - "+dirsCounter);
            System.out.println("Всего файлов - "+filesCounter);
            System.out.println("Общий размер - "+size);
        }


    }
}
