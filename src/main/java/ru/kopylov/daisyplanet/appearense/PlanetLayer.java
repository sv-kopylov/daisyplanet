package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;


/**
 * Created by sergey on 05.10.17.
 */
public class PlanetLayer {
    DaizyUnit[][] daizyUnits;
    Color baseColor = Color.OLIVE;
    Color white = Color.WHITE;
    Color black = Color.BLACK;
    private int MAX_RADIUS = 90;
    private int POINT_DIAMETER = 3;

    public PlanetLayer(Planet planet) throws Exception {
         Zone [] zones = planet.getZones();
        int height = zones.length;
        if(height>MAX_RADIUS ){
            throw new Exception("Planet too big, scalling not implemented");
        }
        daizyUnits = new DaizyUnit[height*2][];
        int width = 0;
        for(int i=0, j=(height*2)-1; i<height; i++, j--){
            width = (int) (2*Math.round(Math.sqrt(height*height-i*i)));
            daizyUnits[height-1-i] = new DaizyUnit[width];
            daizyUnits[height+i] = new DaizyUnit[width];
        }


        for(int i=0; i<daizyUnits.length; i++){
            for(int j=0;j<daizyUnits[i].length; j++){
                daizyUnits[i][j] = new DaizyUnit(
                        + j*POINT_DIAMETER - daizyUnits[i].length*POINT_DIAMETER/2 +280,
                        i*POINT_DIAMETER+10,
                        baseColor
                );

            }
        }


    }

    public void setColors(Planet planet){
        Zone[] zones = planet.getZones();
        int blackNum;
        int whiteNum;
        int zoneIndex;
        long numCells = Conditions.getInstance().daiziesPerZone;
        Color currentColor;

        for(int i=0; i<daizyUnits.length/2; i++){
            zoneIndex = zones.length-1-i;
            blackNum=(int)(daizyUnits[i].length*zones[zoneIndex].getNumBlackDaisies()/numCells);
            whiteNum=blackNum+(int)(daizyUnits[i].length*zones[zoneIndex].getNumWhiteDaisies()/numCells);

            for(int j=0;j<daizyUnits[i].length; j++){
                if(j<blackNum){
                    currentColor = black;
                } else if(j<whiteNum){
                    currentColor = white;
                } else {
                    currentColor = baseColor;
                }
                daizyUnits[i][j].setColor(currentColor);
                daizyUnits[daizyUnits.length - 1 -i][j].setColor(currentColor);

            }
        }

    }

    public void ekspose(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 630, 560);
        gc.setFill(Color.OLIVE);
        gc.fillOval(7,7,547,547);
//        gc.strokeRect(0,0,589, 559);
        for(DaizyUnit[] unitsArr: daizyUnits){
            for(DaizyUnit unit: unitsArr){
                unit.expose(gc);
            }
        }
    }

}
