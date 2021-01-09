package com.animation;

import com.animation.util.RandomGen;
import lombok.Getter;

@Getter
public class Motion {

    private final BoidsSettings boidsSettings;
    private double dx;
    private double dy;

    public Motion(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGen.getRandom(2 * boidsSettings.getInitSpeed() + 1) - boidsSettings.getInitSpeed();
        dy = Math.sqrt(Math.pow(boidsSettings.getInitSpeed(), 2) - Math.pow(dx, 2)) * (RandomGen.nextBoolean() ? 1 : -1);
    }

    void setNewMotion(double newDX, double newDY) {
        dx = newDX;
        dy = newDY;
        limitSpeed();
    }

    private void limitSpeed() {
        double z = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        if (z > boidsSettings.getMaxSpeed()) {
            dx = (int) (dx * boidsSettings.getMaxSpeed() / z);
            dy = (int) (dy * boidsSettings.getMaxSpeed() / z);
        }
    }

}
