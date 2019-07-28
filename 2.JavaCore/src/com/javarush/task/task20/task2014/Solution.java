package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/1");
            fos = new FileOutputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/1");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Solution savedObject = new Solution(6);

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(fos);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.out.println("Some serialization exception");
        }
        if (oos != null) {
            oos.writeObject(savedObject);
        }
        Solution loadedObject = new Solution(10);
        if (ois != null) {
            loadedObject = (Solution) ois.readObject();
        }
        System.out.println("saved: "+savedObject.string);
        System.out.println("saved: "+loadedObject.currentDate);
        System.out.println("loaded: "+loadedObject.string);
        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
