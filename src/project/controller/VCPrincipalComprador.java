/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.awt.event.ActionListener;
import project.view.PrincipalComprador;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.WindowEvent;
import javax.swing.Timer;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCPrincipalComprador implements ActionListener {

    //modelo
    public Mapa modelo;

    //vista
    public PrincipalComprador view;
    private Usuario miUsuario;
    private Timer timer;
    private int i;

    public VCPrincipalComprador(Mapa modelo, String usuario, ArrayList<Point2D> puntos) throws FileNotFoundException {
        
        this.i = 0;
        this.timer = new Timer(1000, this);
        this.timer.start();
        this.modelo = modelo;
        this.view = new PrincipalComprador(puntos, this.modelo, usuario);

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getB2().setOnAction(new OptBttnHandler());
        this.view.getB3().setOnAction(new MapBttnHandler());
        this.view.getB4().setOnAction(new UsBttnHandler());
        this.view.getB5().setOnAction(new ViewOrdersBttnHandler());
        this.view.getB1().setOnAction(new EndSession());
        this.miUsuario = modelo.buscarXUsuario(usuario);
        this.view.getTextUser().setText(miUsuario.getNombre() + " (Comprador)");

    }

    public void show() throws FileNotFoundException, ParseException {
        
        try {
            modelo.cargarDatosChazas();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        this.view.show(modelo.getPrimaryStage());

    }

    //HacerClases EventHandlers
    private class EndSession implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            timer.stop();
            VCInicial init = new VCInicial(modelo);
            init.show();

        }

    }

    private class ViewOrdersBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {//mandar primero la lista productos y luego compra
            timer.stop();
            VCListaFacturas init = new VCListaFacturas(modelo, miUsuario, 1,true);
            init.show();
        }

    }

    private class OptBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            timer.stop();
            VCOpciones initial = new VCOpciones(modelo, 1, miUsuario);
            initial.show();
        }

    }

    private class MapBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCMap initial;
            try {
                timer.stop();
                initial = new VCMap(modelo, 1, miUsuario);
                initial.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class UsBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            timer.stop();
            VCNosotros initial = new VCNosotros(modelo, 1, miUsuario);
            initial.show();
        }

    }

    private class OnCloseHandler implements EventHandler<WindowEvent> {

        @Override
        public void handle(WindowEvent event) {
            timer.stop();
        }

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        this.i++;
        if (i % 7 == 0) {
            try {
                this.modelo.cargarDatosChazas();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VCPrincipalComprador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (i % 15 == 0) {
            this.view.getM().getView().getContexto().clearRect(0, 0, this.view.getM().getView().getContexto().getCanvas().getWidth(), this.view.getM().getView().getContexto().getCanvas().getHeight());
            for (Point2D p : this.modelo.getPuntosTotales()) {
                this.view.getM().getView().setPuntos(modelo.getPuntosTotales());
                this.view.getM().getView().dibujarChaza(p.getX(), p.getY());
            }
        }
    }
}
