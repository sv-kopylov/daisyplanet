package ru.kopylov.daisyplanet.logic;

import org.apache.log4j.Logger;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;
import ru.kopylov.daisyplanet.model.Conditions;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.stream.Stream;


/**
 * Created by sergey on 22.08.17.
 */
public class PopulatorImpl implements Populator {
    Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());
    BlackDaisy blackDaisy = new BlackDaisy();
    WhiteDaizy whiteDaizy = new WhiteDaizy();
    private static Logger logger = Logger.getLogger(PopulatorImpl.class);

    public  void populateInitial(Zone[] zones, int whiteExpectance, int blackExpectance, int noneExpectance){
        Stream.of(zones).forEach(z->populate(z,whiteExpectance, blackExpectance, noneExpectance));
         }

    public void populate(Zone zone, int white, int black, int none){

        double sum = white+black+none;
        double whiteBorder = (double)white/sum;
        double blackBorder = 1.0 - (double)black/sum;
        zone.clear();

        for (long j=0; j< Conditions.getInstance().daiziesPerZone; j++){
            double num = random.nextDouble();
            if (num<whiteBorder){
                zone.incrementWhite();
            } else if (num>blackBorder) {
                zone.incrementBlack();
            } else {
                zone.incrementEmpty();
            }

        }
        logger.trace("black: "+zone.getNumBlackDaisies()+" white: "+zone.getNumWhiteDaisies()+" empty: "+zone.getNumEmptyCells());

    }
    public void rePopulate(Planet planet){
        Zone[] zones = planet.getZones();
        int down = 0;
        int up = 1;
        int cnt=0;
        for (int i=0; i<zones.length; i++){
            logger.trace("before: "+down+"-"+i+"-"+up);
            rePopulate(zones[i], zones[down], zones[up]);
            down = i;
            if(i<=zones.length-3){up = i + 2;}
            cnt+=zones[i].isAlive()?1:0;
            logger.trace("zone["+i+"]: "+ zones[i].toString());

        }
        logger.trace("Alive counter: "+cnt);
        if(cnt==0) {
            planet.setInhabited(false);
            logger.warn("PLANET IS DEAD");
        } else {
            planet.setInhabited(true);
        }
    }
    private void rePopulate(Zone zone, Zone down, Zone up) {
        double temper = zone.getLocalTemperature();
        int white = (int) zone.getNumWhiteDaisies();
        int black = (int) zone.getNumBlackDaisies();
        int none = (int) zone.getNumEmptyCells();

        if(black==0&&BlackDaisy.isFitForLife(temper)){
            black = (int) (down.getNumBlackDaisies() + up.getNumBlackDaisies())/2;
        }
        if(white==0&&WhiteDaizy.isFitForLife(temper)){
            white = (int) (down.getNumWhiteDaisies() + up.getNumWhiteDaisies())/2;
        }
        black = (int) (black*blackDaisy.getRate(temper));
        white = (int) (white*whiteDaizy.getRate(temper));

        if (white==0&&black==0&&none==0){
            none=1;
        }
        populate(zone, white, black, none);

    }






}
