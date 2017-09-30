package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import ru.kopylov.daisyplanet.dao.PlanetDAO;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;


/**
 * Created by sergey on 25.09.17.
 */
public class TestDataBase {

    Zone[] zones;
    int halfFragmentation = 10;
    double radius = 1000;
    PlanetDAO dao = new PlanetDAO("daizytest");

    @Before
    public void init(){
        dao.drop();
        dao.createDB();
        dao.createTables();
//        zones = ZoneMaker.makeZones(radius, halfFragmentation);

    }

    @Test
    public void testSave(){

        Planet planet = new Planet();
        dao.persist(planet);

    }

    @Test
    public void testRetrieveConditions(){
        Conditions inst = Conditions.getInstance();
        Planet planet = new Planet();
        double oldKelvin = inst.Kelvin;
        double oldradius = inst.radius;
        int    oldhalfZonation = inst.halfZonation;
        long   olddaiziesPerZone = inst.daiziesPerZone;
        double oldplanetDeltaTemper = inst.planetDeltaTemper;
        double oldblackDaisyAlbedo = inst.blackDaisyAlbedo;
        double oldwhiteDaisyAlbedo = inst.whiteDaisyAlbedo;
        double oldnoDaisyAlbedo = inst.noDaisyAlbedo;
        double oldaliveHalfGap = inst.aliveHalfGap;
        double oldcomfortHalfGap = inst.comfortHalfGap;
        double oldblackComfortableTemper = inst.blackComfortableTemper;
        double oldwhiteComfortableTemper = inst.whiteComfortableTemper;
        double oldStarConstant = inst.StarConstant;
        double oldStephanBoltsmanConst = inst.StephanBoltsmanConst;

        dao.persist(planet);
        dao.getConditions(1L);
        assertTrue("var changed", oldKelvin == inst.Kelvin);
        assertTrue("var changed",oldradius == inst.radius);
        assertTrue("var changed",oldhalfZonation == inst.halfZonation);
        assertTrue("var changed",olddaiziesPerZone == inst.daiziesPerZone);
        assertTrue("var changed",oldplanetDeltaTemper == inst.planetDeltaTemper);
        assertTrue("var changed",oldblackDaisyAlbedo == inst.blackDaisyAlbedo);
        assertTrue("var changed",oldwhiteDaisyAlbedo == inst.whiteDaisyAlbedo);
        assertTrue("var changed",oldnoDaisyAlbedo == inst.noDaisyAlbedo);
        assertTrue("var changed",oldaliveHalfGap == inst.aliveHalfGap);
        assertTrue("var changed",oldcomfortHalfGap == inst.comfortHalfGap);
        assertTrue("var changed",oldblackComfortableTemper == inst.blackComfortableTemper);
        assertTrue("var changed",oldwhiteComfortableTemper == inst.whiteComfortableTemper);
        assertTrue("var changed",oldStarConstant == inst.StarConstant);
        assertTrue("var changed",oldStephanBoltsmanConst == inst.StephanBoltsmanConst);


    }
}
