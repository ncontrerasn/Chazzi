/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.Historial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class VCHistorial {

    //modelo
    public Mapa modelo;

    //vista
    public Historial view;

    public VCHistorial(Mapa modelo) {
        this.modelo = modelo;
        this.view = new Historial();

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBackBttn().setOnAction(new BackBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

        }

    }
}
