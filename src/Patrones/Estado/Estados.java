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
public interface Estados {
    
    public abstract void removeArticulo(ArticulosRepository repository, Articulo articulo);
    public abstract void addArticulo(ArticulosRepository repository, Articulo articulo);
    
}
