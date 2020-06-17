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
public class TiendasRepository implements Container {
    private Tienda[] tiendas = new Tienda[100];
    private int counter;
    
    public TiendasRepository() {
        this.counter = 0;
    }
    
    public void addTienda(Tienda tienda) {
        tiendas[counter] = tienda;
        counter++;
    }
    
    public void removeTienda(Tienda tienda) {
        boolean flag = false;
        int i = 0;
        while(i < tiendas.length && tiendas[i + 1] != null) {
            if (tiendas[i].equals(tienda)) {
                flag = true;
            }
            if (flag) {
                tiendas[i] = tiendas[i + 1];
            }
        }
        
        counter--;
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new TiendasIterator(tiendas);
    }
}
