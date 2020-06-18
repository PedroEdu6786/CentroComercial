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
public class ZapateriaGrande extends Zapateria {
    
    private static ZapateriaGrande zapateriaGrande;
    
    public static ZapateriaGrande getZapateriaGrande() {
        if (zapateriaGrande == null) {
            zapateriaGrande = new ZapateriaGrande("");
        }
        return zapateriaGrande;
    }
    
    private ZapateriaGrande(String nombre) {
        super(nombre, 8);
    }
    
}
