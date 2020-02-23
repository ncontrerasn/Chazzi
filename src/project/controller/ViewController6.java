package project.controller;

import project.view.View6;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.model.Mapa;
import project.model.Usuario;

/**
 *
 * @author Andryut Huertas
 */
public class ViewController6 {

    //modelo
    public Mapa modelo;

    //vista
    public View6 view;

    public ViewController6(Mapa modelo) {
        this.modelo = modelo;
        this.view = new View6();

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
            
            if(view.getInUser().getText().isEmpty() || view.getInPass().getText().isEmpty()|| 
                    view.getInName().getText().isEmpty()||view.getInPhone().getText().isEmpty()){
                    view.getConfirmar().setText("Hay que rellenar todos los espacios.");
            }else{
                Usuario u=new Usuario(view.getInUser().getText(), view.getInPass().getText(), view.getInName().getText(), 
                    view.getInPhone().getText());

                modelo.addUsuario(u);

                try {
                    VCPrincipalComprador initial = new VCPrincipalComprador(modelo,u.getNombreUsuario(),modelo.getPuntosTotales());
                    modelo.guardarDatosUsuarios();
                    try {
                        initial.show();
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewController6.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ViewController6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
