/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Patrones.Decorator.Articulo;

/**
 *
 * @author User
 */
public class ArticulosRepository implements Container {
    private Articulo[] articulos;
    private final int maxLength;
    private int counter;
    
    public ArticulosRepository(int cantidadMaximaArticulos) {
        this.counter = 0;
        articulos = new Articulo[cantidadMaximaArticulos];
        maxLength = cantidadMaximaArticulos;
    }
    
    public void addArticulo(Articulo articulo) throws ListaArticulosLlenaException {
        if (counter == maxLength) {
            throw new ListaArticulosLlenaException("Lista de articulos llena");
        } else {
            articulos[counter] = articulo;
            counter++;   
        }
    }
    
    public void removeArticulo(Articulo articulo) throws ListaArticulosVaciaException, ArticuloNoEncontradoException {
        
        if (counter == 0) {
            throw new ListaArticulosVaciaException("Lista de articulos vacia");
        } else {
            boolean flag = false;
            int i = 0;

            while(i < counter) {
                if (articulos[i].equals(articulo)) {
                    flag = true;
                    articulos[i] = null;
                }
                if (flag && articulos[i + 1] != null) {
                    articulos[i] = articulos[i + 1];
                }
                i++;
            }
            
            if(!flag) {
                throw new ArticuloNoEncontradoException("Articulo no encontrado");
            } else {
                this.counter--;
            }
        }
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new ArticulosIterator(articulos);
    }
}
