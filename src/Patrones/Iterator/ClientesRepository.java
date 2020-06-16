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
public class ClientesRepository implements Container{
    
    private Cliente[] clientes = new Cliente[100];
    private int counter;
    
    public ClientesRepository() {
        this.counter = 0;
    }
    
    public void addCliente(Cliente cliente) {
        clientes[counter] = cliente;
        counter++;
    }
    
    public void removeCliente(Cliente cliente) {
        boolean flag = false;
        int i = 0;
        while(i < clientes.length && clientes[i + 1] != null) {
            if (clientes[i].equals(cliente)) {
                flag = true;
            }
            if (flag) {
                clientes[i] = clientes[i + 1];
            }
        }
        
        counter--;
    }

    @Override
    public Iterator getIterator() {
        return new ClientesIterator(clientes);
    }
    

}
