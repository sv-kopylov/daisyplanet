package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by sergey on 11.10.17.
 */
public class TemperatureUnit {
    private float x;
    private float y;
    private Color color;
    final int UNIT_H=3;
    final int UNIT_W=20;


    public TemperatureUnit(float x, float y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void expose (GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(x,y,UNIT_W,UNIT_H);


    }
}
