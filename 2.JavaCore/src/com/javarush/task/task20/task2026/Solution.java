package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

       int count1 = getRectangleCount(a1);
       System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 1");
    }

    public static int getRectangleCount(byte[][] a) {
        int arrLen = a.length;
        int rectCounter = 0;
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arrLen; j++) {
                if (a[i][j] == 1) {
                    rectCounter += detectAndMarkRect(a, i, j);
                }
            }
        }
        return rectCounter;
    }
    private static int detectAndMarkRect(byte[][] a, int iStart, int jStart) {
        byte mark = 'a';
        int i = iStart;
        int j = jStart;
        while (true) {
            if (a[i][j] == 1) {
                a[i][j] = mark;
                if (j != a.length-1) {
                    j++;
                    if (a[i][j] == 0) {
                        j = jStart;
                        if (i != a.length - 1) {
                            i++;
                        } else return 1;
                    }
                } else if (i != a.length-1) {
                    j = jStart;
                    i++;
                } else return 1;
            } else if (a[i][j] == 0) return 1;
        }

    }
}
