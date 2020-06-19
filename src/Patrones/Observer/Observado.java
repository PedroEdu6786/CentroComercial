/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Observer;

import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public class Observado {

    ArrayList<Observadores> observadores = new ArrayList<>();

    public void adicionarObservador(Observadores observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observadores observador) {
        observadores.remove(observador);
    }

    public void notificarTodos(String tiendaActualizada) {
        observadores.forEach((observador) -> {
            observador.update(tiendaActualizada);
        });
    }
}
