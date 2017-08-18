package ru.kopylov.daisyplanet.logic;
import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 17.08.17.
 */
public class ZoneMaker {


    public static Zone makeZone(double radius, int halfZonation, int index){
        double height = radius/halfZonation;
        double latitude = calcLatitude(radius, height, index);
        double effectiveArea = calcZoneEffeciveArea(radius, height, index);
        return new Zone(latitude, effectiveArea, height);

    }
    private static double calcZoneEffeciveArea(double radius, double height, int index){

        double alphaN = calcLatitude(radius, height, index);
        double alphaN_PlusOne = calcLatitude(radius, height, index+1);
        double alphaDiff = alphaN_PlusOne - alphaN;

        double sRectangle = height*radius*Math.cos(alphaN_PlusOne);
        double sTriangle = 0.5*height*radius*(Math.cos(alphaN) - Math.cos(alphaN_PlusOne));
        double sSegment = 0.5*radius*radius*(alphaDiff - Math.sin(alphaDiff));

        return 2*(sRectangle+sTriangle+sSegment);
    }

    private static double calcLatitude(double radius, double height, int index){
        return Math.asin((height*index)/radius);
    }
}
