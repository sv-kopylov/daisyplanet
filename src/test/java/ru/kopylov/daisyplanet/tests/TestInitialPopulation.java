package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.Test;
import ru.kopylov.daisyplanet.logic.InitialDaysiePopulator;
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

    @Before
    public void init(){
        zones = ZoneMaker.makeZones(radius, halfFragmentation);

        new InitialDaysiePopulator().populate(zones, daiziesPerZone);
    }

    @Test
    public void testDaisiesAmmount(){
        for(int i=0; i<zones.length;i++){
            assertTrue("Incorrect nums of daizies in zone",(zones[i].getNumBlackDaisies()+zones[i].getNumWhiteDaisies()+zones[i].getNumEmptyCells())==100);
        }

    }
}
