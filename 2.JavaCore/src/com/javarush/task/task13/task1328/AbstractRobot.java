package com.javarush.task.task13.task1328;

import java.util.Random;

public abstract class AbstractRobot implements Attackable, Defensable {

    private static int hitCount = 0;



    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = new Random().nextInt(3);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 0) {
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = new Random().nextInt(3);

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 0) {
            defendedBodyPart = BodyPart.CHEST;
        }
        return defendedBodyPart;
    }





}
