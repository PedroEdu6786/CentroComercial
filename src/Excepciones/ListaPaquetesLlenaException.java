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
public class ListaPaquetesLlenaException extends Exception {

    /**
     * Creates a new instance of <code>ListaPaqueteLlenaException</code> without
     * detail message.
     */
    public ListaPaquetesLlenaException() {
    }

    /**
     * Constructs an instance of <code>ListaPaqueteLlenaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ListaPaquetesLlenaException(String msg) {
        super(msg);
    }
}
