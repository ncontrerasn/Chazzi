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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class ListaFacturas {

    private GridPane grid;

    private TableView tabla;
    private Button regresarBttn;
    private Button abrirBttn;
    private Button validarBttn;
    private Button refresh;

    public ListaFacturas() {
         String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
     
        Text title = new Text("CHAZZI");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        title.setTextAlignment(TextAlignment.CENTER);
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(100);
        this.grid.setVgap(50);
        this.grid.add(title, 0, 0);
        this.refresh=new Button("Refrescar");
        this.abrirBttn = new Button("Abrir");
        this.abrirBttn.setMaxWidth(Double.MAX_VALUE);
        this.validarBttn = new Button("Validar");
        this.validarBttn.setMaxWidth(Double.MAX_VALUE);
        this.regresarBttn = new Button("Volver");
        this.regresarBttn.setMaxWidth(Double.MAX_VALUE);
        VBox botones = new VBox(this.refresh,this.abrirBttn, this.validarBttn, this.regresarBttn);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(20);
        this.tabla = new TableView();
        this.tabla.setMinSize(700, 450);
        TableColumn chaza = new TableColumn("Chaza");
        TableColumn fecha = new TableColumn("Fecha");
        TableColumn estado = new TableColumn("Estado");

        //Parámetros a extraer de la clase producto
        chaza.setCellValueFactory(new PropertyValueFactory<>("chaza"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        this.tabla.getColumns().addAll(chaza, estado, fecha);
        HBox hbox = new HBox(this.tabla, botones);
        hbox.setSpacing(70);
        Label titulo = new Label("Mis Pedidos");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titulo.textFillProperty().set(Color.WHITE);
        VBox vbox = new VBox(titulo, hbox);
        vbox.setSpacing(40);
        this.grid.add(vbox, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TableView getTabla() {
        return tabla;
    }

    public void setTabla(TableView tabla) {
        this.tabla = tabla;
    }

    public Button getRegresarBttn() {
        return regresarBttn;
    }

    public void setRegresarBttn(Button regresarBttn) {
        this.regresarBttn = regresarBttn;
    }

    public Button getAbrirBttn() {
        return abrirBttn;
    }

    public void setAbrirBttn(Button abrirBttn) {
        this.abrirBttn = abrirBttn;
    }

    public Button getValidarBttn() {
        return validarBttn;
    }

    public void setValidarBttn(Button validarBttn) {
        this.validarBttn = validarBttn;
    }
    public Button getRefreshBttn(){
        return this.refresh;
    }

}
