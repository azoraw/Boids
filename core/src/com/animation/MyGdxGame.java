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

import static com.animation.Config.CIRCLE_RADIUS;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    Boids boids;

    @Override
    public void create() {
        boids = new Boids();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.WHITE);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Bird bird : boids.getBirds()) {
            shapeRenderer.circle(bird.getPosition().getX(), bird.getPosition().getY(), CIRCLE_RADIUS);
        }


        shapeRenderer.end();
        boids.move();
    }
}
