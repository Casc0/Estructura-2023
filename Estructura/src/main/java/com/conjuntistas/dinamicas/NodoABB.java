
package com.conjuntistas.dinamicas;

class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo, derecho;
    
    public NodoABB(Comparable el, NodoABB izq, NodoABB der){
        elem = el;
        izquierdo = izq;
        derecho = der;
    }

    public Comparable getElem() {
        return elem;
    }

    public NodoABB getIzquierdo() {
        return izquierdo;
    }

    public NodoABB getDerecho() {
        return derecho;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
    
    
}
