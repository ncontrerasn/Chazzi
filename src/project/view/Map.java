/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class Map {

    private GridPane grid;

    private Button backBttn;
    private Button create;

    public Map() throws FileNotFoundException {
        this.grid = new GridPane();
        String style = "-fx-background-color: rgb(255, 255, 255);";
        Text title = new Text("MapUN");
        title.setFill(Color.BLACK);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(12);
        this.grid.add(title, 0, 0);

        FileInputStream input = new FileInputStream("mapaUN.png");
        Image map = new Image(input);
        ImageView imgView = new ImageView(map);
        imgView.setFitHeight(map.getHeight() * 7 / 8);
        imgView.setFitWidth(map.getWidth() * 7 / 8);
        Label m = new Label("", imgView);
        this.grid.add(m, 0, 1);

        this.backBttn = new Button("Volver");
        this.backBttn.setAlignment(Pos.BOTTOM_LEFT);
        this.grid.add(this.backBttn, 1, 1);
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
