package ru.kopylov.daisyplanet.model.daizies;
import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
abstract public class Daisy {
   public abstract Type getType();
   public abstract double getAlbedo();
   public abstract boolean isComfortable(double temperature);
   public abstract boolean isFitForLife(double temperature);

}
