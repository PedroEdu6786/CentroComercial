/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CentroComercial;

import Model.CarritoCompras.CarritoCompras;
import Model.Cliente.Cliente;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;
import Patrones.Iterator.TiendasRepository;
import Patrones.Observer.Observadores;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rafa_
 */
public class CentroComercial implements Observadores {

    private String nombre;
    private TiendasRepository tiendas;
    private ClientesRepository clientes;
    
    public CentroComercial(String nombre) {
        this.nombre = nombre;
        tiendas = new TiendasRepository();
        clientes = new ClientesRepository();
    }
    
    public void entrar(Cliente cliente) {
        clientes.addCliente(cliente);
    }
    
    public void salir(Cliente cliente) {
        clientes.removeCliente(cliente);
    }
    
    public CarritoCompras getCarrito() {
        return new CarritoCompras();
    }
    
    public Iterator getTiendas() {
        return tiendas.getIterator();
    }
    
    public Iterator getClientes(){
        return clientes.getIterator();
    }
    
    public void pagar() {
        
    }

    @Override
    public void update(String tiendaActualizada) {
        Iterator clientesIterator = clientes.getIterator();

        while (clientesIterator.hasNext()) {
            Cliente clienteANotificar = (Cliente) clientesIterator.next();
            Date objDate = new Date();
            System.out.println(objDate);
            String strDateFormat = "hh: mm: ss a dd-MMM-aaaa"; 
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            clienteANotificar.addNotificacion("*La tienda " + tiendaActualizada + " ha agregado nuevos artículos. " + objSDF.format(objDate));
        }
    }

}
