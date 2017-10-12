package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 11.10.17.
 */
public class TemperatureLayer {
    final int UNIT_H=3;
    final int UNIT_W=20;
    final int RIGHT_BORDER = 560;
    final int TOP = 7;
    Color hotDeadTemper = Color.RED;
    Color coldDeadTemper = Color.BLUE;
    Color comfortTekmper = Color.GREEN;
    Color aliveTemper = Color.YELLOW;

    TemperatureUnit[] blackScale;
    TemperatureUnit[] whiteScale;

    public TemperatureLayer(Planet planet) {
        blackScale = new TemperatureUnit[planet.getZones().length*2];
        whiteScale = new TemperatureUnit[planet.getZones().length*2];
        int j;
        for(int i=0; i<blackScale.length/2; i++){
            j=i+blackScale.length/2;
            blackScale[i] = new TemperatureUnit(
                    RIGHT_BORDER,
                    TOP+i*UNIT_H,
                    coldDeadTemper
            );
            blackScale[j] = new TemperatureUnit(
                    RIGHT_BORDER,
                    TOP+j*UNIT_H,
                    coldDeadTemper
                    );
            whiteScale[i] = new TemperatureUnit(
                    RIGHT_BORDER+UNIT_W,
                    TOP+i*UNIT_H,
                    coldDeadTemper
                    );
            whiteScale[j] = new TemperatureUnit(
                    RIGHT_BORDER+UNIT_W,
                    TOP+j*UNIT_H,
                    coldDeadTemper
                    );
        }
    }

    public void ekspose(GraphicsContext gc){
        for(int i=0;i<blackScale.length;i++){
            blackScale[i].expose(gc);
            whiteScale[i].expose(gc);
        }
    }





}
