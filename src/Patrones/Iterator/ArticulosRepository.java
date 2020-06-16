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
public class ArticulosRepository implements Container {
    private Articulo[] articulos = new Articulo[100];
    private int counter;
    
    public ArticulosRepository() {
        this.counter = 0;
    }
    
    public void addArticulo(Articulo cliente) {
        articulos[counter] = cliente;
        counter++;
    }
    
    public void removeArticulo(Articulo cliente) {
        boolean flag = false;
        int i = 0;
        while(i < articulos.length && articulos[i + 1] != null) {
            if (articulos[i].equals(cliente)) {
                flag = true;
            }
            if (flag) {
                articulos[i] = articulos[i + 1];
            }
        }
        
        counter--;
    }

    @Override
    public Iterator getIterator() {
        return new ArticulosIterator(articulos);
    }
}
