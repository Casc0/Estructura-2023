package com.conjuntistas.dinamicas;

public class TablaHash {

    int tamanio = 10, cant = 0;
    Nodo[] arreglo = new Nodo[tamanio - 1];

    public TablaHash() {

    }

    public boolean insertar(Object nuevoElem) {
        /*primero verifica si el elemento ya esta cargado. Si no lo encuentra, lo pone adelante del resto*/

        boolean encontrado = false;
        int pos = nuevoElem.hashCode() % tamanio;
        Nodo aux = this.arreglo[pos];

        while (!encontrado && aux != null) {
            encontrado = aux.getElem().equals(nuevoElem);
            aux = aux.getEnlace();
        }
        if (!encontrado) {
            arreglo[pos] = new Nodo(nuevoElem, arreglo[pos]);
            cant++;
        }
        return encontrado;
    }

    public boolean eliminar(Object x) {
        boolean eliminado = false;
        int pos = x.hashCode() % tamanio;
        Nodo aux = arreglo[pos];

        if (aux != null) {
            if (aux.getElem().equals(eliminado)) {
                arreglo[pos] = aux.getEnlace();
            } else {
                while (!eliminado && aux.getEnlace() != null) {
                    eliminado = aux.getEnlace().getElem().equals(x);
                    if (eliminado) {
                        aux.setEnlace(aux.getEnlace().getEnlace());
                    } else {
                        aux = aux.getEnlace();
                    }

                }
            }
        }

        return eliminado;
    }

}
