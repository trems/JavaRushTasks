package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {
    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if (isFrozen) {
            return;
        }

        x += dx;
        y += dy;


    }
    private void checkRebound(int minx, int maxx, int miny, int maxy) {

    }
    public void setDirection(double direction) {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }
    public void start() {
      //  this.setDirection(direction);
        this.isFrozen = false;
    }
    //скорость
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    //заморожен ли объект или может двигаться
    private boolean isFrozen;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
