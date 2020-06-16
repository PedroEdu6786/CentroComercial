
import Patrones.Decorator.Articulo;
import Patrones.Decorator.ArticuloDecorator;
import Patrones.Decorator.Paquete;
import Patrones.Decorator.Vendible;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class Test {

    public static void main(String[] args) {
        ArticuloDecorator paquete = new Paquete();
        paquete.addArticulo(new Articulo("Air Force One", "NIKE", "NIKEGRANDE", 10));
        paquete.addArticulo(new Articulo("Air Force Two", "NIKE", "NIKEGRANDE", 20));
        System.out.println("Paquete: " + paquete.getNombre());
        System.out.println("Precio: " + paquete.getPrecio());
    }
    
}
