/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.CentroComercial;

import Model.CarritoCompras.CarritoCompras;
import Model.Cliente.Cliente;
import Model.Tienda.Tienda;
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

    public void addTienda(Tienda tienda) {
        getTiendas().addTienda(tienda);
    }

    public void removeTienda(Tienda tienda) {
        getTiendas().removeTienda(tienda);
    }

    public CarritoCompras getCarrito() {
        return new CarritoCompras();
    }

    public void cancelarCarrito(Cliente cliente) {
        cliente.setCarritoCompras(null);
    }

    public Iterator getTiendasIterator() {
        return getTiendas().getIterator();
    }

    public Iterator getClientesIterator() {
        return clientes.getIterator();
    }

    public TiendasRepository getTiendas() {
        return tiendas;
    }

    public void pagar(Cliente cliente) {
        Date objDate = new Date();
        String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        cliente.addNotificacion("*Has realizado una compra con éxito. " + objSDF.format(objDate));
        cancelarCarrito(cliente);
    }

    @Override
    public void update(String tiendaActualizada) {
        Iterator clientesIterator = clientes.getIterator();

        while (clientesIterator.hasNext()) {
            Cliente clienteANotificar = (Cliente) clientesIterator.next();
            Date objDate = new Date();
            String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            clienteANotificar.addNotificacion("*" + tiendaActualizada + " ha agregado un nuevo producto. " + objSDF.format(objDate));
        }
    }

}
