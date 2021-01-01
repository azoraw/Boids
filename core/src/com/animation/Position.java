package com.animation;

import com.animation.util.RandomGen;
import com.badlogic.gdx.Gdx;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import static com.animation.Config.*;

@Getter
class Position {

    private int x;
    private int y;
    private final Motion currentMotion;
    private int tmpDX;
    private int tmpDY;


    public Position() {
        x = RandomGen.getRandom(Gdx.graphics.getWidth());
        y = RandomGen.getRandom(Gdx.graphics.getHeight());
        currentMotion = new Motion();
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
                tmpDX += ALIGNMENT_FORCE;
            }
            if (neighbourDirection.getDx() < currentMotion.getDx()) {
                tmpDX -= ALIGNMENT_FORCE;
            }
            if (neighbourDirection.getDy() > currentMotion.getDy()) {
                tmpDY += ALIGNMENT_FORCE;
            }
            if (neighbourDirection.getDy() < currentMotion.getDy()) {
                tmpDY -= ALIGNMENT_FORCE;
            }
        }

    }

    private void goTowardsCenterOfMass(List<Position> positions) {
        for (Position position : positions) {
            if (position.getX() - x > 0) {
                tmpDX += COHESION_FORCE;
            }
            if (position.getX() - x < 0) {
                tmpDX -= COHESION_FORCE;
            }
            if (position.getY() - y > 0) {
                tmpDY += COHESION_FORCE;
            }
            if (position.getY() - y < 0) {
                tmpDY -= COHESION_FORCE;
            }
        }
    }

    private void doNotCollide(List<Position> positions) {
        for (Position position : positions) {
            if (Math.abs(position.getX() - x) < COLLIDING_RADIUS) {
                if (position.getX() - x > 0)
                    tmpDX -= COLLISION_REPULSION_FORCE;
                if (position.getX() - x < 0)
                    tmpDX += COLLISION_REPULSION_FORCE;
            }
            if (Math.abs(position.getY() - y) < COLLIDING_RADIUS) {
                if (position.getY() - y > 0)
                    tmpDY -= COLLISION_REPULSION_FORCE;
                if (position.getY() - y < 0)
                    tmpDY += COLLISION_REPULSION_FORCE;
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
