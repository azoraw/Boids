package com.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter {
    private Stage stage;

    public void create () {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        BoidsSettings boidsSettings = new BoidsSettings();

        stage.addActor(new GameActor(boidsSettings));
        stage.addActor(new SettingsTable(boidsSettings));
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }
}
