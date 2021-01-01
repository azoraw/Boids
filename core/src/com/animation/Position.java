package com.animation;

import com.animation.util.Motion;
import com.animation.util.RandomGen;
import com.badlogic.gdx.Gdx;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.animation.Config.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
class Position {

    private int x;
    private int y;

    static Position randomPosition() {
        return new Position(
                RandomGen.getRandom(Gdx.graphics.getWidth()),
                RandomGen.getRandom(Gdx.graphics.getHeight())
        );
    }

    void moveRandomly() {
        Motion motion = new Motion();
        x+=motion.getDx();
        y+=motion.getDy();
        goAwayFromEdges();
        teleportToOtherSide();
    }

    void goTowardsCenterOfMass(List<Position> positions) {
        for (Position position : positions) {
            if (position.getX() - x > 0) {
                x++;
            }
            if (position.getX() - x < 0) {
                x--;
            }
            if (position.getY() - y > 0) {
                y++;
            }
            if (position.getY() - y < 0) {
                y--;
            }
        }
    }

    void doNotCollide(List<Position> positions) {
        for (Position position : positions) {
            if (Math.abs(position.getX() - x) < 50) {
                if (position.getX() - x > 0)
                    x--;
                if (position.getX() - x < 0)
                    x++;
            }
            if (Math.abs(position.getY() - y) < 30) {
                if (position.getY() - y > 0)
                    y--;
                if (position.getY() - y < 0)
                    y++;
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
