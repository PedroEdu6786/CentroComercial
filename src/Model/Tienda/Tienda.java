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
import Patrones.Observer.Observado;
import Patrones.Observer.Observadores;
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
    public Observado observado;

    public Tienda(String nombre, String identificador, int cantidadMaximaArticulos) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.cantidadMaximaArticulos = cantidadMaximaArticulos;
        articulos = new ArticulosRepository(cantidadMaximaArticulos);
        clientes = new ClientesRepository();
        paquetes = new PaquetesRepository(cantidadMaximaArticulos);
        observado = new Observado();
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

    public Iterator getPaquetesIterator() {
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
        articulo.setIdentificadorTienda(nombre);
        articulos.addArticulo(articulo);
        observado.notificarTodos(nombre);
    }

    public void removeArticulo(Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException {
        articulos.removeArticulo(articulo);
    }

    public void addPaquete(Paquete paquete) throws ListaPaquetesLlenaException {
        paquete.setIdentificadorTienda(nombre);
        paquetes.addPaquete(paquete);
        observado.notificarTodos(nombre);
    }

    public void removePaquete(Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        paquetes.removePaquete(paquete);
    }

    public Paquete crearPaquete(List<Articulo> articulos, double descuento) {

        Vendible paquete = null;

        if (!articulos.isEmpty()) {
            for (int i = 0; i < articulos.size(); i++) {
                if (i == 0) {
                    paquete = new Articulo(articulos.get(i).getNombre(), articulos.get(i).getIdentificador(), articulos.get(i).getPrecio() * (1 - .25));
                } else {
                    paquete = new Paquete(paquete, articulos.get(i), descuento);
                }
            }
        }

        return (Paquete) paquete;
    }

    public void addObservador(Observadores observador) {
        observado.adicionarObservador(observador);
    }

    public void removeObservador(Observadores observador) {
        observado.eliminarObservador(observador);
    }

}
