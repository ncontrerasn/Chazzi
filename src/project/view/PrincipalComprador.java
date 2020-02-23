/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.Timer;
import project.controller.VCMapa;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class PrincipalComprador {

    private GridPane grid;
    private Text user;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private String usuario;
    private VCMapa m;
   private Mapa modelo;
    //private MapView mapa;

    public PrincipalComprador(ArrayList<Point2D> puntos, Mapa modelo, String usuario) throws FileNotFoundException {
        String style = "-fx-background-image: url('file:default.png')";
        this.modelo=modelo;
        this.grid = new GridPane();
        this.usuario = usuario;
       
        Text title = new Text("MapUN");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        user = new Text("Comprador");
        user.setFill(Color.WHITE);
        FileInputStream input = new FileInputStream("question-mark.png");
        Image quest = new Image(input) {
        };
        Label l = new Label("", new ImageView(quest));
        input = new FileInputStream("mapaUN.png");
        Image map = new Image(input) {
        };

        this.m = new VCMapa(modelo, false, puntos, usuario);
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(15.5);
        this.grid.add(title, 0, 0);
        this.grid.add(user, 1, 0);
        GridPane.setHalignment(user, HPos.CENTER);
        this.grid.add(l, 3, 0);
        GridPane.setHalignment(l, HPos.CENTER);
        this.grid.add(this.m.getView().getMapView(), 0, 1);

        this.b1 = new Button("Cerrar Sesión");
        this.b2 = new Button("Opciones");
        this.b3 = new Button("Mapa Completo");
        this.b4 = new Button("Nosotros");
        this.b5 = new Button("Mis Pedidos");
        //Sets the maxWidth value for all the buttons in the maximum double value, so the VBox can adjust them to fill the H. Space 
        this.b1.setMaxWidth(Double.MAX_VALUE);
        this.b2.setMaxWidth(Double.MAX_VALUE);
        this.b3.setMaxWidth(Double.MAX_VALUE);
        this.b4.setMaxWidth(Double.MAX_VALUE);
        this.b5.setMaxWidth(Double.MAX_VALUE);
        VBox vbox = new VBox(b5, b2, b4, b1);
        vbox.setSpacing(50);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 1, 1);
    }

    public void show(Stage primaryStage) throws FileNotFoundException, ParseException {
        primaryStage.setMaxHeight(900);
        primaryStage.setMinHeight(1800);
        primaryStage.setMaxWidth(900);
        primaryStage.setMinWidth(1800);
       // modelo.cargarDatosFacturaChazas();
        
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.setMaximized(true);
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
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

    public Text getTextUser() {
        return this.user;
    }

    public Button getB5() {
        return this.b5;
    }

    public Button getB1() {
        return this.b1;
    }

    public VCMapa getM() {
        return m;
    }

    public void setM(VCMapa m) {
        this.m = m;
    }
    
    
}
