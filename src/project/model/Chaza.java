
package project.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Chaza extends Usuario{
    private String horario;
    private Inventario inventario;
    private Caja caja;
    private double posX;
     private double posY;
    
   

    public Chaza(String nombreUsuario,String clave, String nombre, String telefono, String horario, double posX, double posY) {
        super(nombreUsuario, clave, nombre, telefono);
        this.posX=posX;
        this.posY=posY;
        this.horario = horario;
        this.inventario = new Inventario();
        this.caja = new Caja();
      
    }

    public String getHorario() {
        return horario;
        
        
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    


 
    @Override
    public String toString() {
        return "\n\t\tChaza "+ super.getNombreUsuario()+ "\nTelefono: " + super.getTelefono()  + ", horario: " + horario;
    }
    
   
    
    public int totalVentasPorMenor(){
        int total=0;
        for (int i = 0; i < this.facturas.size(); i++) {
            //total+=this.historialVentasPorMenor.get(i).getValor();
        }
        return total;
    }
    public Producto buscarProductoXNombre(String nomProducto){
       return this.inventario.buscarProductoXNombre(nomProducto);
    }
    
    
    
  
}
