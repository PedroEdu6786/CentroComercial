
import Model.Cliente.Cliente;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TestIterator {
    public static void main(String args[]) {
        ClientesRepository clientes = new ClientesRepository();
        
        clientes.addCliente(new Cliente("Rafa"));
        clientes.addCliente(new Cliente("Edgar"));
        clientes.addCliente(new Cliente("Rafa2"));
        clientes.addCliente(new Cliente("Edgar2"));
        
        
        Iterator iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println(cliente.getNombre());
        }
    }
}
