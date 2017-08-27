package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.NoDaizy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;

/**
 * Created by sergey on 23.08.17.
 */
public class AlbedoCalculatorImpl implements AlbedoCalculator {
    WhiteDaizy whiteDaizy = new WhiteDaizy();
    BlackDaisy blackDaisy = new BlackDaisy();
    NoDaizy noDaizy = new NoDaizy();

    public double calcAlbedo(Zone[] zones) {
        double whiteArea = 0;
        double blackArea = 0;
        double noneArea = 0;
        long zoneFragmentation = zones[0].getNumBlackDaisies()+zones[0].getNumWhiteDaisies()+zones[0].getNumEmptyCells();
        double regionalCoefficient;
        for(int i=0;i<zones.length;i++){
            regionalCoefficient = zones[i].getEffectiveArea()/zoneFragmentation;
            whiteArea+=regionalCoefficient*zones[i].getNumWhiteDaisies();
            blackArea+=regionalCoefficient*zones[i].getNumBlackDaisies();
            noneArea+=regionalCoefficient*zones[i].getNumEmptyCells();
        }
        double fullArea = whiteArea+blackArea+noneArea;

        double whiteAlbedo = whiteDaizy.getAlbedo()*whiteArea/fullArea;
        double blackAlbedo = blackDaisy.getAlbedo()*blackArea/fullArea;
        double noneAlbedo = noDaizy.getAlbedo()*noneArea/fullArea;

        return whiteAlbedo+blackAlbedo+noneAlbedo;
    }
}
