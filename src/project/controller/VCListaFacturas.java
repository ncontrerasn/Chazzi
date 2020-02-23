/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javax.swing.Timer;
import project.model.Chaza;
import project.model.DetalleVenta;

import project.model.Mapa;
import project.model.Producto;
import project.model.Usuario;
import project.view.ListaFacturas;

/**
 *
 * @author Andryut Huertas
 */
public class VCListaFacturas  {

    //modelo
    public Mapa modelo;
    
    private int i;

    //vista
    public ListaFacturas view;
    private Usuario usuario;
    private DetalleVenta miFactura;
    private int opcion;
    private boolean permisoParaValidar;
    public VCListaFacturas(Mapa modelo,Usuario usuario,int opcion,boolean permiso) {
          
        this.i = 0;
       
        this.opcion=opcion;
        this.modelo = modelo;
        this.view = new ListaFacturas();
        this.usuario=usuario;
        //Registrar EventHandlers a cada objeto de la vista
        this.view.getAbrirBttn().setOnAction(new OpenBttnHandler());
        this.view.getRegresarBttn().setOnAction(new BackBttnHandler());
        this.view.getValidarBttn().setOnAction(new ValidateBttnHandler());
        this.view.getValidarBttn().setVisible(permiso);
        this.view.getRefreshBttn().setOnAction(new RefreshBttnHandler());
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() {
        
        try {
            //modelo.cargarDatosFacturaChazas();
             modelo.cargarDatosFacturasUsuarios();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       ObservableList<DetalleVenta> data = FXCollections.observableArrayList(usuario.getFacturas());
        view.getTabla().setItems(data);
        this.view.show(modelo.getPrimaryStage());
        ObservableList selectedCells = view.getTabla().getSelectionModel().getSelectedCells();
         selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
               // miFactura=new (((Producto) view.getTableView().getSelectionModel().getSelectedItem()).getNombre(),((Producto) view.getTableView().getSelectionModel().getSelectedItem()).getPrecioVenta(),0);
              miFactura=(DetalleVenta) view.getTabla().getSelectionModel().getSelectedItem();
               
            }
        });
    }
    
    

    //HacerClases EventHandlers
    private class RefreshBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            
                VCListaFacturas init=new VCListaFacturas(modelo, usuario,opcion,true);
                
                init.show();
            
            

        }

    }
    private class ValidateBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                if(miFactura!=null) miFactura.setEstado("Entregado");{
                VCListaFacturas init=new VCListaFacturas(modelo, usuario,opcion,true);
                modelo.guardarDatosFacturasUsuario();
                init.show();
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(usuario instanceof Chaza){
                
                     VCPrincipalVendedor initial;
                     ArrayList<Point2D> miPunto =new ArrayList<>();
                     miPunto.add(new Point2D(modelo.buscarChazaXUsuario(usuario.getNombreUsuario()).getPosX(), modelo.buscarChazaXUsuario(usuario.getNombreUsuario()).getPosY()));
                try {
                    initial = new VCPrincipalVendedor(modelo,usuario.getNombreUsuario(),miPunto);
                    initial.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
                
            }else{
                
                try {
                    VCPrincipalComprador init=new VCPrincipalComprador(modelo, usuario.getNombreUsuario(),modelo.getPuntosTotales());
                    try {
                        init.show();
                    } catch (ParseException ex) {
                        Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VCListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private class OpenBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCFactura init=new VCFactura(modelo,miFactura,opcion);
            init.show();

        }

    }

}
