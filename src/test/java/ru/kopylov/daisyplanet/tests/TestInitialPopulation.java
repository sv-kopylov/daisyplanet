package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopylov.daisyplanet.logic.Populator;
import ru.kopylov.daisyplanet.logic.PopulatorImpl;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.model.Zone;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 22.08.17.
 */
public class TestInitialPopulation {
    Zone[] zones;
    int halfFragmentation = 10;
    double radius = 1000;
    long daiziesPerZone = 100;
    Populator idp = new PopulatorImpl();

    @Before
    public void init(){
        zones = ZoneMaker.makeZones(radius, halfFragmentation);
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.kopylov.daisyplanet");
        idp = ctx.getBean(Populator.class);

    }

    @Test
    public void testDaisiesAmmount(){
        idp.populateInitial(zones, 10, 10, 10);
        for(int i=0; i<zones.length;i++){
            assertTrue("Incorrect nums of daizies in zone",(zones[i].getNumBlackDaisies()+zones[i].getNumWhiteDaisies()+zones[i].getNumEmptyCells())==100);
        }

    }


    @Test
    public void testWhitePopulation(){
        idp.populateInitial(zones, 10, 0, 0);
        for(int i=0; i<zones.length;i++){
            assertTrue("Incorrect nums of white daisies in zone",(zones[i].getNumWhiteDaisies()==100));
        }

    }

    @Test
    public void testBlackPopulation(){
        idp.populateInitial(zones, 0, 2, 0);
        for(int i=0; i<zones.length;i++){
            assertTrue("Incorrect nums of black daisies in zone",(zones[i].getNumBlackDaisies()==100));
        }
    }

    @Test
    public void testNonePopulation(){
        idp.populateInitial(zones, 0, 0, 3);
        for(int i=0; i<zones.length;i++){
            assertTrue("Incorrect nums of none daisies in zone",(zones[i].getNumEmptyCells()==100));
        }
    }

}
