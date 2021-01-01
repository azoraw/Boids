package com.animation.util;

import lombok.Getter;

@Getter
public class Motion {

    private int speed = 5;
    private int dx;
    private int dy;

    public Motion() {
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGen.getRandom(2 * speed + 1) - speed;
        dy = (int) Math.sqrt(Math.pow(speed, 2) - Math.pow(dx, 2)) * ( RandomGen.nextBoolean() ? 1 : -1 );
    }


}
