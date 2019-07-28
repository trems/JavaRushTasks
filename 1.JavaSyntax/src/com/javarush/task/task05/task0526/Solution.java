package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Mike", 24, "Langepas");
        Man man2 = new Man("Donald", 70, "Washington");
        Woman woman1 = new Woman("Elena", 26, "Troy");
        Woman woman2 = new Woman("Marina", 27, "SF");
        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    //напишите тут ваш код
    public static class Man {
        String name;
        int age;
        String address;

        public String toString() {
            return name + " " + age + " " + address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
