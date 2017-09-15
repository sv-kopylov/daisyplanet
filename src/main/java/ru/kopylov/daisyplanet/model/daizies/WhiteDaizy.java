package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class WhiteDaizy extends Daisy {

    double albedo = Conditions.whiteDaisyAlbedo;
    public Type getType() {
        return Type.WHITE;
    }

    public double getAlbedo() {
        return albedo;
    }

    public static boolean isComfortable(double temperature) {

        return (Math.abs(temperature - Conditions.whiteComfortableTemper)
                <= Conditions.comfortHalfGap);
    }

    public static boolean isFitForLife(double temperature) {
        return (Math.abs(temperature - Conditions.whiteComfortableTemper)
                <= Conditions.aliveHalfGap);
    }
}
