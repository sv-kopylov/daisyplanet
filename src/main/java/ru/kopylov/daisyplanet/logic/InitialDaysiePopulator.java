package ru.kopylov.daisyplanet.logic;

import org.apache.log4j.Logger;
import ru.kopylov.daisyplanet.model.Zone;

import java.util.GregorianCalendar;
import java.util.Random;


/**
 * Created by sergey on 22.08.17.
 */
public class InitialDaysiePopulator {
    private static Logger logger = Logger.getLogger(InitialDaysiePopulator.class);

    public  void populate (Zone[] zones, long maxDaisiesPerZone, int white, int black, int none){

        double sum = white+black+none;
        double whiteBorder = (double)white/sum;
        double blackBorder = 1.0 - (double)black/sum;


        Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());
        for (int i=0; i<zones.length; i++){
            zones[i].clear();
            for (long j=0; j<maxDaisiesPerZone; j++){
                double num = random.nextDouble();
                if (num<whiteBorder){
                    zones[i].incrementWhite();
                } else if (num>blackBorder) {
                    zones[i].incrementBlack();
                } else {
                    zones[i].incrementEmpty();
                }
            }
            logger.debug("black: "+zones[i].getNumBlackDaisies()+" white: "+zones[i].getNumWhiteDaisies()+" empty: "+zones[i].getNumEmptyCells());
        }
    }

}
