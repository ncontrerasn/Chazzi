/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.view.HacerCompra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import project.model.Chaza;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Producto;

/**
 *
 * @author Andryut Huertas
 */public class VCHacerCompra {

    //modelo
    public Mapa modelo;
    private ArrayList<Producto> misProductosFactura;
    //vista
    public HacerCompra view;
    private DetalleVenta factura;
    private Chaza miChaza;
    int totalEntero=0;

    public VCHacerCompra(Mapa modelo, DetalleVenta factura) {
        this.miChaza=factura.getChaza();
        this.modelo = modelo;
        this.view = new HacerCompra();
        this.misProductosFactura = new ArrayList<>();
        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBackBttn().setOnAction(new BackBttnHandler());
        this.view.getBuyBttn().setOnAction(new BuyBttnHandler());
        this.view.getRemoveBttn().setOnAction(new RemoveBttnHandler());
        this.factura = factura;
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() throws FileNotFoundException, ParseException {
        //modelo.cargarDatosFacturaChazas();
      
       
        for (int i = 0; i < factura.getProductos().size(); i++) {
            misProductosFactura.add(new Producto(factura.devolverProducto(i).getNombre(), factura.devolverProducto(i).getPrecioVenta(), factura.getCantidadesExactas(i)));
        }
        for(Producto miProducto:misProductosFactura){
            totalEntero+=miProducto.getCantidad()*miProducto.getPrecioVenta();
           
        }   
       totalEntero=(int) (totalEntero+totalEntero*0.08);
         view.getLabelTotal().setText(Integer.toString(totalEntero)+"COP");
         view.getLabelTotal().setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        view.getLabelTotal().textFillProperty().set(Color.WHITE);
        ObservableList<Producto> data = FXCollections.observableArrayList(misProductosFactura);
        view.getTableView().setItems(data);
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class RemoveBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Producto productToDelete = (Producto) view.getTableView().getSelectionModel().getSelectedItem();
            view.getTableView().getItems().remove(productToDelete);

            misProductosFactura.remove(productToDelete);

        }

    }

    private class BuyBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            DetalleVenta facturaFinal = new DetalleVenta(factura.getUsuario(), factura.getChaza());
            
            for (Producto miproducto : misProductosFactura) {
                facturaFinal.addProducto(miproducto, miproducto.getCantidad());
                 modelo.buscarChazaXUsuario(miChaza.getNombreUsuario()).getInventario().buscarProductoXNombre(miproducto.getNombre()).restarCantidad(miproducto.getCantidad());
            }
           facturaFinal.setFecha(new Date());
           facturaFinal.setTotalFactura(totalEntero);
           
           factura.getUsuario().addFactura(facturaFinal);
            
          // factura.getChaza().addFactura(facturaFinal);
                    
           //modelo.buscarChazaXUsuario(miChaza.getNombreUsuario()).addFactura(facturaFinal);
                     
                    
         
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Pedido con éxito, estará llegando pronto!");
           
            alert.showAndWait();
            try {
              
            modelo.guardarDatosFacturasUsuario();
            modelo.guardarDatosChazas();
                VCPrincipalComprador init=new VCPrincipalComprador(modelo, factura.getUsuario().getNombreUsuario(),modelo.getPuntosTotales());
               
                init.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCHacerCompra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VCHacerCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

    }

    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

        }

    }
}
