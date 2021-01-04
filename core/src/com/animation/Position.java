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

    private int x;
    private int y;
    private int tmpDX;
    private int tmpDY;


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
        tmpDX = currentMotion.getDx();
        tmpDY = currentMotion.getDy();

        goTowardsCenterOfMass(neighboursPosition);
        doNotCollide(neighboursPosition);
        alignWithOthers(neighboursPosition.stream()
                .map(Position::getCurrentMotion)
                .collect(Collectors.toList()));

        teleportToOtherSide();

        currentMotion.setNewMotion(tmpDX, tmpDY);
        x += currentMotion.getDx();
        y += currentMotion.getDy();
    }

    private void alignWithOthers(List<Motion> neighboursDirections) {
        for (Motion neighbourDirection : neighboursDirections) {
            if (neighbourDirection.getDx() > currentMotion.getDx()) {
                tmpDX += boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDx() < currentMotion.getDx()) {
                tmpDX -= boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() > currentMotion.getDy()) {
                tmpDY += boidsSettings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() < currentMotion.getDy()) {
                tmpDY -= boidsSettings.getAlignmentForce();
            }
        }

    }

    private void goTowardsCenterOfMass(List<Position> positions) {
        for (Position position : positions) {
            if (position.getX() - x > 0) {
                tmpDX += boidsSettings.getCohesionForce();
            }
            if (position.getX() - x < 0) {
                tmpDX -=  boidsSettings.getCohesionForce();
            }
            if (position.getY() - y > 0) {
                tmpDY +=  boidsSettings.getCohesionForce();
            }
            if (position.getY() - y < 0) {
                tmpDY -=  boidsSettings.getCohesionForce();
            }
        }
    }

    private void doNotCollide(List<Position> positions) {
        for (Position position : positions) {
            if (Math.abs(position.getX() - x) < boidsSettings.getCollidingRadius()) {
                if (position.getX() - x > 0)
                    tmpDX -= boidsSettings.getCollisionRepulsionForce();
                if (position.getX() - x < 0)
                    tmpDX += boidsSettings.getCollisionRepulsionForce();
            }
            if (Math.abs(position.getY() - y) < boidsSettings.getCollidingRadius()) {
                if (position.getY() - y > 0)
                    tmpDY -= boidsSettings.getCollisionRepulsionForce();
                if (position.getY() - y < 0)
                    tmpDY += boidsSettings.getCollisionRepulsionForce();
            }
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
}
