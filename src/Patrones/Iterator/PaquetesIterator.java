/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Patrones.Decorator.Paquete;

/**
 *
 * @author User
 */
public class PaquetesIterator implements Iterator {

    private Paquete[] paquetes;
    private int index;
    
    public PaquetesIterator(Paquete[] paquetes) {
        this.index = 0;
        this.paquetes = paquetes;
    }
    
    @Override
    public boolean hasNext() {
        if (index < paquetes.length && paquetes[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return paquetes[index++];
    }
    
}
