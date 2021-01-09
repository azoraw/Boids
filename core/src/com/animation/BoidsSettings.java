package com.animation;

import lombok.Getter;

@Getter
public class BoidsSettings {

    private int numberOfBoids = 100;

    private int maxSpeed = 10;
    private int initSpeed = 10;

    private double alignmentForce = 1;
    private double cohesionForce = 1;

    private double collisionRepulsionForce = 4;
    private int collidingRadius = 50;

    private int neighbourRadius = 100;

    private int circleRadius = 5;

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
            alignmentForce = Double.parseDouble(alignmentForceString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCohesionForce(String cohesionForceString) {
        try {
            cohesionForce =  Double.parseDouble(cohesionForceString);
        } catch (NumberFormatException ignored) {
        }
    }

    public void setCollisionRepulsionForce(String collisionRepulsionForceString) {
        try {
            collisionRepulsionForce =  Double.parseDouble(collisionRepulsionForceString);
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
