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

    public static void populate (Zone[] zones, long maxDaisiesPerZone){
        Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());
        for (int i=0; i<zones.length; i++){
            for (long j=0; j<maxDaisiesPerZone; j++){
                int num = random.nextInt(1000);
                if (num<332){
                    zones[i].incrementWhite();
                } else if (num>667) {
                    zones[i].incrementBlack();
                } else {
                    zones[i].incrementEmpty();
                }
            }
            logger.debug("black: "+zones[i].getNumBlackDaisies()+" white: "+zones[i].getNumWhiteDaisies()+" empty: "+zones[i].getNumEmptyCells());
        }
    }

}
