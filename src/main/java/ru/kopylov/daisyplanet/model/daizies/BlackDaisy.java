package ru.kopylov.daisyplanet.model.daizies;

import ru.kopylov.daisyplanet.utils.Conditions;

/**
 * Created by sergey on 17.08.17.
 */
public class BlackDaisy extends Daisy {

    double albedo = Conditions.blackDaisyAlbedo;

    Type getType() {
        return Type.BLACK;
    }

    double getAlbedo() {
        return albedo;
    }
}
