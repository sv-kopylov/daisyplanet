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

    public double getLatitude() {
        return latitude;
    }

    public double getEffectiveArea() {
        return effectiveArea;
    }

    public double getHeight() {
        return height;
    }

    public double getLocalTemperature() {
        return localTemperature;
    }

    public long getNumBlackDaisies() {
        return numBlackDaisies;
    }

    public long getNumWhiteDaisies() {
        return numWhiteDaisies;
    }

    public long getNumEmptyCells() {
        return numEmptyCells;
    }

    public void setLocalTemperature(double localTemperature) {
        this.localTemperature = localTemperature;
    }

    public void setNumBlackDaisies(long numBlackDaisies) {
        this.numBlackDaisies = numBlackDaisies;
    }

    public void setNumWhiteDaisies(long numWhiteDaisies) {
        this.numWhiteDaisies = numWhiteDaisies;
    }

    public void setNumEmptyCells(long numEmptyCells) {
        this.numEmptyCells = numEmptyCells;
    }
}
