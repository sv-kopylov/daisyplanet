package ru.kopylov.daisyplanet.model;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 10.08.17.
 */
public class Starr {

    /**Звездная постоянная - суммарная мощность излучения звезды, проходящего через единичную площадку,
     * ориентированную перпендикулярно потоку, на расстоянии одной астрономической единицы от Звезды
     * для Солнца и Земли равняется 1367 Вт/м²*/
    private double StarConstant = Conditions.StarConstant;

    public double getStarConstant() {
        return StarConstant;
    }

    public void setStarConstant(double starConstant) {
        StarConstant = starConstant;
    }
}
