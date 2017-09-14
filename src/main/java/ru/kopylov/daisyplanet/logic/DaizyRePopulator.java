package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 22.08.17.
 */
public class DaizyRePopulator {
    Populator daizyPopulator = new PopulatorImpl();
    double temperature;


       public void rePopulate(Zone[] zones) {
           for(Zone zone: zones){


               zone.getLocalTemperature();
           }

    }
}
