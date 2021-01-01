package com.animation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
class Bird {

    private final Position position = new Position();

    @Setter
    private List<Bird> neighbours = new ArrayList<>();

    void move() {
        position.moveRandomly();
        List<Position> neighboursPositions = neighbours.stream().map(Bird::getPosition).collect(Collectors.toList());
        position.goTowardsCenterOfMass(neighboursPositions);
        position.doNotCollide(neighboursPositions);
    }


    public boolean isNeighbour(Position possibleNeighbourPosition) {
        int x1 = position.getX();
        int x2 = possibleNeighbourPosition.getX();
        int y1 = position.getY();
        int y2 = possibleNeighbourPosition.getY();
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(Config.NEIGHBOUR_RADIUS, 2);
    }
}
