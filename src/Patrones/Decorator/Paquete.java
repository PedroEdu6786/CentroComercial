/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Decorator;

/**
 *
 * @author rafa_
 */
public class Paquete extends ArticuloDecorator {
    
    @Override
    public String getNombre() {
        return articuloResultado.getNombre();
    }
    
    @Override
    public double getPrecio() {
       return articuloResultado.getPrecio();
    }
    
}
