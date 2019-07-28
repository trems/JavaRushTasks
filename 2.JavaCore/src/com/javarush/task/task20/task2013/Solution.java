package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.firstName = in.readUTF();
            this.lastName = in.readUTF();
            this.age = in.readInt();
            this.mother = (Person)in.readObject();
            this.father = (Person)in.readObject();
            this.children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2013/1");
//        FileOutputStream fos = new FileOutputStream("/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2013/2");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);



    }
}
