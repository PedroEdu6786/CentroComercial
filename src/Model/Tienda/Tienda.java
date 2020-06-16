/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tienda;

import Model.Cliente.Cliente;
import Patrones.Decorator.Articulo;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public abstract class Tienda {
    private String nombre;
    private String identificador;
    private int cantidadArticulos;
    ArrayList<Articulo> articulos = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    
    public Tienda(String nombre, String identificador, int cantidadArticulos) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.cantidadArticulos = cantidadArticulos;
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

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }
}
