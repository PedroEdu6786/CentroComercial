/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tienda;

import Model.Cliente.Cliente;

/**
 *
 * @author rafa_
 */
public class Libreria extends Tienda{
    
    public Libreria(String nombre, int cantidadMaximaArticulos) {
        super(nombre, "LIBRERIA", cantidadMaximaArticulos);
    }

    @Override
    public void entrar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salir(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
