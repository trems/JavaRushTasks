package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private boolean sex;
        private double height;
        private int weight;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public Human(int age) {
            this.age = age;
        }

        public Human(String firstName, String lastName, int age, boolean sex, double height, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human(String firstName, String lastName, int age, boolean sex, double height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public Human(String firstName, String lastName, int age, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(double height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public Human(double height) {
            this.height = height;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }
    }
}
