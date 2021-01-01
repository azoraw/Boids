package com.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    Boids boids;

    @Override
    public void create() {
        boids = new Boids();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.RED);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Bird bird : boids.getBirds()) {
            shapeRenderer.circle(bird.getPosition().getX(), bird.getPosition().getY(), 10);
        }
        Bird exampleBird = boids.getBirds().get(0);
        for (Bird neighbour : exampleBird.getNeighbours()) {
            shapeRenderer.line(neighbour.getPosition().getX(), neighbour.getPosition().getY(), exampleBird.getPosition().getX(), exampleBird.getPosition().getY());
        }


        shapeRenderer.end();
        boids.move();
    }


    @Override
    public void dispose() {
    }
}
