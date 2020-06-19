/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.AbstractFactory;

import Model.Tienda.Libreria;
import Model.Tienda.Zapateria;

/**
 *
 * @author rafa_
 */
public abstract class FactorySucursal {
    public abstract Zapateria createZapateria();
    public abstract Libreria createLibreria();
}
