/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.CambiarDatos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Chaza;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCCambiarDatos {

    //modelo
    public Mapa modelo;

    //vista
    public CambiarDatos view;
    public Usuario miUsuario;
    private final int opcion;

    public VCCambiarDatos(Mapa modelo,int opcion,Usuario usuario) {
        this.modelo = modelo;
        this.view = new CambiarDatos();
        this.opcion=opcion;
        this.miUsuario=usuario;

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBackBttn().setOnAction(new BackBttnHandler());
        this.view.getSaveBttn().setOnAction(new SaveBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class SaveBttnHandler implements EventHandler<ActionEvent> {//aqui hay que modificar el campo de telefono 

        @Override
        public void handle(ActionEvent e) {//falta hacerlo con chaza
            if(opcion==1){
                Usuario u=modelo.buscarXUsuario(miUsuario.getNombreUsuario());
                if(view.getInTelNum().getText().isEmpty()){
                    view.getConfirmar().setText("Hay que rellenar el espacio.");
                }else{
                    modelo.buscarXUsuario(u.getNombreUsuario()).setTelefono(view.getInTelNum().getText());
                    view.getInTelNum().clear();
                    view.getConfirmar().setText("Datos actualizados");
                }
            }else{
                Chaza c=modelo.buscarChazaXUsuario(miUsuario.getNombreUsuario());
                if(view.getInTelNum().getText().isEmpty()){
                    view.getConfirmar().setText("Hay que rellenar el espacio.");
                }else{
                    modelo.buscarChazaXUsuario(c.getNombreUsuario()).setTelefono(view.getInTelNum().getText());
                    view.getInTelNum().clear();
                    view.getConfirmar().setText("Datos actualizados");
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
