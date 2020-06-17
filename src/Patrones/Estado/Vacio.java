/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Excepciones.CarritoVacioException;
import Model.CarritoCompras.CarritoCompras;
import Patrones.Decorator.Articulo;

/**
 *
 * @author User
 */
public class Vacio implements Estados {

    @Override
    public void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) throws CarritoVacioException {
        throw new CarritoVacioException();
    }

    @Override
    public void addArticulo(CarritoCompras carritoCompras, Articulo articulo) {
        carritoCompras.getArticulos().addArticulo(articulo);
        carritoCompras.setEstadoActual(new ConArticulos());
    }
    
}
