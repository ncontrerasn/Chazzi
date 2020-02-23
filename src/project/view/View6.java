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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class View6 {//registro usuario

    private GridPane grid;
    
    private TextField inName;
    
    private TextField inUser;
    private TextField inPass;
    
    private TextField inPhone;
    private Button b1;
    
    private Label confirmar;

    public View6() {
        this.grid = new GridPane();
        String style = "-fx-background-image: url('file:Register.png')";
       // Text title = new Text("MapUN");
        //title.setFill(Color.BLACK);
        //title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        
        //title.setTextAlignment(TextAlignment.CENTER);
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(15.5);
        this.grid.setVgap(100);
       // this.grid.add(title, 0, 0);
        Label name = new Label("Nombre");
        this.inName=new TextField();
        name.textFillProperty().set(Color.WHITE);
        
        Label user = new Label("Usuario");
        user.textFillProperty().set(Color.WHITE);
        this.inUser = new TextField();
        Label password = new Label("Contraseña");
        password.textFillProperty().set(Color.WHITE);
        this.inPass = new TextField();
        
        Label phone = new Label("Telefono");
        phone.textFillProperty().set(Color.WHITE);
        this.inPhone = new TextField();
        this.confirmar=new Label("");
        this.b1 = new Button("Registrarse");
        this.b1.setMaxWidth(Double.MAX_VALUE);
        VBox vbox = new VBox(name, this.inName,user, this.inUser, password, this.inPass, phone, this.inPhone, this.confirmar, this.b1);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);

        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TextField getInUser() {
        return inUser;
    }

    public void setInUser(TextField inUser) {
        this.inUser = inUser;
    }

    public TextField getInPass() {
        return inPass;
    }

    public void setInPass(TextField inPass) {
        this.inPass = inPass;
    }

    public TextField getInName() {
        return inName;
    }
    
    public TextField getInPhone() {
        return inPhone;
    }

    public void setInPhone(TextField inPhone) {
        this.inPhone = inPhone;
    }

    public Button getB1() {
        return b1;
    }

    public void setB1(Button b1) {
        this.b1 = b1;
    }

    public Label getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(Label confirmar) {
        this.confirmar = confirmar;
    }

}
