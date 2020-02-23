/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import project.controller.VCMapa;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class PrincipalVendedor {
    
    private GridPane grid;
    
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Text user;
    private MapView mapa;
    
    public PrincipalVendedor(ArrayList<Point2D> puntos,Mapa modelo) throws FileNotFoundException {
        //  this.mapa=new MapView(modelo.getPrimaryStage(),puntos , 1, false);
        String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
        
        Text title = new Text("MapUN");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        user = new Text("Vendedor");
        user.setFill(Color.WHITE);
        FileInputStream input = new FileInputStream("question-mark.png");
        Image quest = new Image(input);
        Label l = new Label("", new ImageView(quest));
        
        VCMapa m = new VCMapa(modelo, true, puntos,"");
        
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
        this.grid.add(m.getView().getMapView(), 0, 1);
        this.b7=new Button("Cerrar Sesión");
        this.b6=new Button("Mis productos");
        this.b1 = new Button("Ordenes");
        this.b2 = new Button("Publicar Producto");
        this.b3 = new Button("Opciones");
        this.b4 = new Button("Mi deuda CHAZZI");
        this.b5 = new Button("Nosotros");
        this.b1.setMaxWidth(Double.MAX_VALUE);
        this.b2.setMaxWidth(Double.MAX_VALUE);
        this.b3.setMaxWidth(Double.MAX_VALUE);
        this.b4.setMaxWidth(Double.MAX_VALUE);
        this.b5.setMaxWidth(Double.MAX_VALUE);
         this.b6.setMaxWidth(Double.MAX_VALUE);
           this.b7.setMaxWidth(Double.MAX_VALUE);
        VBox vbox = new VBox(b1,b6, b2, b3, b5,b7,b4);
        vbox.setSpacing(50);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 1, 1);
        
    }
    
    public void show(Stage primaryStage) {
         primaryStage.setMaxHeight(900);
        primaryStage.setMinHeight(1800);
        primaryStage.setMaxWidth(900);
        primaryStage.setMinWidth(1800);
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.setMaximized(true);
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
    
    public void setB5(Button b5) {
        this.b5 = b5;
    }

    public Text getUserText() {
        return this.user;
    }
    public Button getB6(){
        return this.b6;
    }
    public Button getB7(){
        return this.b7;
    }
    
    
}
