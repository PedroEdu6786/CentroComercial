/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CarritoCompras;

import Patrones.Iterator.ArticulosRepository;
import Patrones.Iterator.Iterator;

/**
 *
 * @author rafa_
 */
public class CarritoCompras {
    ArticulosRepository articulos;
    final int capacidad = 25;
    
    public CarritoCompras() {
        articulos = new ArticulosRepository(capacidad);
    }
    
    public Iterator getArticulos() {
        return articulos.getIterator();
    }
}
