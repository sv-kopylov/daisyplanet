package ru.kopylov.daisyplanet.logic;

import org.apache.log4j.Logger;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;
import ru.kopylov.daisyplanet.utils.Conditions;

import java.util.GregorianCalendar;
import java.util.Random;


/**
 * Created by sergey on 22.08.17.
 */
public class PopulatorImpl implements Populator {
    private static Logger logger = Logger.getLogger(PopulatorImpl.class);

    public  void populateInitial(Zone[] zones, int whiteExpectance, int blackExpectance, int noneExpectance){
        for (int i=0; i<zones.length; i++){
           populate(zones[i], whiteExpectance, blackExpectance, noneExpectance);
            logger.trace("black: "+zones[i].getNumBlackDaisies()+" white: "+zones[i].getNumWhiteDaisies()+" empty: "+zones[i].getNumEmptyCells());
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
        int down = 0;
        int up = 1;
        int cnt=0;
        for (int i=0; i<zones.length; i++){
            logger.trace("before: "+down+"-"+i+"-"+up);
            rePopulate(zones[i], zones[down], zones[up]);
            down = i;
            if(i<=zones.length-3){up = i + 2;}
            cnt+=zones[i].isAlive()?1:0;
            logger.debug("zone["+i+"]: "+ zoneToStr(zones[i]));

        }
        logger.debug("Alive counter: "+cnt);
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
        if(BlackDaisy.isComfortable(temper)){
            black*=2;
        } else if(!BlackDaisy.isFitForLife(temper)){
            black=0;
        }

        if(white==0&&WhiteDaizy.isFitForLife(temper)){
            white = (int) (down.getNumWhiteDaisies() + up.getNumWhiteDaisies())/2;
        }
        if(WhiteDaizy.isComfortable(temper)){
            white*=2;
        } else if(!WhiteDaizy.isFitForLife(temper)){
            white=0;
        }

        populate  (zone, white, black, none);

    }

    public String zoneToStr(Zone zone){
        StringBuilder sb = new StringBuilder();
        sb.append("temper: ");
        sb.append(String.format("%2.1f", zone.getLocalTemperature()+Conditions.Kelvin));
        sb.append(zone.isAlive()?" alive ":" dead ");
        sb.append(" white: ");
        sb.append(zone.getNumWhiteDaisies());
        sb.append(" black: ");
        sb.append(zone.getNumBlackDaisies());
        sb.append(" empty: ");
        sb.append(zone.getNumEmptyCells());

        return sb.toString();
    }




}
