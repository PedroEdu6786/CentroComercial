/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.AbstractFactory;

import Model.Tienda.Libreria;
import Model.Tienda.Zapateria;
import Patrones.Singleton.LibreriaGrande;
import Patrones.Singleton.ZapateriaGrande;

/**
 *
 * @author rafa_
 */
public class FactorySucursalGrande extends FactorySucursal {

    @Override
    public Zapateria createZapateria() {
        return ZapateriaGrande.getZapateriaGrande();
    }

    @Override
    public Libreria createLibreria() {
        return LibreriaGrande.getLibreriaGrande();
    }
    
}
