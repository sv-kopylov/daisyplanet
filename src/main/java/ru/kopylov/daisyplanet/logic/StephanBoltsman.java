package ru.kopylov.daisyplanet.logic;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 18.09.17.
 */
public class StephanBoltsman {

    /**
     * Эффективная температура планеты, по закону Стефана-Больцмана
     *            ________
     *          / e(1-a)
     * Te =  4 /  -------
     *        V   4sigma
     *
     * @param a = albedo
     * @param e = starConstant -  солнечная постоянная
     * @return temperature (эффективная температура небесного тела)
     */
    public static double countTemperature(double albedo, double starConstant){
        double numerator = (1-albedo)*starConstant;
        double denomenator = 4.0* Conditions.getInstance().StephanBoltsmanConst;
        return Math.pow(numerator/denomenator, 0.25);
    }
}
