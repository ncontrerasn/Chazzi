/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.Inicial;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class VCInicial {

    //modelo
    public Mapa modelo;

    //vista
    public Inicial view;

    public VCInicial(Mapa modelo) {
        this.modelo = modelo;
        this.view = new Inicial();

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getNewUser().setOnAction(new NewUserBttnHandler());
        this.view.getNewChaza().setOnAction(new NewChazaBttnHandler());
        this.view.getLogin().setOnAction(new LoginBttnHandler());
        this.view.getExitBttn().setOnAction(new ExitBttnHandler());
    }

    public void show() {
        try {
            modelo.cargarDatosFacturasUsuarios();
           // modelo.cargarDatosFacturaChazas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VCInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VCInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        


        this.view.show(modelo.getPrimaryStage());
        
    }
    
    
    private class ExitBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
           System.exit(0);
        }

    }
    private class NewChazaBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            ViewController6_2 initial = new ViewController6_2(modelo);
            initial.show();
        }

    }

    //HacerClases EventHandlers
    private class NewUserBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            ViewController6 initial = new ViewController6(modelo);
            initial.show();
        }

    }
    
    private class LoginBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCLoggeo initial;
            try {
                initial = new VCLoggeo(modelo);
                initial.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
