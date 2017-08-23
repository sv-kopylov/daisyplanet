package ru.kopylov.daisyplanet.model;

/**
 * Created by sergey on 10.08.17.
 */
public class Starr {

    /**Звездная постоянная - суммарная мощность излучения звезды, проходящего через единичную площадку,
     * ориентированную перпендикулярно потоку, на расстоянии одной астрономической единицы от Звезды
     * для Солнца и Земли равняется 1367 Вт/м²*/
    private double StarConstant = 1367.0;

    public double getStarConstant() {
        return StarConstant;
    }

    public void setStarConstant(double starConstant) {
        StarConstant = starConstant;
    }
}
