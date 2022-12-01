package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ContenedorJuego extends BorderPane {

    public ContenedorJuego(Stage stage, Juego juego) {
        Label labelHud = new Label("");
        File fileHudJuego = new File("images/hudJuego.png");
        Image imagenHudJuego = new Image(fileHudJuego.toURI().toString(),1700, 1600, true, true );



        labelHud.setGraphic(new ImageView(imagenHudJuego) );
        Canvas canvas = new Canvas(1700,1600);
        canvas.getGraphicsContext2D().setFill(Color.GRAY);
        canvas.getGraphicsContext2D().fillRect(0,0,1700,1600);
        Group unGrupo = new Group(canvas,labelHud);
        this.setBottom(unGrupo);



        Criadero criadero = new Criadero();

        GridPane gridPane = new GridPane();
        gridPane.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setAlignment(Pos.CENTER);
        final int TAMANIO = 100;

        // Tierra
        File fileFondo = new File("images/tierra.png");
        Image imagenRaza = new Image(fileFondo.toURI().toString(),TAMANIO, TAMANIO, true, true );

        BackgroundImage primerBackGro = new BackgroundImage(
                imagenRaza,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );





        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                try {
                    Button btn = new Button();
                    //btn.setGraphic( new ImageView(imagenRaza) );
                    //btn.setMinSize(TAMANIO,TAMANIO);
                    btn.setPrefSize(TAMANIO, TAMANIO);
                    btn.setBackground( new Background(primerBackGro) );

                    gridPane.add(btn, i, j);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }

        // Criadero
        File criaderoFile = new File("images/criadero.png");
        Image criaderoImage = new Image(criaderoFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage criaderoBackGro = new BackgroundImage(
                criaderoImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnCriadero = new Button();
        btnCriadero.setMinSize(TAMANIO,TAMANIO);
        btnCriadero.setBackground( new Background(criaderoBackGro) );
        gridPane.add(btnCriadero, 0, 0);



        // Mineral
        File mineralFile = new File("images/mineral.png");
        Image mineralImage = new Image(mineralFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage mineralBackGro = new BackgroundImage(
                mineralImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnMineral = new Button();
        btnMineral.setMinSize(TAMANIO,TAMANIO);
        btnMineral.setBackground( new Background(mineralBackGro) );
        gridPane.add(btnMineral, 3, 2);

        Button btnMineral2 = new Button();
        btnMineral2.setMinSize(TAMANIO,TAMANIO);
        btnMineral2.setBackground( new Background(mineralBackGro) );
        gridPane.add(btnMineral2, 6, 9);


        // Volcan
        File volcanFile = new File("images/volcan.png");
        Image volcanImage = new Image(volcanFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage volcanBackGro = new BackgroundImage(
                volcanImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnVolcan = new Button();
        btnVolcan.setMinSize(TAMANIO,TAMANIO);
        btnVolcan.setBackground( new Background(volcanBackGro) );
        gridPane.add(btnVolcan, 2, 5);

        Button btnVolcan2 = new Button();
        btnVolcan2.setMinSize(TAMANIO,TAMANIO);
        btnVolcan2.setBackground( new Background(volcanBackGro) );
        gridPane.add(btnVolcan2, 7, 7);


        // Pilon
        File pilonFile = new File("images/pilon.png");
        Image pilonImage = new Image(pilonFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage pilonBackGro = new BackgroundImage(
                pilonImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnPilon = new Button();
        btnPilon.setMinSize(TAMANIO,TAMANIO);
        btnPilon.setBackground( new Background(pilonBackGro) );
        gridPane.add(btnPilon, 9, 9);

        this.setCenter(gridPane);
    }



    private int getRandom(int limite){
        return (int) (Math.random() * limite);
    }


}


