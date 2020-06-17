/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Singleton;

import Model.Tienda.Libreria;

/**
 *
 * @author rafa_
 */
public class LibreriaPequeña extends Libreria {
    
    public static LibreriaPequeña libreriaPequeña;
    
    public static LibreriaPequeña getLibreriaPequeña() {
        if (libreriaPequeña == null) {
            libreriaPequeña = new LibreriaPequeña("");
        }
        return libreriaPequeña;
    }
    
    private LibreriaPequeña(String nombre) {
        super(nombre, 5);
    }
    
    
}
