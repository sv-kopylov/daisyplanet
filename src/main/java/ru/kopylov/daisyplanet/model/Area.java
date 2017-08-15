package ru.kopylov.daisyplanet.model;

/**
 * Created by sergey on 14.08.17.
 */
public class Area {

    private double latitude;
    private double fullArea;
    private double effectiveArea;
    private double gap;


    private double localTemperature;

    private long numOfCells;
    private long mumBlackDaisies;
    private long mumWhiteDaisies;
    private long mumWFullCells;

    public Area(double radius, int index, int halfFragmentation){
        latitude = ((Math.PI/2)/halfFragmentation)*index;
        gap = ((Math.PI/2)*radius)/halfFragmentation;


    }





}
