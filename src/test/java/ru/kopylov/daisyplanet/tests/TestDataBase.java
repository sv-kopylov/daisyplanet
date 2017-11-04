//package ru.kopylov.daisyplanet.tests;
//
//import org.apache.log4j.Logger;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import ru.kopylov.daisyplanet.dao.PlanetDAO;
//import ru.kopylov.daisyplanet.logic.ZoneMaker;
//import ru.kopylov.daisyplanet.model.Conditions;
//import ru.kopylov.daisyplanet.model.Planet;
//import ru.kopylov.daisyplanet.model.Zone;
//
//
///**
// * Created by sergey on 25.09.17.
// */
//public class TestDataBase {
//Logger logger = Logger.getLogger(TestDataBase.class);
//
//    Zone[] zones;
//    int halfFragmentation = 10;
//    double radius = 1000;
//    PlanetDAO dao = new PlanetDAO("daizytest");
//
//    @Before
//    public void init(){
//        dao.drop();
//        dao.createDB();
//        dao.createTables();
////        zones = ZoneMaker.makeZones(radius, halfFragmentation);
//
//    }
//
//    @Test
//    public void testSave(){
//
//        Planet planet = new Planet();
//        dao.persist(planet);
//
//    }
//
//    @Test
//    public void testRetrieveConditions(){
//        Conditions inst = Conditions.getInstance();
//        Planet planet = new Planet();
//        double oldKelvin = inst.Kelvin;
//        double oldradius = inst.radius;
//        int    oldhalfZonation = inst.halfZonation;
//        long   olddaiziesPerZone = inst.daiziesPerZone;
//        double oldplanetDeltaTemper = inst.planetDeltaTemper;
//        double oldblackDaisyAlbedo = inst.blackDaisyAlbedo;
//        double oldwhiteDaisyAlbedo = inst.whiteDaisyAlbedo;
//        double oldnoDaisyAlbedo = inst.noDaisyAlbedo;
//        double oldaliveHalfGap = inst.aliveHalfGap;
//        double oldcomfortHalfGap = inst.comfortHalfGap;
//        double oldblackComfortableTemper = inst.blackComfortableTemper;
//        double oldwhiteComfortableTemper = inst.whiteComfortableTemper;
//        double oldStarConstant = inst.StarConstant;
//        double oldStephanBoltsmanConst = inst.StephanBoltsmanConst;
//
//        dao.persist(planet);
//        dao.getConditions(1L);
//        assertTrue("var changed", oldKelvin == inst.Kelvin);
//        assertTrue("var changed",oldradius == inst.radius);
//        assertTrue("var changed",oldhalfZonation == inst.halfZonation);
//        assertTrue("var changed",olddaiziesPerZone == inst.daiziesPerZone);
//        assertTrue("var changed",oldplanetDeltaTemper == inst.planetDeltaTemper);
//        assertTrue("var changed",oldblackDaisyAlbedo == inst.blackDaisyAlbedo);
//        assertTrue("var changed",oldwhiteDaisyAlbedo == inst.whiteDaisyAlbedo);
//        assertTrue("var changed",oldnoDaisyAlbedo == inst.noDaisyAlbedo);
//        assertTrue("var changed",oldaliveHalfGap == inst.aliveHalfGap);
//        assertTrue("var changed",oldcomfortHalfGap == inst.comfortHalfGap);
//        assertTrue("var changed",oldblackComfortableTemper == inst.blackComfortableTemper);
//        assertTrue("var changed",oldwhiteComfortableTemper == inst.whiteComfortableTemper);
//        assertTrue("var changed",oldStarConstant == inst.StarConstant);
//        assertTrue("var changed",oldStephanBoltsmanConst == inst.StephanBoltsmanConst);
//
//
//    }
//
//    @Test
//    public void testRetrieveZone(){
//        Planet planet = new Planet();
//        Zone zz = planet.getZones()[4];
//
//        planet.setIterationId(2l);
//        dao.persist(planet);
//
//        Zone[] zones = dao.getZones(2l);
//
//
//        Zone nz = zones[4];
////        nz.setLocalTemperature(234);
//
//        assertTrue("num zones incorrect", zones.length==planet.getZones().length);
//        assertTrue("incorrect parameter after save",zz.getLatitude()==nz.getLatitude());
//        assertTrue("incorrect parameter after save",zz.getEffectiveArea()==nz.getEffectiveArea());
//        assertTrue("incorrect parameter after save",zz.getHeight()==nz.getHeight());
//        assertTrue("incorrect parameter after save",zz.getLocalTemperature()==nz.getLocalTemperature());
//        assertTrue("incorrect parameter after save",zz.getNumBlackDaisies()==nz.getNumBlackDaisies());
//        assertTrue("incorrect parameter after save",zz.getNumWhiteDaisies()==nz.getNumWhiteDaisies());
//        assertTrue("incorrect parameter after save",zz.getNumEmptyCells()==nz.getNumEmptyCells());
//
//
//    }
//    @Test
//    public void testPlanetRetrieving(){
//        Planet op = new Planet();
//        Zone zz = op.getZones()[5];
//
//        op.setIterationId(5l);
//        dao.persist(op);
//
//        Planet np = dao.getPlanet(5l);
//        Zone nz = np.getZones()[5];
//
//        assertTrue("incorrect Planet parameter after save", op.getZones().length == np.getZones().length );
//        assertTrue("incorrect Planet parameter after save", op.isInhabited() == np.isInhabited() );
//        assertEquals(op.getAlbedo(),np.getAlbedo(), 0.00001);
//        assertEquals(op.getTemperature(),np.getTemperature(), 0.00001);
//        assertEquals(op.getRadius(),np.getRadius(), 0.00001);
//        assertEquals(op.getEffectiveArea(),np.getEffectiveArea(), 0.00001);
//        assertEquals(op.getZoneArea(),np.getZoneArea(), 0.00001);
//        assertEquals(op.getDaisyArea(),np.getDaisyArea(), 0.00001);
//
///*inhabited, albedo, " +
//                "temperature, radius, effectiveArea, zoneArea, daisyArea " +
//* */
//
//        assertEquals(zz.getLatitude(),nz.getLatitude(), 0000.1);
//        assertEquals(zz.getEffectiveArea(),nz.getEffectiveArea(), 0000.1);
//        assertEquals(zz.getHeight(),nz.getHeight(), 0000.1);
//        assertEquals(zz.getLocalTemperature(),nz.getLocalTemperature(), 0000.1);
//        assertEquals(zz.getNumBlackDaisies(),nz.getNumBlackDaisies());
//        assertEquals(zz.getNumWhiteDaisies(),nz.getNumWhiteDaisies());
//        assertEquals(zz.getNumEmptyCells(),nz.getNumEmptyCells());
//
//
//
//
//    }
//}
