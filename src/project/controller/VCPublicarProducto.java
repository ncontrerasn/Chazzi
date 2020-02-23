/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.view.PublicarProducto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import project.model.Chaza;
import project.model.Mapa;
import project.model.Producto;

/**
 *
 * @author Andryut Huertas
 */
public class VCPublicarProducto {

    //modelo
    public Mapa modelo;

    //vista
    public PublicarProducto view;
    private Chaza chaza;

    public VCPublicarProducto(Mapa modelo,Chaza chaza) {
        this.modelo = modelo;
        this.view = new PublicarProducto();
        this.chaza=chaza;

        //Registrar EventHandlers a cada objeto de la vista
        view.getPostProd().setOnAction(new PostBttnHandler());
        view.getCancel().setOnAction(new CancelBttnHandler());
    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class PostBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(view.getCantidad().getText().isEmpty() || view.getProdName().getText().isEmpty()||
                    view.getPrecioVenta().getText().isEmpty()){
                view.getConfirmar().setText("Hay que rellenar todos los espacios."); 
            }else{
           
                view.getConfirmar().setText("Producto agregado al inventario.");
                //aqui se debe agregar al inventario el nuevo producto
              
               
                chaza.getInventario().addProducto(view.getProdName().getText(), 
                        
                        Integer.parseInt(view.getPrecioVenta().getText()) ,
                        Integer.parseInt(view.getCantidad().getText()));
                view.getCantidad().clear();
                view.getProdName().clear();
                view.getPrecioVenta().clear();
                try {
                    modelo.guardarDatosChazas();
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCPublicarProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class CancelBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCPrincipalVendedor initial;
            try {
                 ArrayList<Point2D> miPunto =new ArrayList<>();
                miPunto.add(new Point2D(chaza.getPosX(),chaza.getPosY()));
                initial = new VCPrincipalVendedor(modelo, chaza.getNombreUsuario(),miPunto);
                initial.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCPublicarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }

    }
}
