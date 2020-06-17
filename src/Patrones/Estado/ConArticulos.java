/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Excepciones.PaqueteNoEncontradoException;
import Model.CarritoCompras.CarritoCompras;
import Patrones.Decorator.Articulo;
import Patrones.Decorator.Paquete;

/**
 *
 * @author User
 */
public class ConArticulos implements Estados{

    @Override
    public void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException {
        if (carritoCompras.getArticulos().size() == 1 && carritoCompras.getPaquetes().size() == 0) {
            carritoCompras.setEstadoActual(new Vacio());
        }
        
        carritoCompras.getArticulos().removeArticulo(articulo);
        
    }

    @Override
    public void addArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosLlenaException {
        if (carritoCompras.getArticulos().size() + carritoCompras.getPaquetes().size() == carritoCompras.getCapacidad() - 1) {
            carritoCompras.setEstadoActual(new Lleno());
        }
        carritoCompras.getArticulos().addArticulo(articulo);
    }

    @Override
    public void removePaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        if (carritoCompras.getPaquetes().size() == 1 && carritoCompras.getArticulos().size() == 0) {
            carritoCompras.setEstadoActual(new Vacio());
        }
        carritoCompras.getPaquetes().removePaquete(paquete);
    }

    @Override
    public void addPaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesLlenaException {
        if (carritoCompras.getPaquetes().size() + carritoCompras.getArticulos().size() == carritoCompras.getCapacidad() - 1) {
            carritoCompras.setEstadoActual(new Lleno());
        }
        carritoCompras.getPaquetes().addPaquete(paquete);
    }
    
}
