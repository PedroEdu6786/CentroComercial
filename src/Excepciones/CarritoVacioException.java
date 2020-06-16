/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author User
 */
public class CarritoVacioException extends Exception {

    /**
     * Creates a new instance of <code>CarritoVacioException</code> without
     * detail message.
     */
    public CarritoVacioException() {
    }

    /**
     * Constructs an instance of <code>CarritoVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CarritoVacioException(String msg) {
        super(msg);
    }
}
