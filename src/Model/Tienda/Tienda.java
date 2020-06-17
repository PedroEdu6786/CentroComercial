/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tienda;

import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Excepciones.PaqueteNoEncontradoException;
import Model.CarritoCompras.CarritoCompras;
import Model.Cliente.Cliente;
import Patrones.Decorator.Articulo;
import Patrones.Decorator.Paquete;
import Patrones.Decorator.Vendible;
import Patrones.Iterator.ArticulosRepository;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;
import Patrones.Iterator.PaquetesRepository;
import java.util.List;

/**
 *
 * @author rafa_
 */
public abstract class Tienda {

    private String nombre;
    private String identificador;
    private int cantidadMaximaArticulos;
    private ArticulosRepository articulos;
    private ClientesRepository clientes;
    private PaquetesRepository paquetes;

    public Tienda(String nombre, String identificador, int cantidadMaximaArticulos) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.cantidadMaximaArticulos = cantidadMaximaArticulos;
        articulos = new ArticulosRepository(cantidadMaximaArticulos);
        clientes = new ClientesRepository();
        paquetes = new PaquetesRepository(cantidadMaximaArticulos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCantidadMaximaArticulos() {
        return cantidadMaximaArticulos;
    }

    public void setCantidadMaximaArticulos(int cantidadMaximaArticulos) {
        this.cantidadMaximaArticulos = cantidadMaximaArticulos;
    }

    public Iterator getArticulosIterator() {
        return articulos.getIterator();
    }

    public Iterator getClientesIterator() {
        return clientes.getIterator();
    }

    public Iterator getPaqueteIterator() {
        return paquetes.getIterator();
    }

    public ArticulosRepository getArticulos() {
        return articulos;
    }

    public ClientesRepository getClientes() {
        return clientes;
    }

    public PaquetesRepository getPaquetes() {
        return paquetes;
    }

    public abstract void entrar(Cliente cliente);

    public abstract void salir(Cliente cliente);
    
    public void addArticuloACarrito(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosLlenaException {
        carritoCompras.addArticulo(articulo);
    }

    public void removeArticuloDeCarrito(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException {
        carritoCompras.removeArticulo(articulo);
    }

    public void addPaqueteACarrito(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesLlenaException {
        carritoCompras.addPaquete(paquete);
    }

    public void removePaqueteDeCarrito(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        carritoCompras.removePaquete(paquete);
    }
    
    public void addCliente(Cliente cliente) {
        clientes.addCliente(cliente);
    }
    
    public void removeCliente(Cliente cliente) {
        clientes.removeCliente(cliente);
    }

    public void addArticulo(Articulo articulo) throws ListaArticulosLlenaException {
        articulos.addArticulo(articulo);
    }

    public void removeArticulo(Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException {
        articulos.removeArticulo(articulo);
    }

    public void addPaquete(Paquete paquete) throws ListaPaquetesLlenaException {
        paquetes.addPaquete(paquete);
    }
    
    public void removePaquete(Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        paquetes.removePaquete(paquete);
    }

    public Paquete crearPaquete(List<Articulo> articulos, double descuento) {
        Articulo articulo = articulos.get(0);
        Vendible paquete = new Articulo(articulo.getNombre(), articulo.getIdentificador(), articulo.getIdentificadorTienda(), articulo.getPrecio() * (1 - .25));
        
        for (int i = 1; i < articulos.size(); i++) {
            paquete = new Paquete(paquete, articulos.get(i), descuento);
        }
        
        return (Paquete) paquete;
    }
    
}
