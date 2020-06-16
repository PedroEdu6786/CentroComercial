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
public class CarritoLlenoException extends Exception {

    /**
     * Creates a new instance of <code>CarritoLlenoException</code> without
     * detail message.
     */
    public CarritoLlenoException() {
    }

    /**
     * Constructs an instance of <code>CarritoLlenoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CarritoLlenoException(String msg) {
        super(msg);
    }
}
