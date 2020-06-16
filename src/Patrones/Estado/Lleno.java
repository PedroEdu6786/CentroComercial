/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Excepciones.CarritoLlenoException;
import Patrones.Decorator.Articulo;
import Patrones.Iterator.ArticulosRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Lleno implements Estados {

    @Override
    public void removeArticulo(ArticulosRepository repository, Articulo articulo) {
        repository.removeArticulo(articulo);
    }

    @Override
    public void addArticulo(ArticulosRepository repository, Articulo articulo) {
        System.err.println("El carrito se encuentra lleno");
    }
    
}
