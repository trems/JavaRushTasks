package com.javarush.task.task20.task2016;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Минимум изменений
*/
public class Solution {
    public static class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
//        C c = new C("ser");
//        FileOutputStream fos = new FileOutputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2016/1");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(c);


    }
}
