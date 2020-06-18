
import Excepciones.ArticuloNoEncontradoException;
import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaArticulosVaciaException;
import Model.CarritoCompras.CarritoCompras;
import Model.Cliente.Cliente;
import Model.Tienda.Libreria;
import Model.Tienda.Tienda;
import Patrones.AbstractFactory.FactorySucursal;
import Patrones.AbstractFactory.FactorySucursalGrande;
import Patrones.Decorator.Articulo;
import Patrones.Estado.Estados;
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
    public static void main(String args[]) throws ListaArticulosLlenaException, ListaArticulosVaciaException, ArticuloNoEncontradoException {
        /*
        ClientesRepository clientes = new ClientesRepository();
        
        Cliente rafa = new Cliente("Rafa");
        
        clientes.addCliente(rafa);
        clientes.addCliente(new Cliente("Edgar"));
        clientes.addCliente(new Cliente("Rafa2"));
        clientes.addCliente(new Cliente("Edgar2"));
        
        FactorySucursal factory = new FactorySucursalGrande();
        Libreria libreriaGrande = factory.createLibreria();
        
        libreriaGrande.setNombre("Juanes");
        
        Iterator iterator = clientes.getIterator();
        
        boolean flag = true;
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
        }
        
        clientes.removeCliente(rafa);
        
        iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
        }
                clientes.removeCliente(rafa);
        
        iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
        }
        
        clientes.removeCliente(rafa);
        
        iterator = clientes.getIterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Cliente: " + cliente.getNombre() + cliente.getTiendaActual());
        }
        */
        
        CarritoCompras carritoCompras = new CarritoCompras();
        
        Articulo zapato1 = new Articulo("Vandana 857", "612203", 750);
        Articulo zapato2 = new Articulo("Flexi 402801", "629581", 900);
        Articulo zapato3 = new Articulo("CUSTOM STYLE 5017", "633896", 545);
        Articulo zapato4 = new Articulo("CHRISTIAN GALLERY 2116", "374723", 1220);
        Articulo zapato5 = new Articulo("Vertical 5193", "374722", 1400);
        Articulo zapato6 = new Articulo("Nike Air Max 90", "837231", 2899);
        Articulo zapato7 = new Articulo("Kyrie 6", "471293", 2799);
        Articulo zapato8 = new Articulo("Nike React Vision", "831828", 2599);
        Articulo zapato9 = new Articulo("Jordan ADG 2", "194828", 3299);
        Articulo zapato10 = new Articulo("Nike Blazer Low Leather", "437242", 1799);
        Articulo zapato11 = new Articulo("Nike CruzrOne", "437241", 2999);
        Articulo zapato12 = new Articulo("Air Jordan XXXIV Low", "423142", 13499);
        Articulo zapato13 = new Articulo("Jordan Break", "453422", 799);
        
        carritoCompras.addArticulo(zapato1);
        carritoCompras.addArticulo(zapato2);
        carritoCompras.addArticulo(zapato3);
        carritoCompras.addArticulo(zapato4);
        carritoCompras.addArticulo(zapato5);
        carritoCompras.addArticulo(zapato6);
        carritoCompras.addArticulo(zapato7);
        carritoCompras.addArticulo(zapato8);
        carritoCompras.addArticulo(zapato9);
        carritoCompras.addArticulo(zapato10);
        carritoCompras.addArticulo(zapato11);
        carritoCompras.addArticulo(zapato12);
        carritoCompras.addArticulo(zapato13);
        
        Iterator iterator = carritoCompras.getArticulosIterator();
        
        while(iterator.hasNext()) {
            Articulo articulo = (Articulo) iterator.next();
            System.out.println("Articulo: " + articulo.getNombre());
        }
        
        try {
            carritoCompras.removeArticulo(new Articulo("Jofefregak", "4regegr2", 7343499));
        } catch(ArticuloNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
        
        carritoCompras.removeArticulo(zapato3);

        
        iterator = carritoCompras.getArticulosIterator();
        
        System.out.println("");
        
        while(iterator.hasNext()) {
            Articulo articulo = (Articulo) iterator.next();
            System.out.println("Articulo: " + articulo.getNombre());
        }

    }
}
