package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.model.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class WhiteDaizy extends Daisy {

    double albedo = Conditions.getInstance().whiteDaisyAlbedo;

    @Override
    public double getBestTemper() {
        return Conditions.getInstance().whiteComfortableTemper;
    }

    public Type getType() {
        return Type.WHITE;
    }

    public double getAlbedo() {
        return albedo;
    }

     public static boolean isComfortable(double temperature) {

        return (Math.abs(temperature - Conditions.getInstance().whiteComfortableTemper)
                <= Conditions.getInstance().comfortHalfGap);
    }

    public static boolean isFitForLife(double temperature) {
        return (Math.abs(temperature - Conditions.getInstance().whiteComfortableTemper)
                <= Conditions.getInstance().aliveHalfGap);
    }

    public static boolean isToHot(double temperature){
        return temperature>Conditions.getInstance().whiteComfortableTemper+Conditions.getInstance().aliveHalfGap;
    }
    public static boolean isToCold(double temperature){
        return temperature<Conditions.getInstance().whiteComfortableTemper-Conditions.getInstance().aliveHalfGap;
    }
}
