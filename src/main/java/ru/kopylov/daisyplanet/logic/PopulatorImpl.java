package ru.kopylov.daisyplanet.logic;

import org.apache.log4j.Logger;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.utils.Conditions;

import java.util.GregorianCalendar;
import java.util.Random;


/**
 * Created by sergey on 22.08.17.
 */
public class PopulatorImpl implements Populator {
    private static Logger logger = Logger.getLogger(PopulatorImpl.class);

    public  void populateInitial(Zone[] zones, int whiteExpectance, int black, int none){
        for (int i=0; i<zones.length; i++){
           populate(zones[i], whiteExpectance, black, none);
            logger.debug("black: "+zones[i].getNumBlackDaisies()+" white: "+zones[i].getNumWhiteDaisies()+" empty: "+zones[i].getNumEmptyCells());
            }
        }

    public void populate(Zone zone, int white, int black, int none){
        Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());
        double sum = white+black+none;
        double whiteBorder = (double)white/sum;
        double blackBorder = 1.0 - (double)black/sum;
        zone.clear();

        for (long j=0; j< Conditions.daiziesPerZone; j++){
            double num = random.nextDouble();
            if (num<whiteBorder){
                zone.incrementWhite();
            } else if (num>blackBorder) {
                zone.incrementBlack();
            } else {
                zone.incrementEmpty();
            }
        }



    }

    public void rePopulate(Planet planet){
        Zone[] zones = planet.getZones();
        Zone down = zones[0];
        for (int i=0; i<zones.length; i++){
            if(zones[i].isAlive()){
                rePopulateAlive(zones[i]);
            } else {
                rePopulateDead(zones[i], down,zones[i+1]);
            }
            down = zones[i];

        }
    }
    private void rePopulateAlive(Zone zone) {
        double temper = zone.getLocalTemperature();
        double white = zone.getNumWhiteDaisies();
        double black = zone.getNumBlackDaisies();


    }
    private void rePopulateDead(Zone curZone, Zone down, Zone up) {
    }



}
