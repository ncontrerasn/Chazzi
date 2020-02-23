/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class MapView {
     

    //Es el elemento que retorna
    private GridPane mapViewGrid;
    private Button botonEditar ;
    private Button create;
        
        
    private Pane mapView;
    private GraphicsContext contexto;
    //Group es el que tiene mouselistener
    private Group root;
    //Imagen chaza
    private Image img;
    private Point2D imgPosition;
    //Imagen Fondo
    private Image mapa;
    //True es que permite añadir elementos
    private boolean edit;
    private ArrayList<Point2D> puntos;
    //Pasamos el Stage para modificarlo cuando se seleccione una chaza
    private Stage primaryStage;

    public MapView(Stage primaryStage, ArrayList<Point2D> puntos, double mapPercentage, boolean edit) throws FileNotFoundException {
        String style = "-fx-background-image: url('file:default.png')";
        this.edit = edit;
        this.botonEditar= new Button("Editar");
        this.create=new Button("Crear");
        this.mapViewGrid = new GridPane();
        this.puntos = puntos;
        this.primaryStage = primaryStage;
        this.mapa = new Image(new FileInputStream("mapaUN.png"));
        ImageView background = new ImageView(mapa);
        background.setFitWidth(this.mapa.getWidth() * mapPercentage);
        background.setFitHeight(this.mapa.getHeight() * mapPercentage);
        this.img = new Image(new FileInputStream("cyan.png"));
        this.imgPosition = new Point2D(this.img.getWidth(), this.img.getHeight());
        Canvas canvas = new Canvas();
        this.contexto = canvas.getGraphicsContext2D();
        canvas.setHeight(this.mapa.getHeight() * mapPercentage);
        canvas.setWidth(this.mapa.getWidth() * mapPercentage);

        this.root = new Group();
        this.root.getChildren().add(canvas);
       

        for (Point2D p : this.puntos) {
            dibujarChaza(p.getX(), p.getY());
        }

        StackPane stack = new StackPane();
        stack.getChildren().addAll(background, root);
        this.mapView = new Pane(stack);
        mapViewGrid.setAlignment(Pos.CENTER);
        mapViewGrid.add(getMapView(), 0, 0);
        mapViewGrid.add(create, 5, 0);
        
    }

    public boolean crearChaza(double x, double y){
        boolean permitido = true;
        for (Point2D p : puntos) {
            if (Math.abs(p.getX() - x) < img.getWidth() && Math.abs(p.getY() - y) < img.getHeight()) {
                permitido = false;
            }
        }
        if(permitido){
            this.puntos.add(new Point2D(x, y));
            dibujarChaza(x, y);
        }
        return permitido;
    }
    
    public void dibujarChaza(double x, double y) {
        this.contexto.drawImage(this.img, x - this.imgPosition.getX() / 2, y - this.imgPosition.getY() / 2);
    }
    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.mapViewGrid);
        primaryStage.show();
    }

    //Estos manejadores pueden ser re configurados en una clase ViewController
   

    public Pane getMapView() {
        return mapView;
    }

    public void setMapView(Pane mapView) {
        this.mapView = mapView;
    }

    public GraphicsContext getContexto() {
        return contexto;
    }

    public void setContexto(GraphicsContext contexto) {
        this.contexto = contexto;
    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Point2D getImgPosition() {
        return imgPosition;
    }

    public void setImgPosition(Point2D imgPosition) {
        this.imgPosition = imgPosition;
    }

    public Image getMapa() {
        return mapa;
    }

    public void setMapa(Image mapa) {
        this.mapa = mapa;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    

    public void setPuntos(ArrayList<Point2D> puntos) {
        this.puntos = puntos;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public Button getEditBttn(){
        return this.botonEditar;
    }
    public Button getCreateBttn(){
        return this.create;
    }

    public ArrayList<Point2D> getPuntos() {
        return puntos;
    }

}
