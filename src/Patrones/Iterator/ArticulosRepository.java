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
    private Articulo[] articulos;
    private int counter;
    
    public ArticulosRepository(int cantidadMaximaArticulos) {
        this.counter = 0;
        articulos = new Articulo[cantidadMaximaArticulos];
    }
    
    public void addArticulo(Articulo articulo) {
        articulos[counter] = articulo;
        counter++;
    }
    
    public void removeArticulo(Articulo articulo) {
        boolean flag = false;
        int i = 0;
        while(i < articulos.length && articulos[i + 1] != null) {
            if (articulos[i].equals(articulo)) {
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
