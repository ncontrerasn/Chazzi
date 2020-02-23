
package project.model;

/**
 *
 * @author Nicolas
 */
public class Producto {
    private String nombre;
    private int precioVenta;
    private int cantidad;

    public Producto(String nombre, int precioVenta, int cantidad) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setCantidad(int x) {
        this.cantidad = x;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre;
    }
    public void restarCantidad(int i){
        
        this.cantidad-=i;
        
    }

}
