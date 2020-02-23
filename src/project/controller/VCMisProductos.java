/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.view.HacerCompra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import project.model.Chaza;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Producto;
import project.view.MisProductos;

/**
 *
 * @author Andryut Huertas
 */public class VCMisProductos {

    //modelo
    public Mapa modelo;
   
    //vista
    public MisProductos view;
    private DetalleVenta factura;
    
    private Chaza chaza;

    public VCMisProductos(Mapa modelo, Chaza chaza) {
        this.modelo = modelo;
        this.chaza=chaza;
        this.view = new MisProductos();
     
        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBackBttn().setOnAction(new BackBttnHandler());
       
        this.view.getRemoveBttn().setOnAction(new RemoveBttnHandler());
        this.factura = factura;
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() {
        
        
       
        
        ObservableList<Producto> data = FXCollections.observableArrayList(chaza.getInventario().getListaProductos());
        view.getTableView().setItems(data);
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class RemoveBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Producto productToDelete = (Producto) view.getTableView().getSelectionModel().getSelectedItem();
            view.getTableView().getItems().remove(productToDelete);

            chaza.getInventario().getListaProductos().remove(productToDelete);

        }

    }

    private class BuyBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            
           
        }

    }

    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            ArrayList<Point2D> miPunto=new ArrayList();
            miPunto.add(new Point2D(chaza.getPosX(), chaza.getPosY()));
            try {
                VCPrincipalVendedor init=new VCPrincipalVendedor(modelo, chaza.getNombreUsuario(), miPunto);
                init.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCMisProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
