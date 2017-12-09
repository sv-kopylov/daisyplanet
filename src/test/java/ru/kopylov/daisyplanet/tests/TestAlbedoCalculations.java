package ru.kopylov.daisyplanet.tests;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopylov.daisyplanet.logic.*;
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
    Populator idp;
    AlbedoCalculator calc = new AlbedoCalculatorImpl();
    Daisy daisy;

    @Before
    public void init(){
        zones = ZoneMaker.makeZones(radius, halfFragmentation);
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.kopylov.daisyplanet");
        idp = ctx.getBean(Populator.class);
    }

    @Test
    public void testWhiteAlbedo(){
        idp.populateInitial(zones, 10, 0, 0);
        double albedo = calc.calcAlbedo(zones);
        System.out.println(albedo);
        daisy = new WhiteDaizy();
        assertTrue("Incorrect albedo counting",(daisy.getAlbedo()==albedo));

    }

    @Test
    public void testBlackAlbedo(){
        idp.populateInitial(zones, 0, 1, 0);
        double albedo = calc.calcAlbedo(zones);
        System.out.println(albedo);
        Daisy daisy = new BlackDaisy();
        assertTrue("Incorrect albedo counting",(daisy.getAlbedo()==albedo));

    }

}
