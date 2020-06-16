/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Model.Cliente.Cliente;

/**
 *
 * @author User
 */
public class ClientesIterator implements Iterator {

    private Cliente[] clientes;
    private int index;
    
    public ClientesIterator(Cliente[] clientes) {
        this.index = -1;
        this.clientes = clientes;
    }
    
    @Override
    public boolean hasNext() {
        if (index < clientes.length && clientes[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        this.index++;
        return clientes[index];
    }
    
}
