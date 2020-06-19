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
public class ArticuloDecorator implements Vendible {
    private Vendible vendible;

    public ArticuloDecorator(Vendible vendible) {
        setVendible(vendible);
    }
    
    public void setVendible(Vendible vendible) {
        this.vendible = vendible;
    }
    
    public Vendible getVendible() {
        return vendible;
    }
    
    @Override
    public String getNombre() {
        return vendible.getNombre();
    }
    
    @Override
    public double getPrecio() {
        return vendible.getPrecio();
    }
    
}
