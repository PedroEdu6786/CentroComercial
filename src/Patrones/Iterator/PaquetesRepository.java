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

    private Paquete[] paquetes;
    private final int maxLength;
    private int counter;
    
    public PaquetesRepository(int cantidadMaximaPaquetes) {
        this.counter = 0;
        paquetes = new Paquete[cantidadMaximaPaquetes];
        maxLength = cantidadMaximaPaquetes;
    }
    
    public void addPaquete(Paquete paquetes) throws ListaPaquetesLlenaException {
        if (counter == maxLength) {
            throw new ListaPaquetesLlenaException("Lista de paquetes llena");
        } else {
            this.paquetes[counter] = paquetes;
            counter++;   
        }
    }
    
    public void removePaquete(Paquete paquetes) throws ListaPaquetesVaciaException {
        
        if (counter == 0) {
            throw new ListaPaquetesVaciaException("Lista de paquetes vacia");
        } else {
            boolean flag = false;
            int i = 0;

            while(i < this.paquetes.length && this.paquetes[i + 1] != null) {
                if (this.paquetes[i].equals(paquetes)) {
                    flag = true;
                }
                if (flag) {
                    this.paquetes[i] = this.paquetes[i + 1];
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
        return new PaquetesIterator(paquetes);
    }
    
}
