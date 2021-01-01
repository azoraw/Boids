package com.animation.util;

public enum Direction {
    UPPER_LEFT,
    UP,
    UPPER_RIGHT,
    LEFT,
    RIGHT,
    DOWN_LEFT,
    DOWN,
    DOWN_RIGHT;

    public static Direction getRandomDirection() {
        return Direction.values()[RandomGen.getRandom(8)];
    }
}
