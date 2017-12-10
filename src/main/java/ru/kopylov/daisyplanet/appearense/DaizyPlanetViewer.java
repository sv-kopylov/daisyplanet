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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 04.10.17.
 */
public class DaizyPlanetViewer extends Application{
    Planet planet;
    public static void main(String...args){
        launch(DaizyPlanetViewer.class, args);
    }

    public void init(){

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ru.kopylov.daisyplanet");
        planet = ctx.getBean(Planet.class);
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

        Charts charts = new Charts();
        Updater updater = new Updater(planet, pl, tl, il, gc, charts, borderPane);
        Populator populator = new Populator(planet, pl, tl, il, gc);


        VBox leftPannel = new VBox();

        Pane pane = new Pane();
        pane.getChildren().add(canvas);



        borderPane.setCenter(pane);

        leftPannel.getChildren().addAll(populator.getPane(), updater.getPane());
        borderPane.setLeft(leftPannel);
        borderPane.setRight(charts.getPane());


        Scene scene = new Scene(root, 1280, 600);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void stop(){

    }


}
