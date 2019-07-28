package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        ArrayList<String> words = new ArrayList<>();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split("\\s+")));
        }
        ArrayList<String> wordsForDel = new ArrayList<>(words);
//        Iterator<String> iterator = words.iterator();
//        while (iterator.hasNext()) {
//            String word = iterator.next().replace("\uFEFF", "");
//            String reversedWord = new StringBuilder(word).reverse().toString();
//            if (wordsForDel.contains(reversedWord)) {
//                result.add(new Pair(word, reversedWord));
//                wordsForDel.remove(reversedWord);
//                wordsForDel.remove(word);
//                iterator.remove();
//            }
//        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i).replace("\uFEFF", "");
            String reversedWord = new StringBuilder(word).reverse().toString();
            words.set(i, "null");
            if (words.contains(reversedWord) && word.length()>0) {
                Pair p = new Pair(word, reversedWord);
                System.out.println(p);
                result.add(p);
                words.set(words.indexOf(reversedWord), "null");
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
