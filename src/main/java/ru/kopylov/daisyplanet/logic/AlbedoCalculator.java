package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;

/**
 * Created by sergey on 23.08.17.
 */
public interface AlbedoCalculator {
    public double calcAlbedo(Zone[] zones);
}
