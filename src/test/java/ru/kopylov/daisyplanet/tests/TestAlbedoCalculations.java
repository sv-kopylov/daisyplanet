package ru.kopylov.daisyplanet.tests;

import org.junit.*;
import ru.kopylov.daisyplanet.logic.AlbedoCalculator;
import ru.kopylov.daisyplanet.logic.AlbedoCalculatorImpl;
import ru.kopylov.daisyplanet.logic.InitialDaysiePopulator;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.Daisy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 27.08.17.
 */
public class TestAlbedoCalculations {
    Zone[] zones;
    int halfFragmentation = 10;
    double radius = 1000;
    long daiziesPerZone = 100;
    InitialDaysiePopulator idp = new InitialDaysiePopulator();
    AlbedoCalculator calc = new AlbedoCalculatorImpl();
    Daisy daisy;

    @Before
    public void init(){
        zones = ZoneMaker.makeZones(radius, halfFragmentation);

    }

    @Test
    public void testWhiteAlbedo(){
        idp.populate(zones, daiziesPerZone, 10, 0, 0);
        double albedo = calc.calcAlbedo(zones);
        System.out.println(albedo);
        daisy = new WhiteDaizy();
        assertTrue("Incorrect albedo counting",(daisy.getAlbedo()==albedo));

    }

    @Test
    public void testBlackAlbedo(){
        idp.populate(zones, daiziesPerZone, 0, 1, 0);
        double albedo = calc.calcAlbedo(zones);
        System.out.println(albedo);
        Daisy daisy = new BlackDaisy();
        assertTrue("Incorrect albedo counting",(daisy.getAlbedo()==albedo));

    }

}
