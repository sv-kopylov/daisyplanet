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

    public Zone(double latitude, double effectiveArea, double height, double localTemperature, long numBlackDaisies, long numWhiteDaisies, long numEmptyCells) {
        this.latitude = latitude;
        this.effectiveArea = effectiveArea;
        this.height = height;
        this.localTemperature = localTemperature;
        this.numBlackDaisies = numBlackDaisies;
        this.numWhiteDaisies = numWhiteDaisies;
        this.numEmptyCells = numEmptyCells;
    }
    //    metrics

    /** температура на поверхности в данной area*/
    private double localTemperature;

//    количество маргариток
    private long numBlackDaisies;
    private long numWhiteDaisies;
    private long numEmptyCells;

    public boolean isAlive(){
        return (numBlackDaisies!=0)||(numWhiteDaisies!=0);
    }

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

    public void setLocalTemperature(double globalTemperature) {
        this.localTemperature = globalTemperature + Conditions.getInstance().planetDeltaTemper*Math.cos(latitude);
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

    public void incrementBlack(){
        numBlackDaisies++;
    }
    public void incrementWhite(){
        numWhiteDaisies++;
    }
    public void incrementEmpty(){
        numEmptyCells++;
    }
    public void clear(){
        numBlackDaisies=0;
        numWhiteDaisies=0;
        numEmptyCells=0;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("temper: ");
        sb.append(String.format("%2.1f", getLocalTemperature()+Conditions.getInstance().Kelvin));
        sb.append(isAlive()?" alive ":" dead ");
        sb.append(" white: ");
        sb.append(getNumWhiteDaisies());
        sb.append(" black: ");
        sb.append(getNumBlackDaisies());
        sb.append(" empty: ");
        sb.append(getNumEmptyCells());

        return sb.toString();
    }
}
