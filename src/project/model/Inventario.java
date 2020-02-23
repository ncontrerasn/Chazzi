
package project.model;

import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Inventario {
    private ArrayList<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }
    
    public boolean addProducto(String nombre, int precioVenta, int cantidad){
        Producto p=new Producto(nombre, precioVenta, cantidad);
        return this.listaProductos.add(p);
    }
    
    public Producto getProductoN(int x){
        return listaProductos.get(x);
    }
    
    public Producto deleteProducto(int posicion){
        return this.listaProductos.remove(posicion);
    }

    @Override
    public String toString() {
        String mostrar="";
        for (int i = 0; i < this.listaProductos.size(); i++) {
            mostrar+="Producto "+(i+1)+": "+ listaProductos.get(i).getNombre()+", cantidad: "
                    +listaProductos.get(i).getCantidad()+", precio de venta por menor: $"
                    +listaProductos.get(i).getPrecioVenta()+", precio de venta por mayor: $";
                   // +listaProductos.get(i).getPrecioVentaPorMayor()+", precio de compra: $"
                    //+listaProductos.get(i).getPrecioCompra()+"\n"; 
        }
        return mostrar;
    }
    
    public String toString2() {
        String mostrar="";
        for (int i = 0; i < this.listaProductos.size(); i++) {
            mostrar+="Producto "+(i+1)+": "+ listaProductos.get(i).getNombre()+", unidades disponibles: "+listaProductos.get(i).getCantidad()+"\n";
        }
        return mostrar;
    }
    
    public String toString3() {
        String mostrar="";
        for (int i = 0; i < this.listaProductos.size(); i++) {
            mostrar+="Producto "+(i+1)+": "+ listaProductos.get(i).getNombre()+", precio: $"+listaProductos.get(i).getPrecioVenta()+"\n";
        }
        return mostrar;
    }
    
    public int getTamanio(){
        int tamanio=this.listaProductos.size();
        return tamanio;
    }
    public ArrayList getListaProductos(){
        return this.listaProductos;
    }
    public Producto buscarProductoXNombre(String nomProducto){
      
        for(Producto miProducto: listaProductos){
            
            if(miProducto.getNombre().equals(nomProducto)){
                
                return miProducto;
                
            
            }
         
            
            
        }
        
     return null;   
    }
    
}
