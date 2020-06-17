/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Cliente;

import Model.Tienda.Tienda;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public class Cliente {
    private String nombre;
    //falta CarritoCompras carritoCompras;
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
        notificaciones.add(notificacion);
    }
}
