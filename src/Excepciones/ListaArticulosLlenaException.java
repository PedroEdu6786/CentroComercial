/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author rafa_
 */
public class ListaArticulosLlenaException extends Exception {

    /**
     * Creates a new instance of <code>ListaArticulosLlenaException</code>
     * without detail message.
     */
    public ListaArticulosLlenaException() {
    }

    /**
     * Constructs an instance of <code>ListaArticulosLlenaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ListaArticulosLlenaException(String msg) {
        super(msg);
    }
}
