package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Cat tomCat = new Cat("Tom", 28, jerryMouse);
        Dog guardianDog = new Dog("Bobik", 143, tomCat);
   }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
    public static class Cat {
        String name;
        int height;
        Mouse target;

        public Cat(String name, int height, Mouse target) {
            this.name = name;
            this.height = height;
            this.target = target;
        }
    }

    public static class Dog {
        String name;
        int fearedCats;
        Cat target;

        public Dog(String name, int fearedCats, Cat target) {
            this.name = name;
            this.fearedCats = fearedCats;
            this.target = target;
        }
    }
}
