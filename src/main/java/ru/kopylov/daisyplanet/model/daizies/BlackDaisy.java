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

    public boolean isComfortable(double temperature) {
        return false;
    }

    public boolean isFitForLife(double temperature) {
        return false;
    }
}
