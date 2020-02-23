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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class Loggeo {

    private GridPane grid;
    private Button enter;
    private TextField userTF;
    private PasswordField passwordTF;
    private Label revision;

    public Loggeo() throws FileNotFoundException {
        this.grid = new GridPane();
        this.userTF = new TextField();
        this.passwordTF = new PasswordField();
        String style = "-fx-background-image: url('file:LogIn.png')";
       // Text title = new Text("MapUN");
       // title.setFill(Color.BLACK);
        //title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        Label user = new Label("Usuario");
        user.textFillProperty().set(Color.WHITE);
        
        Label password = new Label("Contraseña");
        password.textFillProperty().set(Color.WHITE);
        FileInputStream input = new FileInputStream("question-mark.png");
        Image quest = new Image(input);
        Label l = new Label("", new ImageView(quest));

        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(201.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(15.5);
        //this.grid.add(title, 0, 0);
        this.grid.add(user, 0, 1);
        GridPane.setHalignment(user, HPos.CENTER);
        this.grid.add(this.userTF, 0, 2);
        this.grid.add(password, 0, 3);
        GridPane.setHalignment(password, HPos.CENTER);
        this.grid.add(this.passwordTF, 0, 4);
        this.grid.add(l, 0, 6);
        GridPane.setHalignment(l, HPos.CENTER);

        this.revision=new Label("");
        this.enter = new Button("Ingresar");
        VBox vbox=new VBox(this.revision, this.enter);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 0, 5);
        GridPane.setHalignment(vbox, HPos.CENTER);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getEnter() {
        return enter;
    }

    public void setEnter(Button enter) {
        this.enter = enter;
    }

    public TextField getUserTF() {
        return userTF;
    }

    public void setUserTF(TextField userTF) {
        this.userTF = userTF;
    }

    public TextField getPasswordTF() {
        return passwordTF;
    }

    public Label getRevision() {
        return revision;
    }

    public void setRevision(Label revision) {
        this.revision = revision;
    }

    public void setPasswordTF(PasswordField passwordTF) {
        this.passwordTF = passwordTF;
    }
}
