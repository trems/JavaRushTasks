package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        try {
            load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        for (Map.Entry<Object, Object> entry : p.entrySet()) {
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.fillInPropertiesMap();
        System.out.println(properties);
        s.save(new FileOutputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/2"));
    }
}
