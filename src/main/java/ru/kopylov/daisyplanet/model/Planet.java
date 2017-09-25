package ru.kopylov.daisyplanet.model;
import ru.kopylov.daisyplanet.logic.*;

import java.util.Arrays;


/**
 * Created by sergey on 10.08.17.
 */

public class Planet {
    private Starr star;
    private Zone[] zones;
    private boolean inhabited;

    // Metrics
    private double albedo = 0;
    private double temperature = 0;

    // primary parameters
    private double radius = Conditions.getInstance().radius;

    /** количество поясов на которое разбито одно полушарие*/
    private int halfZonation = Conditions.getInstance().halfZonation;

    /** фрагментация пояса: максимальное количество маргариток на пояс, на всех поясах - количество маргариток одинаковое */
    private long daiziesPerZone = Conditions.getInstance().daiziesPerZone;

    // derivative parameters
    /** эффективная площадь - проекция планеты на плоскость перпендикулярную напправлению излучения идущему
     * от звезды к планете,
     *  используется для расчета альбедо  */
    private double effectiveArea;

    /**  площадь пояса у  всех area - одинаковая
      S = 2πrh,
      r  – радиус сферы,
      h  – высота сферического пояса.
     */
    private double zoneArea;


    /** условная площадь одной маргаритки, справочный параметр*/
    private double daisyArea;

    PopulatorImpl populator = new PopulatorImpl();
    AlbedoCalculator albedoCalculator = new AlbedoCalculatorImpl();

    public Planet(){
        this.star = new Starr();
        zones = ZoneMaker.makeZones(radius, halfZonation);
        inhabited = true;
        populator.populateInitial(zones, 10, 10, 10);
        effectiveArea = Math.PI*radius*radius;
        zoneArea = 2*Math.PI*radius*(radius/halfZonation);
        daisyArea = zoneArea/daiziesPerZone;
        update();
    }


    public void update() {
        albedo = albedoCalculator.calcAlbedo(zones);
        temperature = StephanBoltsman.countTemperature(albedo,star.getStarConstant());
        updateLocalTempers();
        populator.rePopulate(this);

    }

    private void updateLocalTempers(){
        Arrays.stream(zones).forEach(zone->zone.setLocalTemperature(temperature));
    }

    public double getAlbedo() {
        return albedo;
    }

    public double getTemperature() {
        return temperature;
    }

    public Zone[] getZones(){
        return zones;
    }

    public boolean isInhabited() {
        return inhabited;
    }

    public void setInhabited(boolean inhabited) {
        this.inhabited = inhabited;
    }
}
