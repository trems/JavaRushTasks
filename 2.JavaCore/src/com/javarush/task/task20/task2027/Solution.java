package com.javarush.task.task20.task2027;

import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        for (String word : words) {

        }

        return null;
    }
    public static Word detectWord(int[][] crossword, String word) {
        char[] chars = word.toCharArray();
        int charCounter = 0;
        int i = 0;
        int j = 0;
        int jLen = crossword[i].length;
        int iLen = crossword.length;
//        while (true) {
//            if (crossword[i][j] == chars[charCounter]) {
//
//            } else if (j != jLen-1) {
//                j++;
//            }
//        }

        return null;
    }
    //TODO рекурсивный поиск слева-направо, сверху-вниз, по диагонали слева направо.
    //     new Word() если успешно нашел.
    // recursive(int n) {
    //  if (n == 'char') recursive(n+1);

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
