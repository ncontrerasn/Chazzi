/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.view.CambiarPass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Chaza;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCCambiarPass {

    //modelo
    public Mapa modelo;

    //vista
    public CambiarPass view;
    public Usuario miUsuario;
    private final int opcion;

    public VCCambiarPass(Mapa modelo, Usuario usuario, int opcion) {
        this.modelo = modelo;
        this.view = new CambiarPass();
        this.opcion=opcion;
        this.miUsuario=usuario;

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBack().setOnAction(new BackBttnHandler());
        this.view.getChange().setOnAction(new ChangeBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class ChangeBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(opcion==1){
               Usuario u=modelo.buscarXUsuario(miUsuario.getNombreUsuario());
                if(view.getInActual().getText().isEmpty() || view.getInActual().getText().isEmpty()|| 
                        view.getInNew2().getText().isEmpty()){
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("Hay que rellenar todos los espacios.");
                }else if(modelo.buscarXUsuario(u.getNombreUsuario()).getClave().equals(view.getInActual().getText()) &&
                        view.getInActual().getText().equals(view.getInActual().getText())){
                    modelo.buscarXUsuario(u.getNombreUsuario()).setClave(view.getInActual().getText());
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("Clave actualizada.");
                }else{
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("La clave ingresada no concuerda con la anterior.");
                } 
            }else{
                Chaza c=modelo.buscarChazaXUsuario(miUsuario.getNombreUsuario());
                if(view.getInActual().getText().isEmpty() || view.getInActual().getText().isEmpty()|| 
                        view.getInNew2().getText().isEmpty()){
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("Hay que rellenar todos los espacios.");
                }else if(modelo.buscarChazaXUsuario(c.getNombreUsuario()).getClave().equals(view.getInActual().getText()) &&
                        view.getInActual().getText().equals(view.getInActual().getText())){
                    modelo.buscarChazaXUsuario(c.getNombreUsuario()).setClave(view.getInActual().getText());
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("Clave actualizada.");
                }else{
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getInActual().clear();
                    view.getConfirmar().setText("La clave ingresada no concuerda con la anterior.");
                } 
            }
            
        }
    }
    
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
}
    

