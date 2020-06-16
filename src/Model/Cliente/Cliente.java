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
    String nombre;
    //falta CarritoCompras carritoCompras;
    Tienda tiendaActual;
    ArrayList<String> notificaciones = new ArrayList<>();
    
    public void addNotificacion(String notificacion) {
        notificaciones.add(notificacion);
    }
}
