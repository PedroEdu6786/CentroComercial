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
    public Articulo articuloResultado;

    public ArticuloDecorator() {
        articuloResultado = new Articulo("", "", "", 0);
    }
    
    public void addArticulo(Articulo articulo) {
        if (articuloResultado.getNombre().equals("")) {
            articuloResultado.setNombre(articulo.getNombre());
        } else {
            articuloResultado.setNombre(articuloResultado.getNombre() + " + " + articulo.getNombre());
        }
        
        articuloResultado.setPrecio(articuloResultado.getPrecio() + articulo.getPrecio());
    }
    
    public void setArticuloResultado(Articulo articuloResultado) {
        this.articuloResultado = articuloResultado;
    }
    
    public Articulo getArticuloResultado() {
        return articuloResultado;
    }
    
    @Override
    public String getNombre() {
        return "";
    }
    
    @Override
    public double getPrecio() {
        return 0;
    }
    
}
