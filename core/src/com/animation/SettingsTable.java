package com.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class SettingsTable extends Table {

    private final BoidsSettings boidsSettings;

    public SettingsTable(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        this.right().top();
        this.setFillParent(true);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        Label numberOfBoidsLabel = new Label("number of boids: ", skin);
        TextField numberOfBoidsTextField = new TextField(String.valueOf(boidsSettings.getNumberOfBoids()), skin);
        Label maxSpeedLabel = new Label("max speed: ", skin);
        TextField maxSpeedTextField = new TextField(String.valueOf(boidsSettings.getMaxSpeed()), skin);
        Label minSpeedLabel = new Label("min speed: ", skin);
        TextField minSpeedTextField = new TextField(String.valueOf(boidsSettings.getMinSpeed()), skin);
        Label alignmentForceLabel = new Label("alignment force: ", skin);
        TextField alignmentForceTextField = new TextField(String.valueOf(boidsSettings.getAlignmentForce()), skin);
        Label cohesionForceLabel = new Label("cohesion force: ", skin);
        TextField cohesionForceTextField = new TextField(String.valueOf(boidsSettings.getCohesionForce()), skin);
        Label collisionRepulsionForceLabel = new Label("collision repulsion force: ", skin);
        TextField collisionRepulsionForceTextField = new TextField(String.valueOf(boidsSettings.getCollisionRepulsionForce()), skin);
        Label collidingRadiusLabel = new Label("collision radius: ", skin);
        TextField collidingRadiusTextField = new TextField(String.valueOf(boidsSettings.getCollidingRadius()), skin);
        Label neighbourRadiusLabel = new Label("neighbour radius: ", skin);
        TextField neighbourRadiusTextField = new TextField(String.valueOf(boidsSettings.getNeighbourRadius()), skin);
        Label circleRadiusLabel = new Label("circle radius size: ", skin);
        TextField circleRadiusTextField = new TextField(String.valueOf(boidsSettings.getCircleRadius()), skin);

        numberOfBoidsTextField.addListener(event -> {
            boidsSettings.setNumberOfBoids(numberOfBoidsTextField.getText());
            return false;
        });

        maxSpeedTextField.addListener(event -> {
            boidsSettings.setMaxSpeed(maxSpeedTextField.getText());
            return false;
        });

        minSpeedTextField.addListener(event -> {
            boidsSettings.setMinSpeed(minSpeedTextField.getText());
            return false;
        });

        alignmentForceTextField.addListener(event -> {
            boidsSettings.setAlignmentForce(alignmentForceTextField.getText());
            return false;
        });

        cohesionForceTextField.addListener(event -> {
            boidsSettings.setCohesionForce(cohesionForceTextField.getText());
            return false;
        });

        collisionRepulsionForceTextField.addListener(event -> {
            boidsSettings.setCollisionRepulsionForce(collisionRepulsionForceTextField.getText());
            return false;
        });

        collidingRadiusTextField.addListener(event -> {
            boidsSettings.setCollidingRadius(collidingRadiusTextField.getText());
            neighbourRadiusTextField.setText(String.valueOf(boidsSettings.getNeighbourRadius()));
            return false;
        });

        neighbourRadiusTextField.addListener(event -> {
            boidsSettings.setNeighbourRadius(neighbourRadiusTextField.getText());
            collidingRadiusTextField.setText(String.valueOf(boidsSettings.getCollidingRadius()));
            return false;
        });

        circleRadiusTextField.addListener(event -> {
            boidsSettings.setCircleRadius(circleRadiusTextField.getText());
            return false;
        });

        this.add(numberOfBoidsLabel);
        this.add(numberOfBoidsTextField);
        this.row();
        this.add(maxSpeedLabel);
        this.add(maxSpeedTextField);
        this.row();
        this.add(minSpeedLabel);
        this.add(minSpeedTextField);
        this.row();
        this.add(alignmentForceLabel);
        this.add(alignmentForceTextField);
        this.row();
        this.add(cohesionForceLabel);
        this.add(cohesionForceTextField);
        this.row();
        this.add(collisionRepulsionForceLabel);
        this.add(collisionRepulsionForceTextField);
        this.row();
        this.add(collidingRadiusLabel);
        this.add(collidingRadiusTextField);
        this.row();
        this.add(neighbourRadiusLabel);
        this.add(neighbourRadiusTextField);
        this.row();
        this.add(circleRadiusLabel);
        this.add(circleRadiusTextField);
        this.row();
    }
}

