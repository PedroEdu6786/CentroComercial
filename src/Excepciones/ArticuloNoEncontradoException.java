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
public class ArticuloNoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ArticuloNoEncontradoException</code>
     * without detail message.
     */
    public ArticuloNoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ArticuloNoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArticuloNoEncontradoException(String msg) {
        super(msg);
    }
}
