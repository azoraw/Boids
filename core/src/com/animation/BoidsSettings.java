package com.animation;

import lombok.Data;

@Data
public class BoidsSettings {

    private int numberOfBoids = 1000;

    private int maxSpeed = 15;
    private int initSpeed = 5;

    private int alignmentForce = 1;
    private int cohesionForce = 1;

    private int collisionRepulsionForce = 2;
    private int collidingRadius = 50;

    private int neighbourRadius = 100;

    private int circleRadius = 10;
}
