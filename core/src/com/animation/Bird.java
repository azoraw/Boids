package com.animation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Bird {

    private final BoidsSettings boidsSettings;
    private final Position position;

    @Setter
    private List<Bird> neighbours = new ArrayList<>();

    public Bird(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        this.position = new Position(boidsSettings);
    }

    void move() {
        position.move(neighbours);
    }


    public boolean isNeighbour(Position possibleNeighbourPosition) {
        int x1 = position.getX();
        int x2 = possibleNeighbourPosition.getX();
        int y1 = position.getY();
        int y2 = possibleNeighbourPosition.getY();
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(boidsSettings.getNeighbourRadius(), 2);
    }
}
