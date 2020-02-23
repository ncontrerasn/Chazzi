package project.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import project.model.Chaza;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Producto;
import project.view.Deuda;

import project.view.Factura;

/**
 *
 * @author Andryut Huertas
 */
public class VCDeuda {

    //modelo
    public Mapa modelo;

    //vista
    public Deuda view;
   
    private int opcion;
    private int total;
    private Chaza miChaza;

    public VCDeuda(Mapa modelo,Chaza chaza) {
        this.miChaza=chaza;
       
        this.modelo = modelo;
        this.view = new Deuda();
        

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getRegresarBttn().setOnAction(new BackBttnHandler());
        this.view.pagarBttn().setOnAction(new PayBttnHandler());
        //view.getControl().setOnAction(new ClaseControladora());
    }

    public void show() {
        for (int i = 0; i < miChaza.getFacturas().size(); i++) {
            total+=(miChaza.devolverFactura(i).getTotalFactura())*0.8;
        }
        this.view.getTotal().setText(Integer.toString(total));
        this.view.show(modelo.getPrimaryStage());
       
         
    }

    //HacerClases EventHandlers
     private class PayBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            view.getTotal().setText("0");
              

        }

    }
    private class BackBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            ArrayList<Point2D> miPunto=new ArrayList();
            miPunto.add(new Point2D(miChaza.getPosX(), miChaza.getPosY()));
            VCPrincipalVendedor init;
            try {
                init = new VCPrincipalVendedor(modelo, miChaza.getNombreUsuario(),miPunto);
                init.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCDeuda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              

        }

    }
}
