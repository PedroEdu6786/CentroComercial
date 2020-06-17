/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Model.CarritoCompras.CarritoCompras;
import Patrones.Decorator.Articulo;

/**
 *
 * @author User
 */
public class ConArticulos implements Estados{

    @Override
    public void removeArticulo(CarritoCompras carritoCompras, Articulo articulo) {
        if (carritoCompras.getArticulos().size() == 1) {
            carritoCompras.setEstadoActual(new Vacio());
        }
        carritoCompras.getArticulos().removeArticulo(articulo);
        
    }

    @Override
    public void addArticulo(CarritoCompras carritoCompras, Articulo articulo) {
        if (carritoCompras.getArticulos().size() == carritoCompras.getCapacidad() - 1) {
            carritoCompras.setEstadoActual(new Lleno());
        }
        carritoCompras.getArticulos().addArticulo(articulo);
    }
    
}
