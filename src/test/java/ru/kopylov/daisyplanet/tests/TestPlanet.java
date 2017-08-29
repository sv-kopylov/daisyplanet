package ru.kopylov.daisyplanet.tests;

import org.junit.Test;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Starr;
import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 28.08.17.
 */
public class TestPlanet {

    @Test
    public void testTemperature(){
        Starr Sun = new Starr();
        Planet Mars = new Planet(Sun);
        System.out.println(Mars.getAlbedo());
        System.out.println(Mars.getTemperature() + Conditions.Kelvin);
    }
}
