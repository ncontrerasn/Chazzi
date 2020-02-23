/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.PrincipalVendedor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VCPrincipalVendedor {

    //modelo
    public Mapa modelo;

    //vista
    public PrincipalVendedor view;
    private Chaza miChaza;

    public VCPrincipalVendedor(Mapa modelo,String usuario,ArrayList<Point2D> puntos) throws FileNotFoundException {
        this.modelo = modelo;
        this.view = new PrincipalVendedor(puntos,modelo);
        this.miChaza= modelo.buscarChazaXUsuario(usuario);
        this.view.getUserText().setText(miChaza.getNombre()+" (Vendedor)");

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getB1().setOnAction(new OrderBttnHandler());
        this.view.getB2().setOnAction(new PostProdBttnHandler());
        this.view.getB3().setOnAction(new OptBttnHandler());
        this.view.getB4().setOnAction(new DeudaBttnHandler());
        this.view.getB5().setOnAction(new UsBttnHandler());
        this.view.getB6().setOnAction(new MyProductsBttnHandler());
        this.view.getB7().setOnAction(new EndSession());
        
    }

    public void show() {
        
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class EndSession implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCInicial init=new VCInicial(modelo);
            init.show();

        }

    }
    private class MyProductsBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCMisProductos init=new VCMisProductos(modelo, miChaza);
            init.show();

        }

    }
    private class OrderBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCListaFacturas init=new VCListaFacturas(modelo, miChaza,0,false);
            init.show();

        }

    }

  private class PostProdBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCPublicarProducto initial=new VCPublicarProducto(modelo,miChaza);
            initial.show();

        }

    }

    private class OptBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCOpciones initial = new VCOpciones(modelo,0,miChaza);
            initial.show();
        }

    }

   private class DeudaBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
           VCDeuda init=new VCDeuda(modelo, miChaza);
           init.show();
        }
    }

    private class UsBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCNosotros initial;
            initial = new VCNosotros(modelo,0,miChaza);
            try {
                modelo.guardarDatosChazas();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCPrincipalVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            initial.show();
        }

    }
}
