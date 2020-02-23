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
public class Contacto {

    private GridPane grid;

    private Button send;
    private Button back;

    private TextField subject;
    private TextArea message;
    
    private Label confirmar;

    public Contacto() {
        String style = "-fx-background-image: url('file:default.png')";
        this.grid = new GridPane();
        
        Text title = new Text("Contacto");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(10);
        this.grid.setVgap(15);
        
        this.confirmar=new Label("");
        Label subjectLb = new Label("Asunto del mensaje, sugerencia o reclamo");
        subjectLb.textFillProperty().set(Color.WHITE);
        this.subject = new TextField();
        Label messageLb = new Label("contenido");
        messageLb.textFillProperty().set(Color.WHITE);
        this.message = new TextArea();
        this.message.boundsInParentProperty();
        this.back = new Button("Volver");
        this.send = new Button("Enviar");
        VBox vbox = new VBox(subjectLb, this.subject);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(this.send, this.back);
        hbox.setAlignment(Pos.CENTER);
        VBox vboxP = new VBox(title,vbox, messageLb, this.message,confirmar, hbox);
        vboxP.setAlignment(Pos.CENTER);

        this.grid.add(vboxP, 0, 1);
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Contacto");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public Button getSend() {
        return send;
    }

    public void setSend(Button send) {
        this.send = send;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

    public TextField getSubject() {
        return subject;
    }

    public Label getConfirmar() {
        return confirmar;
    }

    public void setSubject(TextField subject) {
        this.subject = subject;
    }

    public TextArea getMessage() {
        return message;
    }

    public void setMessage(TextArea message) {
        this.message = message;
    }

}
