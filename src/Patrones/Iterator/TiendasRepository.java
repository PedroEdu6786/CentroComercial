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
        while(i < counter) {
            if (tiendas[i].equals(tienda)) {
                flag = true;
                tiendas[i] = null;
            }
            if (flag && tiendas[i + 1] != null) {
                tiendas[i] = tiendas[i + 1];
            }
            i++;
        }
        
        counter--;
        
        Tienda[] newTiendas = new Tienda[tiendas.length - 1];
        i = 0;
        while(i < counter) {
            newTiendas[i] = tiendas[i];
            i++;
        }
        this.tiendas = newTiendas;
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new TiendasIterator(tiendas);
    }
}
