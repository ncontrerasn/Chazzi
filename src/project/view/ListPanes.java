/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Andryut Huertas
 */
public class ListPanes {
    
    private Pane pane;
    private VBox buttons;
    private HBox complete;
    
    public ListPanes() {
        this.pane = new Pane();
        this.pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.pane.setMinHeight(300);
        this.pane.setMinWidth(200);
        this.pane.setMaxHeight(300);
        this.pane.setMaxWidth(200);
        this.buttons = new VBox();
        this.complete = new HBox(buttons, pane);
    }
    
    public Pane getPane() {
        return pane;
    }
    
    public void setPane(Pane pane) {
        this.pane = pane;
    }
    
    public VBox getVbox() {
        return buttons;
    }
    
    public void setVbox(VBox vbox) {
        this.buttons = vbox;
    }
    
    public HBox getComplete() {
        return complete;
    }
    
    public void setComplete(HBox complete) {
        this.complete = complete;
    }
    
    public void changeNodePane(Node n) {
        this.pane.getChildren().clear();
        this.pane.getChildren().add(n);
        
    }
    
    public void addButtonNode(ToggleButton b) {
        this.buttons.getChildren().add(b);
    }
}
