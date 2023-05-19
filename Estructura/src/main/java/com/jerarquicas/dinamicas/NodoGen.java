package com.jerarquicas.dinamicas;

class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo, hermanoDerecho;
    
    NodoGen(Object elemento, NodoGen hijo, NodoGen hermano){
        elem = elemento;
        hijoIzquierdo = hijo;
        hermanoDerecho = hermano;
    }

    public Object getElem() {
        return elem;
    }

    public NodoGen getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }
    
    
}
