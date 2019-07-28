package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
//    public static void main(String[] args) throws IOException {
//
//        if (args.length >= 2) {
//            ArrayList<File> less50kb;
//            File path = new File(args[0]);
//            File resultFileAbsolutePath = new File(args[1]);
//            resultFileAbsolutePath = renameTargetFile(resultFileAbsolutePath);
//            FileOutputStream fos = new FileOutputStream(resultFileAbsolutePath.getAbsolutePath(), true);
//            less50kb = getSortedFilesLessThan51byte(path);
//            copyFilesContent(less50kb, resultFileAbsolutePath, fos);
//            fos.close();
//
//        }
//
//    }
//
//    public static ArrayList<File> getSortedFilesLessThan51byte(File path) {
//        ArrayList<File> allFiles = new ArrayList<>();
//        listFiles(path, allFiles);
//
//        ArrayList<File> less51byte = new ArrayList<>();
//        for (File file : allFiles) {
//            if (file.length() <= 50 && file.isFile()) {
//                less51byte.add(file);
//            }
//        }
//        less51byte.sort(Comparator.comparing(File::getName));
//        return less51byte;
//    }
//    public static void listFiles(File directory, List<File> files) {
//        File[] fList = directory.listFiles();
//        if(fList != null)
//            for (File file : fList) {
//                if (file.isFile()) {
//                    files.add(file);
//                } else if (file.isDirectory()) {
//                    listFiles(file.getAbsoluteFile(), files);
//                }
//            }
//    }
//    public static void copyFilesContent(List<File> files, File target, FileOutputStream fos) throws IOException {
//        for (File file : files) {
//            try (FileInputStream fis = new FileInputStream(file))
//            {
//                while (fis.available() > 0) {
//                    fos.write(fis.read());
//                }
//                fos.write('\n');
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        fos.close();
//    }
//
//    public static File renameTargetFile(File target) {
//        String absolutePath = target.getAbsolutePath().replaceAll(target.getName()+"$", "");
//        File resultFileAbsolutePath = new File(target.getParent()+"/allFilesContent.txt");
//        FileUtils.renameFile(target, resultFileAbsolutePath);
//        return resultFileAbsolutePath;
//    }

    public static void main(String[] args) throws IOException {
        ArrayList<File> fileList = new ArrayList<>();
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            fillFileList(path.getPath(), fileList);
            fileList.sort(new FileNameComparator());

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }


    //Рекурсивно пробегаем поддиректории и заполняем список файлов
    private static void fillFileList(String path, List<File> fileList) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath(), fileList);
                continue;
            }
            if (file.length() <= 50)
                fileList.add(file);
        }
    }
}

//Компаратор для сравнения
class FileNameComparator implements Comparator<File> {
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}
