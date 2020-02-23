/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import project.view.ListaProductos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextInputDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.model.Chaza;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Producto;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class VCListaProductos {

    //modelo
    public Mapa modelo;

    //vista
    public ListaProductos view;
    private Producto miProducto;
    private Chaza chaza;
    private Usuario usuario;
    private ArrayList<Producto> productosaMandar;

    public VCListaProductos(Mapa modelo, Chaza chaza, Usuario usuario) {
        this.modelo = modelo;
        this.view = new ListaProductos();
        this.chaza = chaza;
        this.usuario = usuario;
        this.productosaMandar = new ArrayList<>();

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getBackBttn().setOnAction(new BackBttnHandler());
        this.view.getBuyBttn().setOnAction(new BuyBttnHandler());
        this.view.getAddBttn().setOnAction(new AddBttnHandler());
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show(int i) {
        
        try {
            modelo.cargarDatosChazas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<Producto> data = FXCollections.observableArrayList(chaza.getInventario().getListaProductos());
        view.getTableView().setItems(data);
        this.view.show(modelo.getPrimaryStage());
        ObservableList selectedCells = view.getTableView().getSelectionModel().getSelectedCells();
        
        selectedCells.addListener(new ListChangeListener() {
            
            @Override
            public void onChanged(ListChangeListener.Change c) {
                
                miProducto = new Producto(((Producto) view.getTableView().getSelectionModel().getSelectedItem()).getNombre(), ((Producto) view.getTableView().getSelectionModel().getSelectedItem()).getPrecioVenta(), 0);
                
            }
        });
    }

    //HacerClases EventHandlers
    private class AddBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("¿Cúantos quieres?");
            dialog.setTitle("Seleccionar Cantidad");
            Optional<String> result = dialog.showAndWait();
            int cantidad = Integer.parseInt(result.get());

            if (cantidad != 0) {               
                if(cantidad < (chaza.getInventario().buscarProductoXNombre(miProducto.getNombre()).getCantidad())){
                miProducto.setCantidad(cantidad);
                productosaMandar.add(miProducto);
                }else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Error, no hay productos suficientes");
           
            alert.showAndWait();
                    
                }
            }
        }

    }

    private class BuyBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            DetalleVenta facturaaMandar = new DetalleVenta(usuario, chaza);
            for (Producto miProducto : productosaMandar) {
                facturaaMandar.addProducto(miProducto, miProducto.getCantidad());
            }
            VCHacerCompra initial = new VCHacerCompra(modelo, facturaaMandar);
            try {
                initial.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                VCPrincipalComprador init=new VCPrincipalComprador(modelo, usuario.getNombreUsuario(), modelo.getPuntosTotales());
                init.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VCListaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
