package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));

        String content;
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }


        Pattern pattern;
        Matcher matcher;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            pattern = Pattern.compile("^("+entry.getKey()+")\\s+");
            matcher = pattern.matcher(sb.toString());
            while (matcher.find()) {
              //  System.out.println(matcher.group()+ ":" + matcher.group(1));
                sb.replace(matcher.start(), matcher.end(1), entry.getValue());
            }

        }
        String result = sb.toString();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            pattern = Pattern.compile("\\s("+entry.getKey()+")[^a-zA-Z_0-9]");
            matcher = pattern.matcher(result);
            while (matcher.find()) {
                //System.out.println(matcher.group()+ ":" + matcher.group(1));
              //  System.out.println(matcher.start(1)+", "+ matcher.end(1));
                result = matcher.replaceAll(matcher.group().replace(String.valueOf(entry.getKey()), entry.getValue()));
               // System.out.println(sb.toString());
            }
        }
        System.out.println(result);
        reader.close();
        fileReader.close();

    }
}
