/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class Nosotros {

    private GridPane grid;

    private Button backBttn;

    public Nosotros() {
         String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
       
        Text title = new Text("CHAZZI");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(100);
        this.grid.setVgap(50);
        this.grid.add(title, 0, 0);

        Label us = new Label("Nosotros");
        us.setAlignment(Pos.CENTER);
        us.setFont(Font.font(30));
        Label paragraph = new Label("Somos estudiantes de ingenieria de sistemas de la Universidad Nacional de Colombia"
                + "\n\nPero proximamente futuros desarrallores expertos: \n\nMapUN es una herramienta virtual que brinda una solución al "
                + "problema de la escasa oferta y gran demanda en productos comestibles debido al \ndéficit de cafeterías, "
                + "haciendo que los estudiantes busquen alternativas como las bien conocidas “chazas”. \n\nNuestra aplicación "
                + "promueve la buena imagen de la universidad, ya que ofrecemos los servicios de las chazas sin que estas "
                + "tengan que estar tan expuestas al publico\n\nMapUN Chazzi conecta clientes y vendedores, dando a conocer "
                + "todos sus productos, haciendo que los usuarios conozcan los productos que los vendedores disponen para la "
                + "venta \nen el momento en el que el usuario este interesado");
        this.backBttn = new Button("Volver");
        paragraph.textFillProperty().set(Color.WHITE);
        VBox vbox = new VBox(us, paragraph);
        VBox vboxP = new VBox(vbox, backBttn);
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);
        vboxP.setSpacing(50);
        vboxP.setAlignment(Pos.CENTER);
        this.grid.add(vboxP, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getBackBttn() {
        return backBttn;
    }

    public void setBackBttn(Button backBttn) {
        this.backBttn = backBttn;
    }

}
