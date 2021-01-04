package com.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class SettingsTable extends Table {

    private final BoidsSettings boidsSettings;

    public SettingsTable(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        this.right().top();
        this.setFillParent(true);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        Label numberOfBoidsLabel = new Label("number of boids: ", skin);
        TextField numberOfBoidsTextField = new TextField(String.valueOf(boidsSettings.getNumberOfBoids()), skin);

        Button generateButton = new TextButton("save settings", skin);

        this.add(numberOfBoidsLabel);
        this.add(numberOfBoidsTextField);
        this.row();
        this.add(generateButton);
    }
}

