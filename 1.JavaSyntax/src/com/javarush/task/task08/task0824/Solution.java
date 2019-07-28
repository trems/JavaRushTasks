package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandpa1 = new Human("Ivan", true, 68);
        Human grandma1 = new Human("Olga", false, 68);
        Human grandpa2 = new Human("Alex", true, 70);
        Human grandma2 = new Human("Irina", false, 68);
        Human dad = new Human("Oleg", true, 46);
        Human mom = new Human("Marina", false, 44);
        Human son1 = new Human("Mike", true, 23);
        Human daughter1 = new Human("Teresa", false, 20);
        Human son2 = new Human("Igor", true, 18);
        ArrayList<Human> firstGenerationChildren1 = new ArrayList<>();
        ArrayList<Human> firstGenerationChildren2 = new ArrayList<>();
        ArrayList<Human> secondGenerationChildren = new ArrayList<>();
        grandma1.children = firstGenerationChildren1;
        grandpa1.children = firstGenerationChildren1;
        grandma2.children = firstGenerationChildren2;
        grandpa2.children = firstGenerationChildren2;
        dad.children = secondGenerationChildren;
        mom.children = secondGenerationChildren;
        firstGenerationChildren1.add(dad);
        firstGenerationChildren2.add(mom);
        secondGenerationChildren.add(son1);
        secondGenerationChildren.add(son2);
        secondGenerationChildren.add(daughter1);

        System.out.println(grandpa1);
        System.out.println(grandma1);
        System.out.println(grandpa2);
        System.out.println(grandma2);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(son1);
        System.out.println(daughter1);
        System.out.println(son2);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
