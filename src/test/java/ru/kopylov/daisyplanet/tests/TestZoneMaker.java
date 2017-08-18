package ru.kopylov.daisyplanet.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 18.08.17.
 */

public class TestZoneMaker {
    Zone[] zones;
    int halfFragmentation = 10;

    @BeforeClass
    public void init(){
        zones = new Zone[halfFragmentation];
        for (int i=0; i<halfFragmentation; i++)
    }

    @Test
    public  void testZoneMaker(){
        Zone[] zones = new Zone[10];


    }

}
