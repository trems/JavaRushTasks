package com.javarush.task.task22.task2213;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test extends Field {
    public test(int height, int width) {
        super(height, width);
    }

    public static void main(String[] args) {
        Field field = new Field(10, 10);
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                if (y < 4) field.setValue(x, y, 0);
                else if (y < 7) field.setValue(x, y, (int) (Math.random()*2));
                else field.setValue(x, y, 1);
            }
        }
        int[][] matrix = field.getMatrix();
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
        field.removeFullLines();
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
    }

}
