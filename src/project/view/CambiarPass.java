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
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class CambiarPass {

    private GridPane grid;

    private TextField inActual;
    private TextField inNew;
    private TextField inNew2;
    private Button change;
    private Button back;
    private Label confirmar;

    public CambiarPass() {
        String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
     
        Text title = new Text("CHAZZI");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(50);
        this.grid.setVgap(75);
        this.grid.add(title, 1, 0);

        this.confirmar=new Label("");
        Label user = new Label("Contraseña actual");
         user.textFillProperty().set(Color.WHITE);
        this.inActual = new TextField();
        Label password = new Label("Nueva contraseña");
         password.textFillProperty().set(Color.WHITE);
        this.inNew = new TextField();
        Label email = new Label("Confirme nueva contraseña");
         email.textFillProperty().set(Color.WHITE);
        this.inNew2 = new TextField();
        this.back = new Button("Volver");
        this.back.setMaxWidth(Double.MAX_VALUE);
        this.change = new Button("Cambiar Contraseña");
        this.change.setMaxWidth(Double.MAX_VALUE);
        VBox vbox = new VBox(user, this.inActual, password, this.inNew, email, this.inNew2, this.confirmar, this.change);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 1, 1);
        this.grid.add(this.back, 2, 2);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Actualizacion de clave");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TextField getInActual() {
        return inActual;
    }

    public void setInActual(TextField inActual) {
        this.inActual = inActual;
    }

    public TextField getInNew() {
        return inNew;
    }

    public void setInNew(TextField inNew) {
        this.inNew = inNew;
    }

    public TextField getInNew2() {
        return inNew2;
    }

    public Label getConfirmar() {
        return confirmar;
    }

    public void setInNew2(TextField inNew2) {
        this.inNew2 = inNew2;
    }

    public Button getChange() {
        return change;
    }

    public void setChange(Button change) {
        this.change = change;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }
}
