package com.animation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameActor extends Actor {

    private final BoidsSettings boidsSettings;
    private final ShapeRenderer shapeRenderer;
    private Boids boids;

    public GameActor(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        boids = new Boids(boidsSettings);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.WHITE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        if (boids.shouldRestart()) {
            this.boids = new Boids(boidsSettings);
        }
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Bird bird : boids.getBirds()) {
            shapeRenderer.circle(bird.getPosition().getX(), bird.getPosition().getY(), boidsSettings.getCircleRadius());
        }
        shapeRenderer.end();
        boids.move();

        batch.begin();
    }
}
