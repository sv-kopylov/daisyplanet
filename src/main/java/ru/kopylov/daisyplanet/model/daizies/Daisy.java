package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.model.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
abstract public class Daisy {
   public static final double MAXRATE = 2;
   public abstract double getBestTemper();
   public abstract Type getType();
   public abstract double getAlbedo();
   public double getRate(double temperature){
      double delta = Math.abs(temperature - getBestTemper());
      if(delta> Conditions.getInstance().aliveHalfGap){
         delta=0;
      }
      double result = MAXRATE - delta/Conditions.getInstance().aliveHalfGap;

      return result;
   }

}
