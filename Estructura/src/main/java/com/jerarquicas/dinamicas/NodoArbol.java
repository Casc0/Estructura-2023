package com.jerarquicas.dinamicas;


class NodoArbol {
    private Object elem;
    private NodoArbol derecho, izquierdo;

    public NodoArbol(Object elem, NodoArbol derecho, NodoArbol izquierdo) {
        this.elem = elem;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    
    public Object getElem() {
        return elem;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }
    
    
}
