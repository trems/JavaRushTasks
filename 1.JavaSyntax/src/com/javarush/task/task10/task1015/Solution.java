package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] listArr;
        listArr = new ArrayList[3];
        listArr[0] = new ArrayList<String>();
        listArr[1] = new ArrayList<String>();
        listArr[2] = new ArrayList<String>();
        listArr[0].add("dfsf");
        listArr[0].add("dfsdfsf");
        listArr[1].add("dfsffsdf");
        listArr[1].add("fsdvvsd");
        listArr[2].add("dvfbgfbvdfv");
        listArr[2].add("vsdvsdc");

        return listArr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}