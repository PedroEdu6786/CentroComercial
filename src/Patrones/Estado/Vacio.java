/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

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
public class Vacio implements Estados {

    @Override
    public void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosVaciaException {
        throw new ListaArticulosVaciaException();
    }

    @Override
    public void addArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosLlenaException {
        carritoCompras.getArticulos().addArticulo(articulo);
        carritoCompras.setEstadoActual(new ConArticulos());
    }

    @Override
    public void removePaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesVaciaException {
        throw new ListaPaquetesVaciaException();
    }

    @Override
    public void addPaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesLlenaException {
        carritoCompras.getPaquetes().addPaquete(paquete);
        carritoCompras.setEstadoActual(new ConArticulos());
    }
    
}
