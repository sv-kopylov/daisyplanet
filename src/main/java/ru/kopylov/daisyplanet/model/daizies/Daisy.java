package ru.kopylov.daisyplanet.model.daizies;
import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
abstract public class Daisy {
   abstract Type getType();
   abstract double getAlbedo();
   abstract boolean isComfortable(double temperature);
   abstract boolean isFitForLife(double temperature);

}
