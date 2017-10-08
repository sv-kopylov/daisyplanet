package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sergey on 05.10.17.
 */
public class PlanetLayer {
    DaizyUnit[][] daizyUnits;

    public PlanetLayer(Planet planet) throws Exception {
        Zone [] zones = planet.getZones();
        int height = zones.length;
        if(height>90){
            throw new Exception("Planet too big, scalling not implemented");
        }
        daizyUnits = new DaizyUnit[height*2][];
        int width = 0;
        for(int i=0, j=(height*2)-1; i<height; i++, j--){
            width = (int) (2*Math.round(Math.sqrt(height*height-i*i)));
            daizyUnits[height-1-i] = new DaizyUnit[width];
            daizyUnits[height+i] = new DaizyUnit[width];
        }

Color col = Color.CHOCOLATE;
        for(int i=0; i<daizyUnits.length; i++){
            for(int j=0;j<daizyUnits[i].length; j++){
                if(j<daizyUnits[i].length/2){
                    col=Color.GREEN;
                }
                daizyUnits[i][j] = new DaizyUnit(
                        + j*3 - daizyUnits[i].length*3/2 +300,
                        i*3+50,
                         col
                );
                col=Color.CHOCOLATE;
            }
        }


    }

    public PlanetLayer() {
        int h = 100;
        int w = 100;
        Color[] colors = {Color.GREEN, Color.RED, Color.BLACK
                            };
        Random rnd = new Random();
        daizyUnits = new DaizyUnit[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                daizyUnits[i][j] = new DaizyUnit(
                        50+i*3,
                        50+j*3,
                        colors[rnd.nextInt(3)]
                );

            }
        }
    }

    public void setColours(Planet planet){

    }

    public void ekspose(GraphicsContext gc){
        for(DaizyUnit[] unitsArr: daizyUnits){
            for(DaizyUnit unit: unitsArr){
                unit.expose(gc);
            }
        }
    }

}
