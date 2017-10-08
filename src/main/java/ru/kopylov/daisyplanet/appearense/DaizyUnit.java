package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by sergey on 05.10.17.
 */
public class DaizyUnit {
    private float x;
    private float y;
    private Color color;

    public DaizyUnit(float x, float y, Color color) {
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
        gc.fillOval(x,y,3,3);

    }





}
