/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javafx.geometry.Point2D;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class Mapa {

    private ArrayList<Chaza> chazas;
    private ArrayList<Usuario> usuarios;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Stage primaryStage;
    private ArrayList<Point2D> puntosTotales;
  //  private FileInputStream fi=new FileInputStream(file)

    public Mapa(Stage primaryStage) {
        this.puntosTotales = new ArrayList<>();
        this.primaryStage = primaryStage;
        this.chazas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public boolean addChaza(Chaza c) {
        return this.chazas.add(c);
    }

    public boolean addUsuario(Usuario u) {
        return this.usuarios.add(u);
    }

    public boolean deleteChaza(Chaza c) {
        return this.chazas.remove(c);
    }

    public void guardarDatosUsuarios() throws FileNotFoundException {
        PrintStream outPut = new PrintStream(new File("datosUsuarios"));
        int contador = 1;
        for (Usuario usuario : usuarios) {
            outPut.print(usuario.getNombreUsuario() + ",");
            outPut.print(usuario.getClave() + ",");
            outPut.print(usuario.getNombre() + ",");
            outPut.print(usuario.getTelefono());

            if (contador != usuarios.size()) {

                outPut.print(",");
                //outPut.print("\n");
            }

            contador++;

        }
        this.guardarDatosFacturasUsuario();
outPut.close();
    }

    public void guardarDatosFacturasUsuario() throws FileNotFoundException {
        PrintStream outPut = new PrintStream(new File("DatosFacturaUsuarios"));
        int contador = 1;

        for (Usuario usuario : usuarios) {

            if (usuario.getFacturas().size() != 0) {
                outPut.print(usuario.getFacturas().size());
                outPut.print(",");

                for (int i = 0; i < usuario.getFacturas().size(); i++) {

                    //System.out.println(usuario.devolverFactura(i).getChaza().getNombreUsuario());
                     
                    outPut.print(usuario.devolverFactura(i).getChaza().getNombreUsuario() + ",");
                    outPut.print(sdf.format(usuario.devolverFactura(i).getFecha()) + ",");
                    outPut.print(usuario.devolverFactura(i).getTotalFactura() + ",");
                    outPut.print(usuario.devolverFactura(i).getEstado() + ",");
                    
                    outPut.print(usuario.devolverFactura(i).getProductos().size() + ",");

                    for (int j = 0; j < usuario.devolverFactura(i).getProductos().size(); j++) {

                        outPut.print(usuario.devolverFactura(i).devolverProducto(j).getNombre() + ",");
                        outPut.print(usuario.devolverFactura(i).devolverProducto(j).getPrecioVenta() + ",");
                        outPut.print("0,");
                        outPut.print(usuario.devolverFactura(i).getCantidades().get(j));
                        if (!(usuario.devolverFactura(i).getCantidades().size() == (j + 1))) {
                            outPut.print(",");

                        }
                        //System.out.println(usuario.devolverFactura(i).getCantidades().size());

                    }
                    if (contador != usuario.getFacturas().size()) {
                        outPut.print(",");

                        //outPut.print("\n");
                    }

                    contador++;

                }
            }

        }
outPut.close();
    }

    public void guardarDatosChazas() throws FileNotFoundException {
        PrintStream outPut = new PrintStream(new File("datosChazass"));
        int contador = 1;
        for (Chaza chaza : chazas) {
            outPut.print(chaza.getNombreUsuario() + ",");
            outPut.print(chaza.getClave() + ",");
            outPut.print(chaza.getNombre() + ",");
            outPut.print(chaza.getTelefono() + ",");

            outPut.print(chaza.getHorario() + ",");
            outPut.print(chaza.getPosX() + ",");
            outPut.print(chaza.getPosY() + ",");
            outPut.print(chaza.getInventario().getTamanio() + ",");
            for (int i = 0; i < chaza.getInventario().getTamanio(); i++) {
                outPut.print(chaza.getInventario().getProductoN(i).getNombre() + ",");
                outPut.print(chaza.getInventario().getProductoN(i).getPrecioVenta() + ",");
                outPut.print(chaza.getInventario().getProductoN(i).getCantidad() + ",");
            }
            outPut.print(chaza.getCaja().getIngresos() + ",");
            outPut.print(chaza.getCaja().getEgresos() + ",");
            outPut.print(chaza.getCaja().getBalance());

            if ((contador) != chazas.size()) {
                outPut.print(",");

                //outPut.print("\n");
            }
            contador++;

        }
        outPut.close();
    }

    

    public void cargarDatosUsuarios() throws FileNotFoundException {
        this.usuarios = new ArrayList<>();
        String nombreUsuario, clave, nombre, telefono;
        Scanner input = new Scanner(new File("datosUsuarios")).useDelimiter(",");
        while (input.hasNext()) {

            nombreUsuario = input.next();
            clave = input.next();
            nombre = input.next();
            telefono = input.next();

            Usuario u = new Usuario(nombreUsuario, clave, nombre, telefono);
            usuarios.add(u);
        }
input.close();
    }

    public void cargarDatosFacturasUsuarios() throws FileNotFoundException, ParseException {
        for (Usuario usuario : usuarios) {
//            for(DetalleVenta factura: usuario.getFacturas()){
//                usuario.getFacturas().remove(factura);
//            }
            usuario.setFacturas(new ArrayList<>());
        }
        for (Chaza chaza : chazas) {           
                chaza.setFacturas(new ArrayList<>());          

        }

        int numFacturas = 0, numProductosFactura = 0, totalFactura = 0;
        Date fecha;
        String estado="";
        String nomUsuario="";

        Scanner input = new Scanner(new File("DatosFacturaUsuarios")).useDelimiter(",");
        for (Usuario usuario : usuarios) {
            if (input.hasNextInt()) {
                numFacturas = input.nextInt();

                for (int i = 0; i < numFacturas; i++) {
                    nomUsuario=input.next();
                    DetalleVenta miFactura = new DetalleVenta(this.buscarXUsuario(usuario.getNombreUsuario()), this.buscarChazaXUsuario(nomUsuario));
                    fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).parse(input.next());
                    totalFactura = input.nextInt();
                    estado=input.next();
                    numProductosFactura = input.nextInt();
                    // if(numFacturas>0) nomUsuarioABuscar=input.next();
                    for (int j = 0; j < numProductosFactura; j++) {
                        String nombreProductoFactura;
                        int precio, cantidadNula, cantidadNoNula;
                        nombreProductoFactura = input.next();
                        precio = input.nextInt();
                        cantidadNula = input.nextInt();
                        cantidadNoNula = input.nextInt();

                        Producto miProducto = new Producto(nombreProductoFactura, precio, cantidadNoNula);
                        miFactura.addProducto(miProducto, cantidadNoNula);

                    }
                    miFactura.setFecha(fecha);
                    miFactura.setTotalFactura(totalFactura);
                    miFactura.setEstado(estado);
                    usuario.addFactura(miFactura);
                    buscarChazaXUsuario(nomUsuario).addFactura(miFactura);
                }

            }
        }
input.close();
    }

    

    public void cargarDatosChazas() throws FileNotFoundException, ParseException {
        this.chazas = new ArrayList<>();
        String nombreUsuario, clave, nombre, telefono, horario, nombreProducto, nomUsuarioABuscar;
        int numeroProductos = 0, cantidadProducto = 0;
        double posX = 0, posY = 0;

        int precioProducto = 0, ingresos = 0, egresos = 0, balance = 0;
        Scanner input = new Scanner(new File("datosChazass")).useDelimiter(",");

        while (input.hasNext()) {

            nombreUsuario = input.next();
            clave = input.next();
            nombre = input.next();
            telefono = input.next();

            horario = input.next();
            posX = Double.parseDouble(input.next());

            posY = Double.parseDouble(input.next());
            Chaza c = new Chaza(nombreUsuario, clave, nombre, telefono, horario, posX, posY);

            numeroProductos = input.nextInt();

            for (int i = 0; i < numeroProductos; i++) {

                nombreProducto = input.next();

                if (input.hasNextInt()) {
                    precioProducto = input.nextInt();
                }

                cantidadProducto = input.nextInt();
                c.getInventario().addProducto(nombreProducto, precioProducto, cantidadProducto);
            }

            ingresos = input.nextInt();

            egresos = input.nextInt();

            balance = input.nextInt();

            c.getCaja().setIngresos(ingresos);
            c.getCaja().setEgresos(egresos);
            c.getCaja().setBalance(balance);

            this.addChaza(c);

        }
        puntosTotales=new ArrayList<>();
        for (Chaza chaza : chazas) {
            puntosTotales.add(new Point2D(chaza.getPosX(), chaza.getPosY()));

        }
        input.close();
    }

    public String mostrarUsuarios() {
        String mostrar = "";
        for (int i = 0; i < usuarios.size(); i++) {
            mostrar += "Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre()
                    + usuarios.get(i).getNombreUsuario()
                    + usuarios.get(i).getClave()
                    + usuarios.get(i).getTelefono()
                    + usuarios.get(i).getUbicacion() + "\n";

        }
        return mostrar;
    }

    public String mostrarChazas() {
        String mostrar = "";
        for (int i = 0; i < chazas.size(); i++) {
            mostrar += "Chaza " + (i + 1) + ": " + chazas.get(i).getNombre()
                    + chazas.get(i).getNombreUsuario()
                    + chazas.get(i).getClave()
                    + chazas.get(i).getTelefono()
                    + chazas.get(i).getUbicacion()
                    + chazas.get(i).getHorario()
                    + chazas.get(i).getInventario().toString2()
                    + chazas.get(i).getCaja().getIngresos()
                    + chazas.get(i).getCaja().getEgresos()
                    + chazas.get(i).getCaja().getBalance() + "\n";
        }
        return mostrar;
    }

    public String comprobarInicioSesion(String nombreUsuario, String clave) {
        for (Usuario usuario : usuarios) {

            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getClave().equals(clave)) {
                return "Comprador";
            }

        }
        for (Chaza chaza : chazas) {
            if (chaza.getNombreUsuario().equals(nombreUsuario) && chaza.getClave().equals(clave)) {
                return "Vendedor";
            }

        }
        return "Nulo";

    }

    public Chaza getChazaN(int x) {
        return chazas.get(x);
    }

    public Usuario getUsuarioN(int x) {
        return usuarios.get(x);
    }

    public Usuario buscarXUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombre)) {
                return usuario;
            }

        }
        return null;
    }

    public Chaza buscarChazaXUsuario(String nombre) {
        for (Chaza chaza : chazas) {
            if (chaza.getNombreUsuario().equals(nombre)) {

                return chaza;
            }

        }
        return null;
    }

    public Chaza buscarChazaXCoordenadas(double posX, double posY) {
        for (Chaza chaza : chazas) {
            if (chaza.getPosX() == posX && chaza.getPosY() == posY) {
                return chaza;
            }
        }
        return null;

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ArrayList<Point2D> getPuntosTotales() {

        return this.puntosTotales;
    }
}
