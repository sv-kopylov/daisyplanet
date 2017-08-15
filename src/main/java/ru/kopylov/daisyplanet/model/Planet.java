package ru.kopylov.daisyplanet.model;

import ru.kopylov.daisyplanet.utils.Conditions;



/**
 * Created by sergey on 10.08.17.
 */
public class Planet {
    Starr star;
    Area[] areas;

    // Metrics
    private double albedo = 0;
    private double temperature = 0;

    // parameters
    private double radius = Conditions.getInstance().getDoubleProperty("radius");
    private int halfFragmentation = Conditions.getInstance().getIntProperty("halfFragmentation");
    private int daisyesPerSquareUnit = Conditions.getInstance().getIntProperty("daisyesPerSquareUnit");
    private int numCeedPerUpdate = Conditions.getInstance().getIntProperty("numCeedPerUpdate");

    private double effectiveArea;

    public Planet(Starr star){
        this.star = star;
        effectiveArea = Math.PI*radius*radius;
        completeAreas();
        update();
    }

    private void completeAreas() {
        areas = new Area[halfFragmentation];

    }

    public void update() {
        updateAlbedo();
        updateTemperature();
    }

    private void updateTemperature() {
    }

    private void updateAlbedo() {
    }




}
