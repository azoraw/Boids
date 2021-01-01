package com.animation.util;

import java.util.Random;

public class RandomGen {

    private static final Random random = new Random();

    public static int getRandom(int max) {
        return random.nextInt(max);
    }
}
