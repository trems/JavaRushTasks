package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name = null;
    private String address = null;
    private String color = "black";
    private int age = 3;
    private int weight = 4;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void initialize(int weight, String color) {
        this.color = color;
        this.weight = weight;
    }

    public void initialize(int weight, String color, String address) {
        this.color = color;
        this.weight = weight;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
