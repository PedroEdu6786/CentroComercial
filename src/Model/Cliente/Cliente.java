/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Cliente;

import Model.CarritoCompras.CarritoCompras;
import Model.Tienda.Tienda;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public class Cliente {
    private String nombre;
    private CarritoCompras carritoCompras;
    private Tienda tiendaActual;
    private ArrayList<String> notificaciones = new ArrayList<>();
    
    public Cliente(String nombre) {
        this.nombre = nombre;
        tiendaActual = null;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setTiendaActual(Tienda tiendaActual) {
        this.tiendaActual = tiendaActual;
    }
    
    public Tienda getTiendaActual() {
        return tiendaActual;
    }
    
    public void addNotificacion(String notificacion) {
        getNotificaciones().add(notificacion);
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public ArrayList<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<String> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
