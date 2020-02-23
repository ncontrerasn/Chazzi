package project.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Usuario {//Chaza heredaria de usuario

    protected String nombreUsuario;
    protected String clave;
    protected String nombre;
    protected String telefono;
    protected String ubicacion;
    protected ArrayList<DetalleVenta> facturas;

    public Usuario(String nombreUsuario, String clave, String nombre, String telefono) {
        this.nombreUsuario = nombreUsuario;
        this.facturas = new ArrayList<>();
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void addFactura(DetalleVenta factura) {
        facturas.add(factura);

    }

    public ArrayList<DetalleVenta> getFacturas() {

        return this.facturas;
    }
    public void setFacturas(ArrayList<DetalleVenta> facturas){
        this.facturas=facturas;
    }
            
            
    

    public DetalleVenta devolverFactura(int i) {
        return facturas.get(i);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", telefono: " + telefono + ", ubicacion: " + ubicacion + ", nombre de usuario";
    }

    

}
