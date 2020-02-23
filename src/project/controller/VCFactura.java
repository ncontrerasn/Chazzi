/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Producto;
import project.view.Factura;

/**
 *
 * @author Andryut Huertas
 */
public class VCFactura {

    //modelo
    public Mapa modelo;

    //vista
    public Factura view;
    private DetalleVenta factura;
    private int opcion;

    public VCFactura(Mapa modelo,DetalleVenta factura,int opcion) {
        this.opcion=opcion;
        this.modelo = modelo;
        this.view = new Factura();
        this.factura=factura;

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getRegresarBttn().setOnAction(new BackBttnHandler());
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() {
        ObservableList<Producto> data = FXCollections.observableArrayList(factura.getProductos());
        view.getTabla().setItems(data);
        this.view.show(modelo.getPrimaryStage());
        ObservableList selectedCells = view.getTabla().getSelectionModel().getSelectedCells();
         selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
              
               
            }
        });
         view.getChaza().setText(factura.getChaza().getNombreUsuario());
         view.getUsuario().setText(factura.getUsuario().getNombre());
         view.getFecha().setText(factura.getFecha().toString());
         view.getTotal().setText(Integer.toString(factura.getTotalFactura()));
         
    }

    //HacerClases EventHandlers
    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
              if(opcion==1){
                VCListaFacturas a=new VCListaFacturas(modelo,factura.getUsuario(), 1,true);
                a.show();
            }else{
                VCListaFacturas a=new VCListaFacturas(modelo,factura.getChaza(), 0,false);
                a.show();
            }

        }

    }
}
