package ru.kopylov.daisyplanet.model;

/**
 * Created by sergey on 14.08.17.
 */
public class Zone {

    /** угол границы ближайшей к экватору */
    private double latitude;


    /** эффективная площадь - проекция половины шарового слоя на плоскость,
     *  используется для расчета альбедо  */
    private double effectiveArea;

    /** высота шарового слоя*/
    private double height;

    /** температура на поверхности в данной area*/
    private double localTemperature;


    private long mumBlackDaisies;
    private long mumWhiteDaisies;
    private long mumWFullCells;

    public Zone(double radius, int index, int halfFragmentation){
        latitude = ((Math.PI/2)/halfFragmentation)*index;


        /*
        S = 2πrh,

где
  r  – радиус сферы,
  h  – высота сферического пояса.
         */


    }

}
