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
public class LibreriaGrande extends Libreria {
    
    private static LibreriaGrande libreriaGrande;
    
    public static LibreriaGrande getLibreriaGrande() {
        if (libreriaGrande == null) {
            libreriaGrande = new LibreriaGrande("");
        }
        return libreriaGrande;
    }
    
    private LibreriaGrande(String nombre) {
        super(nombre, 8);
    }
    
}
