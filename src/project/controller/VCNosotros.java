/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.view.Nosotros;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCNosotros {

    //modelo
    public Mapa modelo;

    //vista
    public Nosotros view;
    public Usuario miUsuario;
    private final int opcion;

    public VCNosotros(Mapa modelo, int opcion,Usuario usuario) {
        this.modelo = modelo;
        this.view = new Nosotros();
        this.opcion=opcion;
        this.miUsuario=usuario;

        //Registrar EventHandlers a cada objeto de la vista
        view.getBackBttn().setOnAction(new BackBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(opcion==1){
                VCPrincipalComprador initial;
                try {
                    initial = new VCPrincipalComprador(modelo,miUsuario.getNombreUsuario(),modelo.getPuntosTotales());
                    try {
                        initial.show();
                    } catch (ParseException ex) {
                        Logger.getLogger(VCNosotros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                VCPrincipalVendedor initial;
                    try {
                         ArrayList<Point2D> miPunto =new ArrayList<>();
                miPunto.add(new Point2D(modelo.buscarChazaXUsuario(miUsuario.getNombreUsuario()).getPosX(), modelo.buscarChazaXUsuario(miUsuario.getNombreUsuario()).getPosY()));
                    initial = new VCPrincipalVendedor(modelo,miUsuario.getNombreUsuario(),miPunto);
                    initial.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
