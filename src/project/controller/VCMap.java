/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.view.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCMap {

    //modelo
    public Mapa modelo;
    //vista
    public Map view;
    public Usuario miUsuario;
    private final int opcion;

    public VCMap(Mapa modelo, int opcion,Usuario usuario) throws FileNotFoundException {
        this.modelo = modelo;
        this.view = new Map();
        this.opcion=opcion;
        this.miUsuario=usuario;

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
            if(opcion==1){
               /* VCPrincipalComprador initial;
                try {
                    initial = new VCPrincipalComprador(modelo,miUsuario.getNombreUsuario());
                    initial.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }else{
                VCPrincipalVendedor initial;
                    /*try {
                    //initial = new VCPrincipalVendedor(modelo,miUsuario.getNombreUsuario());
                   initial.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        }
    }
}
