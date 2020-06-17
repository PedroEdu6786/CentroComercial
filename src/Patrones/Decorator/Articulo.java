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
public class Articulo implements Vendible {
    private String nombre;
    private String identificador;
    private String identificadorTienda;
    private double precio;

    public Articulo(String nombre, String identificador, double precio) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.precio = precio;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public void setIdentificadorTienda(String identificadorTienda) {
        this.identificadorTienda = identificadorTienda;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public String getIdentificadorTienda() {
        return identificadorTienda;
    }
    
    @Override
    public double getPrecio() {
        return precio;
    }
    
}
