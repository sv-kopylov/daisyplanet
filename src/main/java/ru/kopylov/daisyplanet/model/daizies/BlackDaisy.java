package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.model.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class BlackDaisy extends Daisy {

    final double albedo = Conditions.getInstance().blackDaisyAlbedo;


    public Type getType() {
        return Type.BLACK;
    }

    public double getAlbedo() {
        return albedo;
    }

    public static boolean isComfortable(double temperature) {

        return (Math.abs(temperature - Conditions.getInstance().blackComfortableTemper)
                <= Conditions.getInstance().comfortHalfGap);
    }

    public static boolean isFitForLife(double temperature) {
        return (Math.abs(temperature - Conditions.getInstance().blackComfortableTemper)
                <= Conditions.getInstance().aliveHalfGap);
    }
}
