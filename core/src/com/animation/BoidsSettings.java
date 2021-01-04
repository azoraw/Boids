package com.animation;

import lombok.Getter;

@Getter
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

    public void setNumberOfBoids(String numberOfBoidsString) {
        try {
            numberOfBoids = Integer.parseInt(numberOfBoidsString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setMaxSpeed(String maxSpeedString) {
        try {
            maxSpeed = Integer.parseInt(maxSpeedString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setInitSpeed(String initSpeedString) {
        try {
            initSpeed = Integer.parseInt(initSpeedString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setAlignmentForce(String alignmentForceString) {
        try {
            alignmentForce = Integer.parseInt(alignmentForceString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCohesionForce(String cohesionForceString) {
        try {
            cohesionForce = Integer.parseInt(cohesionForceString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCollisionRepulsionForce(String collisionRepulsionForceString) {
        try {
            collisionRepulsionForce = Integer.parseInt(collisionRepulsionForceString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCollidingRadius(String collidingRadiusString) {
        try {
            collidingRadius = Integer.parseInt(collidingRadiusString);
            if (collidingRadius > neighbourRadius) {
                neighbourRadius = collidingRadius;
            }
        } catch (NumberFormatException ignored) {
        }
    }

    public void setNeighbourRadius(String neighbourRadiusString) {
        try {
            neighbourRadius = Integer.parseInt(neighbourRadiusString);
            if (neighbourRadius < collidingRadius) {
                collidingRadius = neighbourRadius;
            }
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCircleRadius(String circleRadiusString) {
        try {
            circleRadius = Integer.parseInt(circleRadiusString);
        } catch (NumberFormatException ignored) {
        }
    }
}
