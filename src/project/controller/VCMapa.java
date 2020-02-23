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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.model.Chaza;
import project.model.Mapa;
import project.view.MapView;

/**
 *
 * @author Sergio
 */
public class VCMapa {

    public Mapa modelo;
    public MapView view;
    private boolean yaDibujo;
    private String usuario, pass, nombre, phone, horario;
    private double posX;
    private double posY;
    private String usuarioaComprar;

    public VCMapa(Mapa modelo, boolean valor, String usuario, String pass, String nombre, String phone, String horario, ArrayList<Point2D> puntos) throws FileNotFoundException {
        this.yaDibujo = false;
        this.modelo = modelo;
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.phone = phone;
        this.horario = horario;

        this.view = new MapView(modelo.getPrimaryStage(), puntos, 0.8, valor);
        view.getRoot().setOnMouseClicked(new MouseClickedHandler());
        view.getEditBttn().setOnAction(new EditBttnHandler());
        view.getCreateBttn().setOnAction(new CreateBttnHandler());
        this.view.getCreateBttn().setVisible(false);

    }

    public VCMapa(Mapa modelo, boolean valor, ArrayList<Point2D> puntos, String usuarioaComprar) throws FileNotFoundException {
        this.usuarioaComprar = usuarioaComprar;
        this.modelo = modelo;
        this.view = new MapView(modelo.getPrimaryStage(), puntos, 0.8, valor);
        view.getRoot().setOnMouseClicked(new MouseClickedHandler());
    }

    public void show() {
        
        this.view.show(modelo.getPrimaryStage());
    }

    private class CreateBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Chaza c = new Chaza(usuario, pass, nombre, phone, horario, posX, posY);

            modelo.addChaza(c);

            try {
                modelo.guardarDatosChazas();
                ArrayList<Point2D> miPunto = new ArrayList<>();
                miPunto.add(new Point2D(posX, posY));
                VCPrincipalVendedor init = new VCPrincipalVendedor(modelo, usuario, miPunto);
                modelo.guardarDatosChazas();
                init.show();
                //To change body of generated methods, choose Tools | Templates.
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VCMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class EditBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            view.setEdit((view.getEdit() ? false : true));
            //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class MouseClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent e) {
            if (view.getEdit()) {
                if (e.isShiftDown()) {
                    if (Math.abs(posX - e.getX()) < view.getImg().getWidth() / 2 && Math.abs(posY - e.getY()) < view.getImg().getHeight() / 2) {
                        int i = 0;
                        int s = -1;
                        for (Point2D p : view.getPuntos()) {
                            i++;
                            if (p.getX() == posX && p.getY() == posY) {
                                view.getContexto().clearRect(p.getX() - view.getImg().getWidth() / 2, p.getY() - view.getImg().getHeight() / 2, view.getImg().getWidth(), view.getImg().getHeight());

                                s = i - 1;
                            }
                        }
                        if (s != -1) {
                            view.getPuntos().remove(s);
                            yaDibujo = false;
                            view.getCreateBttn().setVisible(false);
                        }
                    }
//                    

                } else if (!yaDibujo) {
                    posX = e.getX();
                    posY = e.getY();
                    if (view.crearChaza(posX, posY)) {
                        yaDibujo = true;
                        view.getCreateBttn().setVisible(yaDibujo);
                    }
                }
            }
            if (!view.getEdit()) {
                //Aquí puede cambiar el comportamiento de clickear cuando no está "seleccionado" editar
                //podemos hacer algo directamente con el stage, si lo conocemos, es decir:
                //esto debería ser redefinido fuera para activar cuando seleccionemos una chaza
                Point2D m = new Point2D(e.getX(), e.getY());
               
                for (Point2D p : view.getPuntos()) {
                    if (m.getX() < p.getX() + view.getImg().getWidth() && m.getX() > p.getX() - view.getImg().getWidth()) {
                        if (m.getY() < p.getY() + view.getImg().getHeight() && m.getY() > p.getY() - view.getImg().getHeight()) {
                            VCListaProductos init = new VCListaProductos(modelo, modelo.buscarChazaXCoordenadas(p.getX(), p.getY()), modelo.buscarXUsuario(usuarioaComprar));
                            init.show(0);
                            
//view.getPrimaryStage().setScene(new Scene(new Pane(new Label("( " + e.getX() + ", " + e.getY() + ")")), 500, 500));
                        }
                    }
                }
            }
        }

    }

    public MapView getView() {
        return view;
    }

    public void setView(MapView view) {
        this.view = view;
    }
}
