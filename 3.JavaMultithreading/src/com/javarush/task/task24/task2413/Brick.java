package com.javarush.task.task24.task2413;

public class Brick extends BaseObject {
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }
    public Brick(double x, double y) {
        super(x, y, 3);
    }

//    private static final int[][] matrix = {
//            {0, 0, 0, 0, 0},
//            {0, 1, 1, 1, 0},
//            {0, 1, 1, 1, 0},
//            {0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0},
//    };

    @Override
    public void draw(Canvas canvas) {
        //canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    @Override
    public void move() {

    }
}
