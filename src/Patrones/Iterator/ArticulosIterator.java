/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Patrones.Decorator.Articulo;

/**
 *
 * @author User
 */
public class ArticulosIterator implements Iterator {

    private Articulo[] articulos;
    private int index;
    
    public ArticulosIterator(Articulo[] articulos) {
        this.index = 0;
        this.articulos = articulos;
    }
    
    @Override
    public boolean hasNext() {
        if (index < articulos.length && articulos[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return articulos[index++];
    }
    
}
