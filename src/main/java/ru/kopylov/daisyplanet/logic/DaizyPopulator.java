package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 22.08.17.
 */
public interface DaizyPopulator {
       void populate (Zone[] zones, long maxDaisiesPerZone, int white, int black, int none);
}
