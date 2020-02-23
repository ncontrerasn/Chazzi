
package project.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nicolas
 */
public class DetalleVenta {
    private ArrayList<Producto>productosFactura;
    private ArrayList<Integer> cantidades;
    private Date fecha;
    private Usuario usuario;
    private Chaza chaza;
    private int precioFinal;
    private String estado;
    private int totalFactura;

    public DetalleVenta( Usuario usuario,Chaza chaza) {
        this.productosFactura = new ArrayList<>();
        this.cantidades =new ArrayList<>() ;
       // this.fecha = new Date();
        this.usuario = usuario;
        this.chaza=chaza;
        estado="Sin entregar";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

  

   

    public Usuario getUsuario() {
        return usuario;
    }
     public Chaza getChaza() {
        return chaza;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


   public void addProducto(Producto producto, int cantidad){
   this.productosFactura.add(producto);
   this.cantidades.add(cantidad);
   }
   public ArrayList getProductos(){
       return this.productosFactura;
   }
   public Producto devolverProducto(int j){
       return productosFactura.get(j);
   }
   public ArrayList getCantidades(){
       return this.cantidades;
   }
   public int getCantidadesExactas(int i){
       return cantidades.get(i);
   }
   

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }
   
   
   
   }
    

