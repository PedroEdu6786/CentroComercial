/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Singleton;

import Model.Tienda.Zapateria;

/**
 *
 * @author rafa_
 */
public class ZapateriaPequeña extends Zapateria {
    
    public static ZapateriaPequeña zapateriaPequeña;
    
    public static ZapateriaPequeña getZapateriaPequeña() {
        if (zapateriaPequeña == null) {
            zapateriaPequeña = new ZapateriaPequeña("");
        }
        return zapateriaPequeña;
    }
    
    private ZapateriaPequeña(String nombre) {
        super(nombre, 5);
    }
    
}
