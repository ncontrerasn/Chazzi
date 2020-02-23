/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.view.View6;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Chaza;
import project.model.Mapa;
import project.model.Usuario;
import project.view.View6_2;

/**
 *
 * @author Andryut Huertas
 */
public class ViewController6_2 {//registro comprador

    //modelo
    public Mapa modelo;

    //vista
    public View6_2 view;

    public ViewController6_2(Mapa modelo) {
        this.modelo = modelo;
        this.view = new View6_2();

        //Registrar EventHandlers a cada objeto de la vista
        this.view.getB1().setOnAction(new RegBttnHandler());

    }

    public void show() {
        this.view.show(modelo.getPrimaryStage());
    }

    //HacerClases EventHandlers
    private class RegBttnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            VCMapa initial;
            
            if(view.getInUser().getText().isEmpty() || view.getInPass().getText().isEmpty()|| 
                view.getInName().getText().isEmpty()||view.getInPhone().getText().isEmpty()||
                view.getInHorario().getText().isEmpty()){
                view.getConfirmar().setText("Hay que rellenar todos los espacios.");
            }else{
                

                try {
                    initial=new VCMapa(modelo, true,view.getInUser().getText(), view.getInPass().getText(), view.getInName().getText(),view.getInPhone().getText(), view.getInHorario().getText(),modelo.getPuntosTotales());
                    

                    initial.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ViewController6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
    
   
    }
     public View6_2 getView(){
        return this.view;
        
    }
}
