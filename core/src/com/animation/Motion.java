package com.animation;

import com.animation.util.RandomGen;
import lombok.Getter;

import static com.animation.Config.MAX_SPEED;
import static com.animation.Config.INIT_SPEED;

@Getter
public class Motion {

    private int dx;
    private int dy;

    public Motion() {
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGen.getRandom(2 * INIT_SPEED + 1) - INIT_SPEED;
        dy = (int) Math.sqrt(Math.pow(INIT_SPEED, 2) - Math.pow(dx, 2)) * (RandomGen.nextBoolean() ? 1 : -1);
    }

    void setNewMotion(int newDX, int newDY) {
        dx = newDX;
        dy = newDY;
        limitSpeed();
    }

    private void limitSpeed() {
        if (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)) > MAX_SPEED) {
            dx /= 2;
            dy /= 2;
        }
    }

}
