/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lineales.estaticas;

/**
 *
 * @author franco.fabris
 */
public class Cola {

    private int Tamanio = 10;
    private Object[] arreglo;
    private int frente, fin;

    public Cola() {
        arreglo = new Object[Tamanio];
        frente = 0;
        fin = 0;
    }

    public boolean poner(Object objeto) {
        //Pone el elemento al final de la cola
        boolean sePudo = false;

        if (((fin + 1) % Tamanio != frente)) {
            arreglo[fin] = objeto;
            fin = (fin + 1) % Tamanio;
            sePudo = true;
        }

        return sePudo;
    }

    public boolean sacar() {
        //Saca el elemento al frente de la cola
        boolean sePudo = false;
        if (!esVacia()) {
            arreglo[frente] = null;
            frente = (frente + 1) % Tamanio;
            sePudo = true;
        }
        return sePudo;
    }

    public Object obtenerFrente() {
        Object objFrente = null;
        if (!esVacia()) {
            objFrente = arreglo[frente];
        }
        return objFrente;
    }

    public boolean esVacia() {
        boolean vacia = false;
        if (frente == fin) {
            vacia = true;
        }
        return vacia;
    }

    public void vaciar() {
        arreglo[frente] = null;
        fin = frente;
    }

    public Cola clone() {
        Cola clon = new Cola();
        clon.arreglo = this.arreglo.clone();
        clon.frente = this.frente;
        clon.fin = this.fin;
        return clon;
    }

    @Override
    public String toString() {
        int i = 0;
        String cad;
        if (frente == fin) {
            cad = "[Pila vacia]";
        } else {
            cad = "[";
            if (frente < fin) {
                for (i = frente; i < fin - 1; i++) {
                    cad = cad + arreglo[i] + ", ";
                }
            } else {
                for (i = frente; i < Tamanio; i++) {
                    cad = cad + arreglo[i] + ", ";
                }
                for (i = 0; i < fin - 1; i++) {
                    cad = cad + arreglo[i] + ", ";
                }

            }
            cad = cad + arreglo[i] + "]";

        }
        return cad;
    }

}
