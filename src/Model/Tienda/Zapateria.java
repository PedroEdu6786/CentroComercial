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
public class Zapateria extends Tienda {
    
    public Zapateria(String nombre, int cantidadMaximaArticulos) {
        super(nombre, "ZAPATERIA", cantidadMaximaArticulos);
    }

    @Override
    public void entrar(Cliente cliente) {
        cliente.setTiendaActual(this);
        addCliente(cliente);
    }

    @Override
    public void salir(Cliente cliente) {
        cliente.setTiendaActual(null);
        removeCliente(cliente);
    }
}
