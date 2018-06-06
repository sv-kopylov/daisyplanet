package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.NoDaizy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;

import java.util.stream.Stream;

/**
 * Created by sergey on 23.08.17.
 */
public class AlbedoCalculatorImpl implements AlbedoCalculator {
    WhiteDaizy whiteDaizy = new WhiteDaizy();
    BlackDaisy blackDaisy = new BlackDaisy();
    NoDaizy noDaizy = new NoDaizy();

    double whiteArea = 0;
    double blackArea = 0;
    double noneArea = 0;
    double regionalCoefficient;

    public double calcAlbedo(Zone[] zones) {

        long zoneFragmentation = zones[0].getNumBlackDaisies()+zones[0].getNumWhiteDaisies()+zones[0].getNumEmptyCells();
        Stream.of(zones).forEach(zone->{
        regionalCoefficient = zone.getEffectiveArea()/zoneFragmentation;
        whiteArea+=regionalCoefficient*zone.getNumWhiteDaisies();
        blackArea+=regionalCoefficient*zone.getNumBlackDaisies();
        noneArea+=regionalCoefficient*zone.getNumEmptyCells();
        });
        double fullArea = whiteArea+blackArea+noneArea;

        double whiteAlbedo = whiteDaizy.getAlbedo()*whiteArea/fullArea;
        double blackAlbedo = blackDaisy.getAlbedo()*blackArea/fullArea;
        double noneAlbedo = noDaizy.getAlbedo()*noneArea/fullArea;

        whiteArea = 0;
        blackArea = 0;
        noneArea = 0;
        return whiteAlbedo+blackAlbedo+noneAlbedo;
    }
}
