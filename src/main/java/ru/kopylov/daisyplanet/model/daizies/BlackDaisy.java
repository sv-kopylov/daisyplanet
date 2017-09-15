package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class BlackDaisy extends Daisy {

    final double albedo = Conditions.blackDaisyAlbedo;


    public Type getType() {
        return Type.BLACK;
    }

    public double getAlbedo() {
        return albedo;
    }

    public static boolean isComfortable(double temperature) {

        return (Math.abs(temperature - Conditions.blackComfortableTemper)
                <= Conditions.comfortHalfGap);
    }

    public static boolean isFitForLife(double temperature) {
        return (Math.abs(temperature - Conditions.blackComfortableTemper)
                <= Conditions.aliveHalfGap);
    }
}
