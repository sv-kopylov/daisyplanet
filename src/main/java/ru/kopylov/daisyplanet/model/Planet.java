package ru.kopylov.daisyplanet.model;
import ru.kopylov.daisyplanet.utils.Conditions;



/**
 * Created by sergey on 10.08.17.
 */
public class Planet {
    Starr star;
    Zone[] zones;

    // Metrics
    private double albedo = 0;
    private double temperature = 0;

    // primary parameters
    private double radius = Conditions.getInstance().getDoubleProperty("radius");

    /** количество поясов на которое разбито одно полушарие*/
    private int halfZonation = Conditions.getInstance().getIntProperty("halfZonation");

    /** условная площадь одной маргаритки, требуется для определения фрагментации пояса*/
    private int daisyArea = Conditions.getInstance().getIntProperty("daisyArea");

    // derivative parameters
    /** эффективная площадь - проекция планеты на плоскость перпендикулярную напправлению излучения идущему
     * от звезды к планете,
     *  используется для расчета альбедо  */
    private double effectiveArea;

    /**  площадь пояса у  всех area - одинаковая */
    private double zoneArea;

    /** максимальное количество маргариток, у всех одинаковое */
    private long maxDaisiesRerZone;

    public Planet(Starr star){
        this.star = star;
        effectiveArea = Math.PI*radius*radius;
        completeAreas();
        update();
    }

    private void completeAreas() {
        zones = new Zone[halfZonation];

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
