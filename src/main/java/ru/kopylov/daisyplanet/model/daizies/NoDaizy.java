package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class NoDaizy extends Daisy {
    double albedo = Conditions.noDaisyAlbedo;

    Type getType() {
        return Type.NONE;
    }

    double getAlbedo() {
        return albedo;
    }
}
