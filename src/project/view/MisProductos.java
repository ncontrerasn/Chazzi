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
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class MisProductos {

    private GridPane grid;

    private TableView tableView;
    
    private Button backBttn;
    
    private Button removeBttn;

    public MisProductos() {
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

        this.tableView = new TableView();
        TableColumn image = new TableColumn("");
        TableColumn product = new TableColumn("Nombre");
        TableColumn hour = new TableColumn("Cantidad");
        TableColumn price = new TableColumn("Precio");

        //Parámetros a extraer de la clase producto
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        product.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        hour.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        price.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));

        tableView.getColumns().addAll(image, product, hour, price);

        this.backBttn = new Button("Cancelar");
        this.removeBttn = new Button("Borrar Item");
        
        VBox vbox = new VBox(this.tableView, this.removeBttn, this.backBttn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(25);
        this.grid.add(vbox, 0, 1);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Confirmacion de pedido");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public Button getBackBttn() {
        return backBttn;
    }

    public void setBackBttn(Button backBttn) {
        this.backBttn = backBttn;
    }

    

    public Button getRemoveBttn() {

        return this.removeBttn;
    }
    
    

}
