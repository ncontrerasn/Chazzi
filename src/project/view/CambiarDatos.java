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
public class CambiarDatos {

    private GridPane grid;

    private TextField inTelNum;

    private Button saveBttn;
    private Button backBttn;
    
    private Label confirmar;

    public CambiarDatos() {
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

        this.confirmar=new Label("");
        Label nuevoTelefono = new Label("Número de teléfono");
        nuevoTelefono.textFillProperty().set(Color.WHITE);
        this.inTelNum = new TextField();
        this.saveBttn = new Button("Guardar Cambios");
        this.backBttn = new Button("Volver");
        VBox vbox = new VBox(nuevoTelefono, this.inTelNum,this.confirmar, this.saveBttn);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 0, 1);
        this.grid.add(this.backBttn, 1, 2);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Actualizacion de datos");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TextField getInTelNum() {
        return inTelNum;
    }

    public void setInTelNum(TextField inTelNum) {
        this.inTelNum = inTelNum;
    }

    public Button getSaveBttn() {
        return saveBttn;
    }

    public Label getConfirmar() {
        return confirmar;
    }

    public void setSaveBttn(Button saveBttn) {
        this.saveBttn = saveBttn;
    }

    public Button getBackBttn() {
        return backBttn;
    }

    public void setBackBttn(Button backBttn) {
        this.backBttn = backBttn;
    }

}
