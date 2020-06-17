
import Model.Cliente.Cliente;
import Model.Tienda.Libreria;
import Model.Tienda.Tienda;
import Patrones.AbstractFactory.FactorySucursal;
import Patrones.AbstractFactory.FactorySucursalGrande;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;
import Patrones.Singleton.LibreriaGrande;

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
        
        FactorySucursal factory = new FactorySucursalGrande();
        Libreria libreriaGrande = factory.createLibreria();
        
        libreriaGrande.setNombre("Juanes");
        
        Iterator iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
            cliente.setTiendaActual(libreriaGrande);
        }
        
        iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
        }
        
        
    }
}
