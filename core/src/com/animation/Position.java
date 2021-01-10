package com.animation;

import com.animation.util.RandomGen;
import com.badlogic.gdx.Gdx;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
class Position {

    private final Motion currentMotion;
    private final BoidsSettings boidsSettings;

    private double x;
    private double y;
    private double tmpDX;
    private double tmpDY;


    public Position(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;

        x = RandomGen.getRandom(Gdx.graphics.getWidth());
        y = RandomGen.getRandom(Gdx.graphics.getHeight());
        currentMotion = new Motion(boidsSettings);
    }

    void move(List<Bird> neighbours) {
        List<Position> neighboursPosition = neighbours.stream()
                .map(Bird::getPosition)
                .collect(Collectors.toList());
        tmpDX = (int) currentMotion.getDx();
        tmpDY = (int) currentMotion.getDy();

        goTowardsCenterOfMass(neighboursPosition);
        doNotCollide(neighboursPosition.stream().filter(this::isTooClose).collect(Collectors.toList()));
        alignWithOthers(neighboursPosition.stream()
                .map(Position::getCurrentMotion)
                .collect(Collectors.toList()));

        teleportToOtherSide();

        currentMotion.setNewMotion(tmpDX, tmpDY);
        x += currentMotion.getDx();
        y += currentMotion.getDy();
    }

    private void alignWithOthers(List<Motion> neighboursDirections) {
        double alignDx = 0;
        double alignDy = 0;
        for (Motion neighbourDirection : neighboursDirections) {
            if (neighbourDirection.getDx() > currentMotion.getDx()) {
                alignDx += boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDx() < currentMotion.getDx()) {
                alignDx -= boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() > currentMotion.getDy()) {
                alignDy += boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() < currentMotion.getDy()) {
                alignDy -= boidsSettings.getAlignmentForce();
            }
        }
        if (neighboursDirections.size() != 0) {
            tmpDX += alignDx / neighboursDirections.size();
            tmpDY += alignDy / neighboursDirections.size();
        }
    }

    private void goTowardsCenterOfMass(List<Position> positions) {
        double cohesionDX = 0;
        double cohesionDY = 0;
        for (Position position : positions) {
            if (position.getX() - x > 0) {
                cohesionDX += boidsSettings.getCohesionForce();
            }
            if (position.getX() - x < 0) {
                cohesionDX -= boidsSettings.getCohesionForce();
            }
            if (position.getY() - y > 0) {
                cohesionDY += boidsSettings.getCohesionForce();
            }
            if (position.getY() - y < 0) {
                cohesionDY -= boidsSettings.getCohesionForce();
            }
        }
        if (positions.size() != 0) {
            tmpDX += cohesionDX / positions.size();
            tmpDY += cohesionDY / positions.size();
        }
    }

    private void doNotCollide(List<Position> positions) {
        double collisionDX = 0;
        double collisionDY = 0;
        for (Position position : positions) {
            if (Math.abs(position.getX() - x) < boidsSettings.getCollidingRadius()) {
                if (position.getX() - x > 0)
                    collisionDX -= boidsSettings.getCollisionRepulsionForce();
                if (position.getX() - x < 0)
                    collisionDX += boidsSettings.getCollisionRepulsionForce();
            }
            if (Math.abs(position.getY() - y) < boidsSettings.getCollidingRadius()) {
                if (position.getY() - y > 0)
                    collisionDY -= boidsSettings.getCollisionRepulsionForce();
                if (position.getY() - y < 0)
                    collisionDY += boidsSettings.getCollisionRepulsionForce();
            }
        }
        if (positions.size() != 0) {
            tmpDX += collisionDX / positions.size();
            tmpDY += collisionDY / positions.size();
        }
    }

    private void teleportToOtherSide() {
        if (x < 0) {
            x = Gdx.graphics.getWidth() - 1;
        }
        if (y < 0) {
            y = Gdx.graphics.getHeight() - 1;
        }
        if (x > Gdx.graphics.getWidth()) {
            x = 0;
        }
        if (y > Gdx.graphics.getHeight()) {
            y = 0;
        }
    }

    private void goAwayFromEdges() {
        int margin = 50;

        if (x < margin) {
            x++;
        }
        if (y < margin) {
            y++;
        }
        if (x + margin > Gdx.graphics.getWidth()) {
            x--;
        }
        if (y + margin > Gdx.graphics.getHeight()) {
            y--;
        }
    }

    public boolean isTooClose(Position possibleNeighbourPosition) {
        double x1 = x;
        double x2 = possibleNeighbourPosition.getX();
        double y1 = y;
        double y2 = possibleNeighbourPosition.getY();
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(boidsSettings.getCollidingRadius(), 2);
    }
}
