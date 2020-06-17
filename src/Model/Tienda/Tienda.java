/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tienda;

import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Model.CarritoCompras.CarritoCompras;
import Model.Cliente.Cliente;
import Patrones.Decorator.Articulo;
import Patrones.Iterator.ArticulosRepository;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;
import Patrones.Iterator.PaquetesRepository;

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
    
    public Iterator getClientesIterator(){
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
    
    public void addArticuloACarrito(CarritoCompras carritoCompras, Articulo articulo) throws CarritoLlenoException {
        carritoCompras.addArticulo(articulo);
    }
    
    public void removeArticuloDeCarrito(CarritoCompras carritoCompras, Articulo articulo) throws CarritoVacioException {
        carritoCompras.removeArticulo(articulo);
    }
    
    public void addArticulo(Articulo articulo) throws ListaArticulosLlenaException {
        if (articulos.size() == cantidadMaximaArticulos) {
            throw new ListaArticulosLlenaException();
        } else {
            articulos.addArticulo(articulo);
        }
    }
    
    public void removeArticulo(Articulo articulo) throws ListaArticulosVaciaException {
        if (articulos.size() == 0) {
            throw new ListaArticulosVaciaException();
        } else {
            articulos.removeArticulo(articulo);
        }
    }

    
}
