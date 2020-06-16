/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tienda;

import Model.Cliente.Cliente;
import Patrones.Decorator.Articulo;
import Patrones.Iterator.ArticulosRepository;
import Patrones.Iterator.ClientesRepository;
import Patrones.Iterator.PaquetesRepository;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public abstract class Tienda {
    private String nombre;
    private String identificador;
    ArticulosRepository articulos;
    ClientesRepository clientes;
    PaquetesRepository paquetes;
    
    public Tienda(String nombre, String identificador, int cantidadMaximaArticulos) {
        this.nombre = nombre;
        this.identificador = identificador;
        articulos = new ArticulosRepository(cantidadMaximaArticulos);
        clientes = new ClientesRepository();
        paquetes = new PaquetesRepository();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public abstract void entrar(Cliente cliente);
    public abstract void salir(Cliente cliente);
}
