package ru.kopylov.daisyplanet.model;

/**
 * Created by sergey on 14.08.17.
 */
public class Zone {
// parameters
    /** угол границы ближайшей к экватору */
    private double latitude;

    /** эффективная площадь - проекция половины шарового слоя на плоскость,
     *  используется для расчета альбедо  */
    private double effectiveArea;

    /** высота шарового слоя*/
    private double height;

    public Zone(double latitude, double effectiveArea, double height) {
        this.latitude = latitude;
        this.effectiveArea = effectiveArea;
        this.height = height;
    }

    //    metrics

    /** температура на поверхности в данной area*/
    private double localTemperature;

    private long numBlackDaisies;
    private long numWhiteDaisies;
    private long numEmptyCells;

}
