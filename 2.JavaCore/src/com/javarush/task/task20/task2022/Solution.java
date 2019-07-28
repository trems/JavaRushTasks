package com.javarush.task.task20.task2022;

import javax.sound.sampled.SourceDataLine;
import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution1 = new Solution("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/1");
        solution1.writeObject("String1");

        FileOutputStream fos = new FileOutputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/2");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/2"));
        Solution solution2 = (Solution)ois.readObject();
        solution2.writeObject("Another string");

    }
}
