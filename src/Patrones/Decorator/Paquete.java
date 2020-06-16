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

    private Vendible articuloAgregado;
    private double descuento;
    
    public Paquete(Vendible paquete, Vendible articuloAgregado, double descuento) {
        super(paquete);
        setArticuloAgregado(articuloAgregado);
        setDescuento(descuento);
    }
    
    @Override
    public String getNombre() {
        return getVendible().getNombre() + " + " + getArticuloAgregado().getNombre();
    }
    
    @Override
    public double getPrecio() {
       return getVendible().getPrecio() + getArticuloAgregado().getPrecio() * (1 - getDescuento());
    }

    public Vendible getArticuloAgregado() {
        return articuloAgregado;
    }

    public void setArticuloAgregado(Vendible articuloAgregado) {
        this.articuloAgregado = articuloAgregado;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
}
