package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopylov.daisyplanet.logic.Populator;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.Conditions;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 28.08.17.
 */
public class TestPlanet {
    Planet Mars;
    @Before
    public void init(){

        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.kopylov.daisyplanet");
        Mars = ctx.getBean(Planet.class);
    }

    @Test
    public void testTemperature(){
        assertTrue("Planet temperature haz not been set",(Mars.getTemperature()>0));
        System.out.println(Mars.getAlbedo());
        System.out.println(Mars.getTemperature() + Conditions.getInstance().Kelvin + Conditions.getInstance().planetDeltaTemper);
    }

    @Test
    public void testUpdate(){

        System.out.print("a: "+String.format("%2.2f",Mars.getAlbedo()));
        System.out.println(" t: "+String.format("%2.2f",(Mars.getTemperature() + Conditions.getInstance().Kelvin + Conditions.getInstance().planetDeltaTemper)));
        System.out.println("_____________");
        for(int i =0; i<100; i++){
            Mars.update();
            System.out.print("a: "+String.format("%2.2f",Mars.getAlbedo()));
            System.out.println(" t: "+String.format("%2.2f",(Mars.getTemperature() + Conditions.getInstance().Kelvin + Conditions.getInstance().planetDeltaTemper)));
        }
    }


    @Test
    public void testLocalTemperatures(){
              Mars.populate(1,1,1);
             Mars.update();
        Zone [] zones = Mars.getZones();
        Arrays.stream(zones)
                .map(zone->zone.getLocalTemperature())
                .forEach(temperature->{
                    System.out.println("Local temper is: "+ (temperature+Conditions.getInstance().Kelvin));
                    assertTrue("local temperat have not been set", (temperature>0));
                return;});
    }





}
