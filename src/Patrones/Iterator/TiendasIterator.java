/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Model.Tienda.Tienda;

/**
 *
 * @author User
 */
public class TiendasIterator implements Iterator {
    private Tienda[] tiendas;
    private int index;
    
    public TiendasIterator(Tienda[] tiendas) {
        this.index = 0;
        this.tiendas = tiendas;
    }
    
    @Override
    public boolean hasNext() {
        if (index < tiendas.length && tiendas[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return tiendas[index++];
    }
}
