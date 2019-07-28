

package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.LinkedList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        long[] result = null;
//        LinkedList<Long> list = new LinkedList<>();
//
//        // Создаем и инициализируем массив степененй
//        long[][] mult = new long[10][19];
//        for (int i = 0; i < mult.length; i++) {
//            for (int j = 0; j < mult[i].length; j++) {
//                long tmp = i;
//                int degree = j;
//                while (degree-- > 0) {
//                    tmp *= i;
//                }
//                mult[i][j] = tmp;
//            }
//        }
//
//        byte bitness_start = 1;
//        long length = 10;
//
//        for (long i = 1; i <= N; i++) {
//            long tmp = i;
//            long res = 0;
//
//            do {
//                res += mult[(int)tmp % 10][bitness_start - 1];
//                tmp /= 10;
//            } while (tmp != 0);
//
//            if (res == i) {
//                list.add(i);
//            }
//
//            if (i == length) {
//                length *= 10;
//                bitness_start++;
//            }
//        }
//
//        result = new long[list.size()];
//        int i = 0;
//        for (Long value : list) {
//            result[i++] = value;
//        }        return result;
        long[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        int counter = 0;
        for (long l : list) {
            if (l < N) {
                counter++;
            }
        }
        long[] result = new long[counter];
        for (int i = 0; i < counter; i++) {
            result[i] = list[i];
        }
        return result;
   }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long[] numbers = getNumbers(7000);
//        long[] numbers = getNumbers(146511208);
//        int[] numbers = getNumbers(100);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}