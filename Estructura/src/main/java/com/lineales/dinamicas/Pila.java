package com.lineales.dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        Nodo nuevo = new Nodo(nuevoElem, tope);

        tope = nuevo;

        return true;
    }

    public boolean desapilar() {
        boolean sePudo = false;

        if (tope != null) {
            tope = tope.getEnlace();
            sePudo = true;
        }

        return sePudo;
    }

    public Object obtenerTope() {
        Object obj = null;
        if(tope != null){
            obj = tope.getElem();
        }
        return obj;
    }

    public boolean esVacia() {
        boolean vacia = false;
        if (tope == null) {
            vacia = true;
        }
        return vacia;
    }

    public void vaciar() {
        tope = null;
    }

    @Override
    public Pila clone() {
        Pila pilita = new Pila();
        if (tope != null) {
            pilita.tope = pilita.clonar(tope, pilita);
        }
        return pilita;
    }

    private Nodo clonar(Nodo auxOrig, Pila pilita) {
        Nodo auxiliar;
        if (auxOrig.getEnlace() == null) {
            auxiliar = new Nodo(auxOrig.getElem(), null);

        } else {
            auxiliar = new Nodo(auxOrig.getElem(), pilita.clonar(auxOrig.getEnlace(), pilita));
        }
        return auxiliar;

    }

    @Override
    public String toString() {
        String s;

        if (tope == null) {
            s = "Pila vacia]";
        } else {
            Nodo aux = tope;
            s = "]";

            while (aux != null) {
                s = aux.getElem().toString() + s;
                aux = aux.getEnlace();

                if (aux != null) {
                    s = ", " + s;
                }
            }
        }
        s = "[" + s;
        return s;
    }
}
