package com.animation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.animation.Config.NUMBER_OF_BOIDS;

@Getter
public class Boids {
    private final List<Bird> birds = new ArrayList<>();

    void whoIsNeighbour() {
        birds.forEach(
                bird -> bird.setNeighbours(birds.stream()
                                .filter(possibleNeighbour -> bird != possibleNeighbour
                                        && bird.isNeighbour(possibleNeighbour.getPosition()))
                                .collect(Collectors.toList()))
        );
    }

    public Boids() {
        for (int i = 0; i < NUMBER_OF_BOIDS; i++) {
            birds.add(new Bird());
        }
    }

    public void move() {
        whoIsNeighbour();
        for (Bird bird : birds) {
            bird.move();
        }
    }
}
