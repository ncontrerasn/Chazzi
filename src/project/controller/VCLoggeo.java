/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.Loggeo;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import project.model.Mapa;

/**
 *
 * @author Andryut Huertas
 */
public class VCLoggeo {

    //modelo
    public Mapa modelo;

    //vista
    public Loggeo view;

    public VCLoggeo(Mapa modelo) throws FileNotFoundException {
        this.modelo = modelo;
        this.view = new Loggeo();
        view.getEnter().setOnAction(new EnterBttnHandler());
        

    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class EnterBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
           
            String usuario, clave;
            usuario=view.getUserTF().getText();
            clave=view.getPasswordTF().getText();

            if(modelo.comprobarInicioSesion(usuario, clave).equals("Comprador")){
                try {
                    VCPrincipalComprador initial2 = new VCPrincipalComprador(modelo,usuario,modelo.getPuntosTotales());
                    try {
                        initial2.show();
                    } catch (ParseException ex) {
                        Logger.getLogger(VCLoggeo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCLoggeo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(modelo.comprobarInicioSesion(usuario, clave).equals("Vendedor")){
                try {
                     ArrayList<Point2D> miPunto =new ArrayList<>();
                miPunto.add(new Point2D(modelo.buscarChazaXUsuario(usuario).getPosX(), modelo.buscarChazaXUsuario(usuario).getPosY()));
                    VCPrincipalVendedor initial2 = new VCPrincipalVendedor(modelo,usuario,miPunto);
                    initial2.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCLoggeo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                view.getUserTF().clear();
                view.getPasswordTF().clear();
                view.getRevision().setText("Datos errados, por favor vuelvalos a ingresar"); 
            }
        }

    }
}
