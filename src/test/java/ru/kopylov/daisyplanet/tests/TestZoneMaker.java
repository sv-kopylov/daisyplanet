package ru.kopylov.daisyplanet.tests;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.model.Zone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 18.08.17.
 */

public class TestZoneMaker {
    private static Logger logger =  Logger.getLogger(TestZoneMaker.class);

    Zone[] zones;
    int halfFragmentation = 10;
    double radius = 1000;

    @Before
    public void init(){
        zones = ZoneMaker.makeZones(radius, halfFragmentation);
    }


    @Test
    public  void testFullarea(){
       double expectedArea = Math.PI*radius*radius;
       logger.debug("expected full area: "+Double.toString(expectedArea));
       double zonesArea = 0.0;
       for (int i =0; i<halfFragmentation; i++){
           zonesArea+=zones[i].getEffectiveArea();
       }
       logger.debug("actual area: "+Double.toString(zonesArea));
        logger.debug("Delta: " + Double.toString(expectedArea - zonesArea*2));
       assertEquals( expectedArea, zonesArea*2, 0.0001);


    }
    @Test
    public void testLatitude(){
        double fullLatitude = 0.0;
        for (int i=1; i<halfFragmentation;i++){
            fullLatitude+=zones[i].getLatitude() - zones[i-1].getLatitude();
        }
        fullLatitude+=Math.PI/2 - zones[halfFragmentation-1].getLatitude();
        assertEquals( Math.PI, fullLatitude*2, 0.0001);

    }

    @Test
    public void testAngleOrder(){
        for (int i=1; i<halfFragmentation;i++){
            assertTrue("Angle order is incorrect",(zones[i].getLatitude() - zones[i-1].getLatitude())>0);
        }
        assertTrue("Angle order is incorrect",(Math.PI/2 - zones[halfFragmentation-1].getLatitude())>0);
    }

    @Test
    public void testAreaOrder(){
        for (int i=1; i<halfFragmentation;i++){
            assertTrue("Area order is incorrect",(zones[i-1].getEffectiveArea() - zones[i].getEffectiveArea())>0);
        }

    }



}
