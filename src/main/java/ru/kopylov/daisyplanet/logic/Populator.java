package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 22.08.17.
 */
public interface Populator {
       void populateInitial(Zone[] zones, int whiteExpectance, int black, int none);
       void populate(Zone zone,  int white, int black, int none);




}
