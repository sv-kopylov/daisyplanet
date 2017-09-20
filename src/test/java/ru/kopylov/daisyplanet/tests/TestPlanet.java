package ru.kopylov.daisyplanet.tests;

import org.junit.*;
import org.junit.Test;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Starr;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.utils.Conditions;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 28.08.17.
 */
public class TestPlanet {

    @Test
    public void testTemperature(){
        Starr Sun = new Starr();
        Planet Mars = new Planet(Sun);
        assertTrue("Planet temperature haz not been set",(Mars.getTemperature()>0));
        System.out.println(Mars.getAlbedo());
        System.out.println(Mars.getTemperature() + Conditions.Kelvin + Conditions.planetDeltaTemper);
    }

    @Test
    public void testUpdate(){
        Starr Sun = new Starr();
        Planet Mars = new Planet(Sun);
        System.out.print("a: "+String.format("%2.2f",Mars.getAlbedo()));
        System.out.println(" t: "+String.format("%2.2f",(Mars.getTemperature() + Conditions.Kelvin + Conditions.planetDeltaTemper)));
        System.out.println("_____________");
        for(int i =0; i<100; i++){
            Mars.update();
            System.out.print("a: "+String.format("%2.2f",Mars.getAlbedo()));
            System.out.println(" t: "+String.format("%2.2f",(Mars.getTemperature() + Conditions.Kelvin + Conditions.planetDeltaTemper)));
        }
    }

//    TODO make test of local temperatures
    @Test
    public void testLocalTemperatures(){
        Starr Sun = new Starr();
        Planet Mars = new Planet(Sun);
        Zone [] zones = Mars.getZones();
        Arrays.stream(zones)
                .map(zone->zone.getLocalTemperature())
                .forEach(temperature->{
                    System.out.println("Local temper is: "+ (temperature+Conditions.Kelvin));
                    assertTrue("local temperat have not been set", (temperature>0));
                return;});
    }





}
