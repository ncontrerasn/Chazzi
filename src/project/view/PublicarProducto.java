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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class PublicarProducto {

    private GridPane grid;

    private Button postProd;
    private Button cancel;

    private TextField prodName;
    private TextField precioVenta;
    private TextField cantidad;
    
    private Label confirmar;

    public PublicarProducto() {
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

        Label prodNameLb = new Label("Nombre");
        prodNameLb.textFillProperty().set(Color.WHITE);
        this.prodName = new TextField();
        
        Label labelPrecio = new Label("Precio de venta $");
        labelPrecio.textFillProperty().set(Color.WHITE);
        this.precioVenta=new TextField();
        Label labelCantidad=new Label("Cantidad ");
        labelCantidad.textFillProperty().set(Color.WHITE);
        this.cantidad=new TextField();
        this.confirmar=new Label("");
        this.cancel = new Button("Cancelar");
        this.postProd = new Button("Publicar producto");
        VBox vbox = new VBox(prodNameLb, this.prodName, labelPrecio, this.precioVenta,labelCantidad,this.cantidad,this.confirmar);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(this.postProd, this.cancel);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        this.grid.add(vbox, 0, 1);
        this.grid.add(hbox, 0, 2);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Agregar un nuevo producto");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getPostProd() {
        return postProd;
    }

    public void setPostProd(Button postProd) {
        this.postProd = postProd;
    }

    public Button getCancel() {
        return cancel;
    }

    public Label getConfirmar() {
        return confirmar;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public TextField getProdName() {
        return prodName;
    }

    public void setProdName(TextField prodName) {
        this.prodName = prodName;
    }

    public TextField getPrecioVenta() {
        return precioVenta;
    }

    public TextField getCantidad() {
        return cantidad;
    }


}
