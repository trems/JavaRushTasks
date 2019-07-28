package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int winPoints = 0;
        winPoints = winPoints + (this.age - anotherCat.age);
        winPoints = winPoints + (this.weight - anotherCat.weight);
        winPoints = winPoints + (this.strength - anotherCat.strength);

        if (winPoints > 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {

    }
}
