/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class ViewController {

    //modelo
    public Mapa modelo;

    //vista
    public View view;

    public ViewController(Mapa modelo) {
        this.modelo = modelo;
        this.view = new View();

        //Registrar EventHandlers a cada objeto de la vista
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class ClaseControladora implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

        }

    }
}
