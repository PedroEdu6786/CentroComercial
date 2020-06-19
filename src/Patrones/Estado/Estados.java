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
public interface Estados {
    
    public abstract void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException;
    public abstract void addArticulo(CarritoCompras carritoCompras, Articulo articulo) throws ListaArticulosLlenaException;
    public abstract void removePaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException;
    public abstract void addPaquete(CarritoCompras carritoCompras, Paquete paquete) throws ListaPaquetesLlenaException;
}
