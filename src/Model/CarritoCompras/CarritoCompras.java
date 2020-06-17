/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CarritoCompras;

import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Excepciones.PaqueteNoEncontradoException;
import Patrones.Decorator.Articulo;
import Patrones.Decorator.Paquete;
import Patrones.Estado.Estados;
import Patrones.Estado.Vacio;
import Patrones.Iterator.ArticulosRepository;
import Patrones.Iterator.Iterator;
import Patrones.Iterator.PaquetesRepository;

/**
 *
 * @author rafa_
 */
public class CarritoCompras {
    private Estados estadoActual;
    private ArticulosRepository articulos;
    private PaquetesRepository paquetes;
    private final int capacidad = 25;
    
    public CarritoCompras() {
        articulos = new ArticulosRepository(getCapacidad());
        paquetes = new PaquetesRepository(getCapacidad());
        estadoActual = new Vacio();
    }
    
    public Iterator getArticulosIterator() {
        return articulos.getIterator();
    }
    
    public Iterator getPaquetesIterator() {
        return paquetes.getIterator();
    }

    public Estados getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estados estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    public void addArticulo(Articulo articulo) throws ListaArticulosLlenaException {
        estadoActual.addArticulo(this, articulo);
    }
    
    public void removeArticulo(Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException  {
        estadoActual.removeArticulo(this, articulo);
    }

    public void addPaquete(Paquete paquete) throws ListaPaquetesLlenaException {
        estadoActual.addPaquete(this, paquete);
    }
    
    public void removePaquete(Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        estadoActual.removePaquete(this, paquete);
    }
    
    public ArticulosRepository getArticulos() {
        return articulos;
    }

    public void setArticulos(ArticulosRepository articulos) {
        this.articulos = articulos;
    }
    
    public PaquetesRepository getPaquetes() {
        return paquetes;
    }
    
    public void setPaquetes(PaquetesRepository paquetes) {
        this.paquetes = paquetes;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
