package ru.kopylov.daisyplanet.model;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by sergey on 10.08.17.
 */
@Component
public class Starr {

    /**Звездная постоянная - суммарная мощность излучения звезды, проходящего через единичную площадку,
     * ориентированную перпендикулярно потоку, на расстоянии одной астрономической единицы от Звезды
     * для Солнца и Земли равняется 1367 Вт/м²*/


    public double getStarConstant() {
        return Conditions.getInstance().StarConstant;
    }

   }
