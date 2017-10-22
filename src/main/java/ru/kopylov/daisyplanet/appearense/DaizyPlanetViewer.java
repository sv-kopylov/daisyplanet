package ru.kopylov.daisyplanet.appearense;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 04.10.17.
 */
public class DaizyPlanetViewer extends Application{
    final Planet planet = new Planet();
    public static void main(String...args){
        launch(DaizyPlanetViewer.class, args);
    }

    public void init(){

    }
    @Override
    public void start(Stage primaryStage) throws Exception {

//        controllers
        PlanetLayer pl = new PlanetLayer(planet);
        TemperatureLayer tl = new TemperatureLayer(planet);
        InfoLayer il = new InfoLayer(planet);


        primaryStage.setTitle("Daizy planet view");
        Group root = new Group();
        BorderPane borderPane = new BorderPane();
        Canvas canvas= new Canvas(630, 560);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pl.ekspose(gc);
        tl.ekspose(gc);

        Charts charts = new Charts(primaryStage);
        Updater updater = new Updater(planet, pl, tl, il, gc, charts);
        Populator populator = new Populator(planet, pl, tl, il, gc);


        VBox leftPannel = new VBox();

        Pane pane = new Pane();
        pane.getChildren().add(canvas);



        borderPane.setCenter(pane);

        leftPannel.getChildren().addAll(populator.getPane(), updater.getPane(), charts.getPane());
        borderPane.setLeft(leftPannel);


        Scene scene = new Scene(root, 850, 600);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void stop(){

    }


}
