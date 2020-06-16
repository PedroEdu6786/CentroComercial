/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Estado;

import Patrones.Decorator.Articulo;
import Patrones.Iterator.ArticulosRepository;

/**
 *
 * @author User
 */
public class ConArticulos implements Estados{

    @Override
    public void removeArticulo(ArticulosRepository repository, Articulo articulo) {
        repository.removeArticulo(articulo);
    }

    @Override
    public void addArticulo(ArticulosRepository repository, Articulo articulo) {
        repository.addArticulo(articulo);
    }
    
}
