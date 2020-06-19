/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Excepciones.ListaArticulosLlenaException;
import Excepciones.ListaPaquetesLlenaException;
import Model.CentroComercial.CentroComercial;
import Model.Cliente.Cliente;
import Model.Tienda.Libreria;
import Model.Tienda.Zapateria;
import Patrones.AbstractFactory.FactorySucursal;
import Patrones.AbstractFactory.FactorySucursalGrande;
import Patrones.AbstractFactory.FactorySucursalPequeña;
import Patrones.Decorator.Articulo;
import View.CentroComercialView;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public class Main {

    static FactorySucursal factorySucursal;
    static Zapateria zapateria;
    static Libreria libreria;

    public static void main(String[] args) {
        //Se obtiene el centro comercial y el cliente que utiliza el programa en esta instancia, y este se carga al centro comercial.
        CentroComercial centroComercial = new CentroComercial("Centro FMAT");
        Cliente cliente = new Cliente("Edgar Aguilar Moguel");
        centroComercial.entrar(cliente);

        //Se obtienen los datos del centro comercial.
        cargarCentroComercial(centroComercial);

        //Se ejecuta el programa.
        CentroComercialView centroComercialView = new CentroComercialView(centroComercial, cliente);
        centroComercialView.setVisible(true);
    }

    //Este método tiene el objetivo de simular la obtención de los datos del centro comercial a través de una base de datos.
    public static void cargarCentroComercial(CentroComercial centroComercial) {
        //Se cargan los clientes que están usando el programa del centro comercial.
        centroComercial.entrar(new Cliente("Rafael Canto Vázquez"));
        centroComercial.entrar(new Cliente("Pedro Cruz de la Fuente"));

        //Se cargan los articulos de las tiendas del centro comercial.
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
        Articulo libro1 = new Articulo("Poseidon", "129391", 335);
        Articulo libro2 = new Articulo("Pedro Páramo", "821732", 250);
        Articulo libro3 = new Articulo("Confabulario", "319232", 290);
        Articulo libro4 = new Articulo("Diablo Guardián", "248182", 175);
        Articulo libro5 = new Articulo("Las batallas en el desierto", "912942", 510);
        Articulo libro6 = new Articulo("Harry Potter y la piedra filosofal", "418284", 350);
        Articulo libro7 = new Articulo("Harry Potter y las reliquias de la muerte", "328427", 400);
        Articulo libro8 = new Articulo("El Código da Vinci", "527238", 420);
        Articulo libro9 = new Articulo("Lo que el viento se llevó", "526363", 530);
        Articulo libro10 = new Articulo("El Alquimista", "457223", 280);
        Articulo libro11 = new Articulo("Don Quijote de la Mancha", "922831", 270);
        Articulo libro12 = new Articulo("Historia de dos ciudades", "331823", 600);
        Articulo libro13 = new Articulo("El señor de los Anillos", "922372", 575);

        //Se cargan los paquetes de las tiendas del centro comercial.   
        ArrayList<Articulo> listaZapatos1 = new ArrayList<>();
        listaZapatos1.add(zapato1);
        listaZapatos1.add(zapato2);
        listaZapatos1.add(zapato3);
        ArrayList<Articulo> listaZapatos2 = new ArrayList<>();
        listaZapatos2.add(zapato6);
        listaZapatos2.add(zapato7);
        ArrayList<Articulo> listaZapatos3 = new ArrayList<>();
        listaZapatos3.add(zapato10);
        listaZapatos3.add(zapato13);
        ArrayList<Articulo> listaLibros1 = new ArrayList<>();
        listaLibros1.add(libro1);
        listaLibros1.add(libro5);
        ArrayList<Articulo> listaLibros2 = new ArrayList<>();
        listaLibros2.add(libro8);
        listaLibros2.add(libro10);
        listaLibros2.add(libro13);

        //Se cargan las sucursales pequeñas del centro comercial.
        factorySucursal = new FactorySucursalPequeña();
        zapateria = factorySucursal.createZapateria();
        libreria = factorySucursal.createLibreria();

        //Se añaden los articulos y paquetes cargados a sus respectivas tiendas pequeñas.
        zapateria.setNombre("Zapatería Impuls");
        zapateria.addObservador(centroComercial);
        try {
            zapateria.addArticulo(zapato1);
            zapateria.addArticulo(zapato2);
            zapateria.addArticulo(zapato3);
            zapateria.addArticulo(zapato4);
            zapateria.addArticulo(zapato5);
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos1, .25));
        } catch (ListaArticulosLlenaException ex) {
            System.err.println("La lista de articulos de la tienda está llena.");
        } catch (ListaPaquetesLlenaException ex) {
            System.err.println("La lista de paquetes de la tienda está llena.");
        }

        libreria.setNombre("Librería \"Porrúa\"");
        libreria.addObservador(centroComercial);
        try {
            libreria.addArticulo(libro1);
            libreria.addArticulo(libro2);
            libreria.addArticulo(libro3);
            libreria.addArticulo(libro4);
            libreria.addArticulo(libro5);
            libreria.addPaquete(libreria.crearPaquete(listaLibros1, .50));
        } catch (ListaArticulosLlenaException ex) {
            System.err.println("La lista de articulos de la tienda está llena.");
        } catch (ListaPaquetesLlenaException ex) {
            System.err.println("La lista de paquetes de la tienda está llena.");
        }
        
        //Se añaden las tiendas pequeñas ya con sus artículos y paquetes al centro comercial.
        centroComercial.addTienda(zapateria);
        centroComercial.addTienda(libreria);

        //Se cargan las sucursales grandes del centro comercial.
        factorySucursal = new FactorySucursalGrande();
        zapateria = factorySucursal.createZapateria();
        libreria = factorySucursal.createLibreria();

        //Se añaden los articulos y paquetes cargados a sus respectivas tiendas grandes.
        zapateria.setNombre("Zapatería NIKE");
        zapateria.addObservador(centroComercial);
        try {
            zapateria.addArticulo(zapato6);
            zapateria.addArticulo(zapato7);
            zapateria.addArticulo(zapato8);
            zapateria.addArticulo(zapato9);
            zapateria.addArticulo(zapato10);
            zapateria.addArticulo(zapato11);
            zapateria.addArticulo(zapato12);
            zapateria.addArticulo(zapato13);
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos2, .15));
            zapateria.addPaquete(zapateria.crearPaquete(listaZapatos3, .65));
        } catch (ListaArticulosLlenaException ex) {
            System.err.println("La lista de articulos de la tienda está llena.");
        } catch (ListaPaquetesLlenaException ex) {
            System.err.println("La lista de paquetes de la tienda está llena.");
        }
        
        libreria.setNombre("Librería Gandhi");
        libreria.addObservador(centroComercial);
        try {
            libreria.addArticulo(libro6);
            libreria.addArticulo(libro7);
            libreria.addArticulo(libro8);
            libreria.addArticulo(libro9);
            libreria.addArticulo(libro10);
            libreria.addArticulo(libro11);
            libreria.addArticulo(libro12);
            libreria.addArticulo(libro13);
            libreria.addPaquete(libreria.crearPaquete(listaLibros2, .10));
        } catch (ListaArticulosLlenaException ex) {
            System.err.println("La lista de articulos de la tienda está llena.");
        } catch (ListaPaquetesLlenaException ex) {
            System.err.println("La lista de paquetes de la tienda está llena.");
        }
        
        //Se añaden las tiendas grandes ya con sus artículos y paquetes al centro comercial.
        centroComercial.addTienda(zapateria);
        centroComercial.addTienda(libreria);
    }

}
