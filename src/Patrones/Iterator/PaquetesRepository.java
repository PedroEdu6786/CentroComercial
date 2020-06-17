/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Patrones.Decorator.Paquete;

/**
 *
 * @author User
 */
public class PaquetesRepository implements Container{

    private Paquete[] paquetess;
    private final int maxLength;
    private int counter;
    
    public PaquetesRepository(int cantidadMaximaPaquetes) {
        this.counter = 0;
        paquetess = new Paquete[cantidadMaximaPaquetes];
        maxLength = cantidadMaximaPaquetes;
    }
    
    public void addPaquete(Paquete paquetes) throws ListaPaquetesLlenaException {
        if (counter == maxLength) {
            throw new ListaPaquetesLlenaException("Lista de paquetess llena");
        } else {
            paquetess[counter] = paquetes;
            counter++;   
        }
    }
    
    public void removePaquete(Paquete paquetes) throws ListaPaquetesVaciaException {
        
        if (counter == 0) {
            throw new ListaPaquetesVaciaException("Lista de paquetess vacia");
        } else {
            boolean flag = false;
            int i = 0;

            while(i < paquetess.length && paquetess[i + 1] != null) {
                if (paquetess[i].equals(paquetes)) {
                    flag = true;
                }
                if (flag) {
                    paquetess[i] = paquetess[i + 1];
                }
            }
            counter--;
        }
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new PaquetesIterator(paquetess);
    }
    
}
