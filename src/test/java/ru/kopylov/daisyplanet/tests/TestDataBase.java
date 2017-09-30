package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.Test;
import ru.kopylov.daisyplanet.dao.PlanetDAO;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
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
        zones = ZoneMaker.makeZones(radius, halfFragmentation);
        dao.drop();
        dao.createDB();
        dao.createTables();
    }

    @Test
    public void testSave(){
        Planet planet = new Planet();
        dao.persist(planet);

    }
}
