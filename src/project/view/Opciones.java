/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class Opciones {

    private GridPane grid;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button conacto;

    public Opciones() {
         String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
        
        Text title = new Text("CHAZZI");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(70);
        this.grid.add(title, 0, 0);

        this.b1 = new Button("Modificar datos");
        this.b2 = new Button("Historial");
        this.b3 = new Button("Volver");
        this.b4 = new Button("Salir");
        this.b5 = new Button("Cambiar contraseña");
        this.conacto=new Button("Contacto");
        this.conacto.setMaxWidth(Double.MAX_VALUE);
        this.b1.setMaxWidth(Double.MAX_VALUE);
        this.b2.setMaxWidth(Double.MAX_VALUE);
        this.b3.setMaxWidth(Double.MAX_VALUE);
        this.b4.setMaxWidth(Double.MAX_VALUE);
        this.b5.setMaxWidth(Double.MAX_VALUE);
        VBox vbox = new VBox(b5, b1,conacto, b3, b4);
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Opciones");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getB1() {
        return b1;
    }

    public void setB1(Button b1) {
        this.b1 = b1;
    }

    public Button getB2() {
        return b2;
    }

    public void setB2(Button b2) {
        this.b2 = b2;
    }

    public Button getB3() {
        return b3;
    }

    public void setB3(Button b3) {
        this.b3 = b3;
    }

    public Button getB4() {
        return b4;
    }

    public void setB4(Button b4) {
        this.b4 = b4;
    }

    public Button getB5() {
        return b5;
    }

    public Button getConacto() {
        return conacto;
    }

    public void setB5(Button b5) {
        this.b5 = b5;
    }

}
