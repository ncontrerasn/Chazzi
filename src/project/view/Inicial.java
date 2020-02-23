/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class Inicial {

    private GridPane grid;

    private Button newUser;
    private Button newChaza;
    private Button login;
    private Button exit;

    public Inicial() {
        this.grid = new GridPane();

        String style = "-fx-background-image: url('file:Main.png')";
       // Text title = new Text("MapUN");
        //title.setFill(Color.BLACK);
        //title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(150.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(15.5);
       // this.grid.add(title, 0, 0);
       this.exit=new Button("Salir");
        this.newUser = new Button("Registrarse como Comprador");
        this.newChaza = new Button("Registrarse como Chaza");
        
        this.login = new Button("Iniciar Sesion");
        this.grid.add(exit, 0, 6);
        this.grid.add(newUser, 0, 3);
        this.grid.add(newChaza,0,4);
        this.grid.add(login, 0, 5);
GridPane.setHalignment(exit, HPos.CENTER);
        GridPane.setHalignment(newUser, HPos.CENTER);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setHalignment(newChaza, HPos.CENTER);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("MapUN");
        primaryStage.getScene().setRoot(this.grid);
     
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1150);
           primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(1150);
        primaryStage.setWidth(1150);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getNewUser() {
        return newUser;
    }
    public Button getNewChaza() {
        return newChaza;
    }

    public void setNewUser(Button newUser) {
        this.newUser = newUser;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }
    public Button getExitBttn(){
        return this.exit;
    }

}
