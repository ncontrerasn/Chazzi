/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.Contacto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCContacto {

    //modelo
    public Mapa modelo;

    //vista
    public Contacto view;
    public Usuario miUsuario;
    private final int opcion;

    public VCContacto(Mapa modelo, Usuario usuario,int opcion) {
        this.modelo = modelo;
        this.view = new Contacto();
        this.miUsuario=usuario;
        this.opcion=opcion;

        //Registrar EventHandlers a cada objeto de la vista
        view.getBack().setOnAction(new BackBttnHandler());
        view.getSend().setOnAction(new SendBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(opcion==1){
                VCOpciones initial;
                initial = new VCOpciones(modelo,1,miUsuario);
                initial.show();
            }else{
                VCOpciones initial;
                initial = new VCOpciones(modelo,0,miUsuario);
                initial.show();
            }
        }

    }

    private class SendBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(view.getSubject().getText().isEmpty() || view.getMessage().getText().isEmpty()){
                view.getConfirmar().setText("Rellenar todos los espacios.");
            }else{
                view.getSubject().clear();
                view.getMessage().clear();
                view.getConfirmar().setText("Mensaje enviado.");
            }
            
        }

    }
}
