/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.Pedidos;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class VCPedidos {

    //modelo
    public Mapa modelo;

    //vista
    public Pedidos view;

    public VCPedidos(Mapa modelo) throws FileNotFoundException {
        this.modelo = modelo;
        this.view = new Pedidos();

        
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
