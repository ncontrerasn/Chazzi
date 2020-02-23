/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import project.controller.VCPedidos;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import project.controller.VCHacerCompra;
import project.controller.ViewController;
import project.controller.VCInicial;
import project.controller.VCListaFacturas;
import project.controller.VCListaProductos;
import project.controller.VCLoggeo;
import project.controller.VCMapa;
import project.controller.VCPublicarProducto;
import project.model.Chaza;
import project.model.DetalleVenta;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class Project extends Application {

    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, ParseException {
         
       
        //primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(new Pane(), 800, 700));
        //Se inicializa la aplicación
        Mapa modelo = new Mapa(primaryStage);
        //Se crea el primer controlador y se llama a su función mostrar
//        
//        Chaza c1=new Chaza("drogas", "123", "nicolas", "1234567", "9 am - 6 pm");
//        c1.getInventario().addProducto("mini porro", 5000, 20);
//        c1.getInventario().addProducto("maxi porro", 8000, 10);
//        c1.getInventario().addProducto("brownie", 3000, 10);
//        
//        Chaza c2=new Chaza("mierdas chinas", "456", "sergio", "5423768", "7 am - 6 pm");
//        c2.getInventario().addProducto("ddfd", 5000, 20);
//        c2.getInventario().addProducto("asd", 8000, 10);
//        c2.getInventario().addProducto("mzxcn", 3000, 10);
//        
//        modelo.addChaza(c1);
//        modelo.addChaza(c2);
//
//
///////////////////////////////////CREACION USUARIOS
//
////
//        Usuario u1=new Usuario("pepeu", "1234", "pepe castillo", "7654");
//        Usuario u2=new Usuario("Natalah", "3289", "Natalia Herna", "854322");
//        modelo.addUsuario(u1);
//        modelo.addUsuario(u2);
//        
//       
        
//         modelo.cargarDatosUsuarios();
          modelo.cargarDatosChazas();
          modelo.cargarDatosUsuarios();
   
          modelo.cargarDatosFacturasUsuarios();
       
          
//         modelo.cargarDatosFacturasUsuarios();
//         modelo.cargarDatosFacturaChazas();
//          VCMapa initial=new VCMapa(modelo,true);
         VCInicial initial = new VCInicial(modelo);
         
//          modelo.cargarDatosChazas();
//        modelo.cargarDatosFacturasUsuarios();

    initial.show();
        //primaryStage.show();
    }

}
