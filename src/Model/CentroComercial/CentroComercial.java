/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CentroComercial;

import Model.Cliente.Cliente;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.Iterator;
import Patrones.Observer.Observadores;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rafa_
 */
public class CentroComercial implements Observadores {

    public String nombre;
    //FALTA LISTATIENDAS
    ClientesRepository clientes;

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
