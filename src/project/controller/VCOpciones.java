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
import project.view.Opciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import project.model.Chaza;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCOpciones {

    //modelo
    public Mapa modelo;

    //vista
    public Opciones view;
    public Usuario miUsuario;
    private final int opcion;//podria ser cambiado por instance of usuario o chaza

    public VCOpciones(Mapa modelo,int opcion,Usuario usuario) {
        this.modelo = modelo;
        this.view = new Opciones();
        this.opcion=opcion;
        this.miUsuario=usuario;
        //Registrar EventHandlers a cada objeto de la vista
        this.view.getB1().setOnAction(new DatModBttnHandler());
        this.view.getB2().setOnAction(new HistBttnHandler());
        this.view.getB3().setOnAction(new BackBttnHandler());
        this.view.getB4().setOnAction(new QuitBttnHandler());
        this.view.getB5().setOnAction(new PassBttnHandler());
        this.view.getConacto().setOnAction(new ContactodBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class DatModBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCCambiarDatos initial=new VCCambiarDatos(modelo,opcion,miUsuario);//y como vendedor?
            initial.show();
        }

    }
    
    private class ContactodBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCContacto initial=new VCContacto(modelo,miUsuario,opcion);
            initial.show();
        }

    }

    private class HistBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            /*VCHistorial initial=new VCHistorial(modelo,opcion,miUsuario);
            initial.show();*/
        }

    }

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
                        Logger.getLogger(VCOpciones.class.getName()).log(Level.SEVERE, null, ex);
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

    private class QuitBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            //guardar datos antes OJOJO
            modelo.getPrimaryStage().close();
        }

    }

    private class PassBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCCambiarPass initial=new VCCambiarPass(modelo,miUsuario,opcion);
            initial.show();
        }

    }
}
