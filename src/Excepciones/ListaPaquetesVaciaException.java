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
public class ListaPaquetesVaciaException extends Exception {

    /**
     * Creates a new instance of <code>ListaPaquetesVaciaException</code>
     * without detail message.
     */
    public ListaPaquetesVaciaException() {
    }

    /**
     * Constructs an instance of <code>ListaPaquetesVaciaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ListaPaquetesVaciaException(String msg) {
        super(msg);
    }
}
