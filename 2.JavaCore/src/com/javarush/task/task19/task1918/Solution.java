package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        fileReader.close();
        String htmlContent = sb.toString().replaceAll("\\n\\r", "");
        ArrayList<String> list = new ArrayList<>();

        Pattern tagPat = Pattern.compile("<(/|)"+tag+"(.*?)>");
        //Pattern closeTag = Pattern.compile("</"+tag+">");
        Matcher m = tagPat.matcher(htmlContent);
        //Matcher closeMatcher = closeTag.matcher(htmlContent);

        int nested = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        while (m.find()) {
            if (m.group().startsWith("<"+tag)) {
                indices.add(m.start());
                nested++;
            }
            if (m.group().startsWith("</"+tag+">")) {
                nested--;
                indices.add(m.end());
                if (nested == 0) {
                    for (int i = 0, j = indices.size() - 1; i < indices.size()/2; i++, j--) {
                        System.out.println(htmlContent.substring( indices.get(i) , indices.get(j) ));
                    }
                    indices.clear();
                }
            }
        }


    }
}
