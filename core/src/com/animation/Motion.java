package com.animation;

import com.animation.util.RandomGen;
import lombok.Getter;

@Getter
public class Motion {

    private final int speed = 1;

    private int dx;
    private int dy;

    public Motion() {
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGen.getRandom(2 * speed + 1) - speed;
        dy = (int) Math.sqrt(Math.pow(speed, 2) - Math.pow(dx, 2)) * ( RandomGen.nextBoolean() ? 1 : -1 );
    }

    void setNewMotion(int newDX, int newDY) {
        dx = newDX;
        dy = newDY;
    }

}
