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
        numberOfBoidsTextField.addListener(event -> {
            boidsSettings.setNumberOfBoids(Integer.parseInt(numberOfBoidsTextField.getText()));
            return false;
        });
        this.add(numberOfBoidsLabel);
        this.add(numberOfBoidsTextField);
        this.row();

        Label maxSpeedLabel = new Label("max speed: ", skin);
        TextField maxSpeedTextField = new TextField(String.valueOf(boidsSettings.getMaxSpeed()), skin);
        maxSpeedTextField.addListener(event -> {
            boidsSettings.setMaxSpeed(Integer.parseInt(maxSpeedTextField.getText()));
            return false;
        });
        this.add(maxSpeedLabel);
        this.add(maxSpeedTextField);
        this.row();

        Label initSpeedLabel = new Label("init speed: ", skin);
        TextField initSpeedTextField = new TextField(String.valueOf(boidsSettings.getInitSpeed()), skin);
        initSpeedTextField.addListener(event -> {
            boidsSettings.setInitSpeed(Integer.parseInt(initSpeedTextField.getText()));
            return false;
        });
        this.add(initSpeedLabel);
        this.add(initSpeedTextField);
        this.row();

        Label alignmentForceLabel = new Label("alignment force: ", skin);
        TextField alignmentForceTextField = new TextField(String.valueOf(boidsSettings.getAlignmentForce()), skin);
        alignmentForceTextField.addListener(event -> {
            boidsSettings.setAlignmentForce(Integer.parseInt(alignmentForceTextField.getText()));
            return false;
        });
        this.add(alignmentForceLabel);
        this.add(alignmentForceTextField);
        this.row();

        Label cohesionForceLabel = new Label("cohesion force: ", skin);
        TextField cohesionForceTextField = new TextField(String.valueOf(boidsSettings.getCohesionForce()), skin);
        cohesionForceTextField.addListener(event -> {
            boidsSettings.setCohesionForce(Integer.parseInt(cohesionForceTextField.getText()));
            return false;
        });
        this.add(cohesionForceLabel);
        this.add(cohesionForceTextField);
        this.row();

        Label collisionRepulsionForceLabel = new Label("collision repulsion force: ", skin);
        TextField collisionRepulsionForceTextField = new TextField(String.valueOf(boidsSettings.getCollisionRepulsionForce()), skin);
        collisionRepulsionForceTextField.addListener(event -> {
            boidsSettings.setCollisionRepulsionForce(Integer.parseInt(collisionRepulsionForceTextField.getText()));
            return false;
        });
        this.add(collisionRepulsionForceLabel);
        this.add(collisionRepulsionForceTextField);
        this.row();

        Label collidingRadiusLabel = new Label("collision radius: ", skin);
        TextField collidingRadiusTextField = new TextField(String.valueOf(boidsSettings.getCollidingRadius()), skin);
        collidingRadiusTextField.addListener(event -> {
            boidsSettings.setCollidingRadius(Integer.parseInt(collidingRadiusTextField.getText()));
            return false;
        });
        this.add(collidingRadiusLabel);
        this.add(collidingRadiusTextField);
        this.row();

        Label neighbourRadiusLabel = new Label("neighbour radius: ", skin);
        TextField neighbourRadiusTextField = new TextField(String.valueOf(boidsSettings.getNeighbourRadius()), skin);
        neighbourRadiusTextField.addListener(event -> {
            boidsSettings.setNeighbourRadius(Integer.parseInt(neighbourRadiusTextField.getText()));
            return false;
        });
        this.add(neighbourRadiusLabel);
        this.add(neighbourRadiusTextField);
        this.row();

        Label circleRadiusLabel = new Label("circle radius size: ", skin);
        TextField circleRadiusTextField = new TextField(String.valueOf(boidsSettings.getCircleRadius()), skin);
        circleRadiusTextField.addListener(event -> {
            boidsSettings.setCircleRadius(Integer.parseInt(circleRadiusTextField.getText()));
            return false;
        });
        this.add(circleRadiusLabel);
        this.add(circleRadiusTextField);
        this.row();
    }
}

