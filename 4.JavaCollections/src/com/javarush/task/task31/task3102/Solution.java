package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        ArrayList<String> pathsToFiles = new ArrayList<>();
        Queue<File> directories = new ArrayDeque<>();
        directories.add(rootDir);
        Files.walk(rootDir.toPath(), Integer.MAX_VALUE).map(Path::toFile).filter(File::isFile).map(File::getAbsolutePath).forEach(pathsToFiles::add);


//        Iterator<File> iter = directories.iterator();
//        while (iter.hasNext()) {
//            for (File dir : directories) {
//                if (dir.listFiles() != null) {
//                    for (File f : dir.listFiles()) {
//                        if (f.isFile()) pathsToFiles.add(f.getAbsolutePath());
//                        if (f.isDirectory()) directories.add(f);
//                    }
//                    directories.remove(dir);
//                }
//            }
//            if (directories.isEmpty()) break;
//        }


        return pathsToFiles;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("/home/mike/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31");
        for (String s : list) {
            System.out.println(s);
        }
        
    }
}
