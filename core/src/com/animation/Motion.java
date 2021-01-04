package com.animation;

import com.animation.util.RandomGen;
import lombok.Getter;

@Getter
public class Motion {

    private final BoidsSettings boidsSettings;
    private int dx;
    private int dy;

    public Motion(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGen.getRandom(2 * boidsSettings.getInitSpeed() + 1) - boidsSettings.getInitSpeed();
        dy = (int) Math.sqrt(Math.pow(boidsSettings.getInitSpeed(), 2) - Math.pow(dx, 2)) * (RandomGen.nextBoolean() ? 1 : -1);
    }

    void setNewMotion(int newDX, int newDY) {
        dx = newDX;
        dy = newDY;
        limitSpeed();
    }

    private void limitSpeed() {
        if (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)) > boidsSettings.getMaxSpeed()) {
            dx /= 2;
            dy /= 2;
        }
    }

}
