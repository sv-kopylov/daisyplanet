package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class WhiteDaizy extends Daisy {

    double albedo = Conditions.whiteDaisyAlbedo;
    Type getType() {
        return Type.WHITE;
    }

    double getAlbedo() {
        return albedo;
    }

    boolean isComfortable(double temperature) {
        return false;
    }

    boolean isFitForLife(double temperature) {
        return false;
    }
}
