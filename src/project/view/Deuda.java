/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.util.Date;
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
public class Deuda {

    private GridPane grid;

    private Label chaza;
    private Label usuario;
    private Label fecha;
    private Label total;
    
    private Button regresarBttn;
    private Button pagarBttn;

    public Deuda() {
         String style = "-fx-background-image: url('file:factura.png')";
        this.grid = new GridPane();
        
        Text title = new Text("Tu Deuda con CHAZZI");
        title.setFill(Color.BLACK);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(100);
        this.grid.setVgap(50);
        this.grid.add(title, 0, 0);

        Label titulol = new Label("Factura/Pedido");
        Label chazal = new Label("Empresa : CHAZZI");
        Label usuario1= new Label("Usuario: ");
        Label fechal = new Label("Fecha :"+ new Date());
        Label totall = new Label("Total :");
        VBox left = new VBox(titulol, chazal, usuario1,fechal, totall);
        this.chaza = new Label("");
        this.usuario=new Label("");
        this.fecha = new Label("");
        this.total = new Label("");
        VBox right = new VBox(new Label(""), this.chaza,this.usuario, this.fecha, this.total);
        HBox suph = new HBox(left, right);
       
        this.regresarBttn = new Button("Volver");
        this.pagarBttn=new Button("Pagar");
        HBox infh = new HBox(this.pagarBttn, this.regresarBttn);
        VBox parentv = new VBox(suph, infh);
        infh.setAlignment(Pos.CENTER);
        infh.setSpacing(50);
        parentv.setSpacing(15);
        this.grid.add(parentv, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Label getChaza() {
        return chaza;
    }

    public void setChaza(Label chaza) {
        this.chaza = chaza;
    }

    public Label getFecha() {
        return fecha;
    }

    public void setFecha(Label fecha) {
        this.fecha = fecha;
    }

    public Label getTotal() {
        return total;
    }

    public void setTotal(Label total) {
        this.total = total;
    }

   

    public Button getRegresarBttn() {
        return regresarBttn;
    }

    public void setRegresarBttn(Button regresarBttn) {
        this.regresarBttn = regresarBttn;
    }
    public Label getUsuario(){
        return this.usuario;
    }
    
    public Button pagarBttn()
    {
        return this.pagarBttn;
    }
}
