/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Excepciones.ListaPaquetesLlenaException;
import Excepciones.ListaPaquetesVaciaException;
import Excepciones.PaqueteNoEncontradoException;
import Patrones.Decorator.Paquete;

/**
 *
 * @author User
 */
public class PaquetesRepository implements Container{

    private Paquete[] paquetes;
    private final int maxLength;
    private int counter;
    
    public PaquetesRepository(int cantidadMaximaPaquetes) {
        this.counter = 0;
        paquetes = new Paquete[cantidadMaximaPaquetes];
        maxLength = cantidadMaximaPaquetes;
    }
    
    public void addPaquete(Paquete paquete) throws ListaPaquetesLlenaException {
        if (counter == maxLength) {
            throw new ListaPaquetesLlenaException("Lista de paquetes llena");
        } else {
            paquetes[counter] = paquete;
            counter++;   
        }
    }
    
    public void removePaquete(Paquete paquete) throws ListaPaquetesVaciaException, PaqueteNoEncontradoException {
        
        if (counter == 0) {
            throw new ListaPaquetesVaciaException("Lista de paquetes vacia");
        } else {
            boolean flag = false;
            int i = 0;

            while(i < counter) {
                if (paquetes[i].equals(paquete)) {
                    flag = true;
                    paquetes[i] = null;
                }
                if (flag && paquetes[i + 1] != null) {
                    paquetes[i] = paquetes[i + 1];
                }
                i++;
            }
            
            if(!flag) {
                throw new PaqueteNoEncontradoException("Articulo no encontrado");
            } else {
                counter--;
            }
        }
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new PaquetesIterator(paquetes);
    }
    
}
