/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.AbstractFactory;

import Model.Tienda.Libreria;
import Model.Tienda.Zapateria;
import Patrones.Singleton.LibreriaPequeña;
import Patrones.Singleton.ZapateriaPequeña;

/**
 *
 * @author rafa_
 */
public class FactorySucursalPequeña extends FactorySucursal {

    @Override
    public Zapateria createZapateria() {
        return ZapateriaPequeña.getZapateriaPequeña();
    }

    @Override
    public Libreria createLibreria() {
        return LibreriaPequeña.getLibreriaPequeña();
    }
    
}
