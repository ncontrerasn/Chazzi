/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
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
public class Pedidos {

    private GridPane grid;

    private ListPanes listpanes;
    private Button backBttn;

    public Pedidos() throws FileNotFoundException {
        String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
       
        Text title = new Text("ChaZZi");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        FileInputStream input = new FileInputStream("question-mark.png");
        Image quest = new Image(input);
        Label l = new Label("", new ImageView(quest));
        input = new FileInputStream("mapaUN.png");
        Image map = new Image(input);
        ImageView imgView = new ImageView(map);
        imgView.setFitWidth(map.getWidth()/2);
        imgView.setFitHeight(map.getHeight()/2);
        Label m = new Label("", imgView);
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(15.5);
        this.grid.add(title, 0, 0);
        this.grid.add(l, 3, 0);
        GridPane.setHalignment(l, HPos.CENTER);
        this.grid.add(m, 0, 1);

        this.listpanes = new ListPanes();
        this.listpanes.addButtonNode(new ToggleButton("New 1"));
        this.listpanes.addButtonNode(new ToggleButton("New 2"));
        this.listpanes.changeNodePane(new Label("Vale Verga\nLa Vida\n"));
        this.grid.add(this.listpanes.getComplete(), 1, 1);
        GridPane.setValignment(this.listpanes.getComplete(), VPos.CENTER);
        this.backBttn = new Button("Volver");
        this.grid.add(this.backBttn, 1, 2);
        GridPane.setHalignment(this.backBttn, HPos.CENTER);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
}
