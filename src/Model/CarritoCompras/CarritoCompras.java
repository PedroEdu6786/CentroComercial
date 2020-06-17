/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CarritoCompras;

import Patrones.Decorator.Articulo;
import Patrones.Estado.Estados;
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
    }
    
    public Iterator getArticulosIterator() {
        return getArticulos().getIterator();
    }

    public Estados getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estados estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    public void addArticulo(Articulo articulo) throws CarritoLlenoException {
        estadoActual.addArticulo(this, articulo);
    }
    
    public void removeArticulo(Articulo articulo) throws CarritoVacioException {
        estadoActual.removeArticulo(this, articulo);
    }

    public ArticulosRepository getArticulos() {
        return articulos;
    }

    public void setArticulos(ArticulosRepository articulos) {
        this.articulos = articulos;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
