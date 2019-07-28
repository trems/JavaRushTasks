package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {

    private double speed;
    private double direction;

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    public void draw(Canvas canvas) {
        
    }

    @Override
    public void move() {
        double dx = speed * direction;
        x = x + dx;

      //  checkBorders(radius, Arcanoid.game.getWidth() - radius + 1, 1, Arcanoid.game.getHeight() + 1);
    }
    public void moveLeft() {
        direction = -1;
    }

    /**
     * direction устанавливается равным +1
     */
    public void moveRight() {
        direction = 1;
    }


    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
