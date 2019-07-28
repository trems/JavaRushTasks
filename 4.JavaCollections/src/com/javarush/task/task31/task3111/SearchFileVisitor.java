package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String strContent = new String(content);
        boolean nameFilter = false;
        boolean contentFilter = false;
        boolean minSizeFilter = false;
        boolean maxSizeFilter = false;

        if (partOfName == null) nameFilter = true;
        else if (file.getFileName().toString().contains(partOfName)) nameFilter = true;

        if (partOfContent == null) contentFilter = true;
        else if (strContent.contains(partOfContent)) contentFilter = true;

        if (minSize == -1) minSizeFilter = true;
        else if (content.length > minSize) minSizeFilter = true;

        if (maxSize == -1) maxSizeFilter = true;
        else if (content.length < maxSize) maxSizeFilter = true;

        if (nameFilter && contentFilter && minSizeFilter && maxSizeFilter) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
