/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Iterator;

import Patrones.Decorator.Paquete;

/**
 *
 * @author User
 */
public class PaquetesRepository implements Container{

    private Paquete[] paquetes = new Paquete[100];
    private int counter;
    
    public PaquetesRepository() {
        this.counter = 0;
    }
    
    public void addPaquete(Paquete paquete) {
        paquetes[counter] = paquete;
        counter++;
    }
    
    public void removePaquete(Paquete paquete) {
        boolean flag = false;
        int i = 0;
        while(i < paquetes.length && paquetes[i + 1] != null) {
            if (paquetes[i].equals(paquete)) {
                flag = true;
            }
            if (flag) {
                paquetes[i] = paquetes[i + 1];
            }
        }
        
        counter--;
    }
    
    public int size() {
        return counter;
    }

    @Override
    public Iterator getIterator() {
        return new PaquetesIterator(paquetes);
    }
    
}
