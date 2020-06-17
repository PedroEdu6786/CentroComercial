/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Excepciones.CarritoLlenoException;
import Excepciones.CarritoVacioException;
import Model.CarritoCompras.CarritoCompras;
import Patrones.Decorator.Articulo;

/**
 *
 * @author User
 */
public interface Estados {
    
    public abstract void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) throws CarritoVacioException;
    public abstract void addArticulo(CarritoCompras carritoCompras, Articulo articulo) throws CarritoLlenoException;
    
}
