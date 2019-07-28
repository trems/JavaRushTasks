package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o) {
        double deltaX = this.getX() - o.getX();
        double deltaY = this.getY() - o.getY();
        double distanceBetween = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        if (distanceBetween <= Math.max(this.getRadius(), o.getRadius())) return true;
        else return false;
    }
}
