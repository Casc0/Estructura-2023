package com.conjuntistas.dinamicas;

class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo, derecho;
    
    public NodoAVL( Comparable elemento, NodoAVL izq, NodoAVL der){
        elem = elemento;
        izquierdo = izq;
        derecho = der;
        recalcularAltura();
    }

    public Object getElem() {
        return elem;
    }

    public int getAltura() {
        return altura;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
        this.recalcularAltura();
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
        this.recalcularAltura();
    }
    
    public void recalcularAltura(){
        if(izquierdo != null && derecho != null){
            altura = 1 + Math.max(izquierdo.altura, derecho.altura);
        }else if( izquierdo != null){
            altura = 1 + izquierdo.altura;
        }else if(derecho != null){
            altura = 1 + derecho.altura;
        }else{
            altura = 0;
        }
        
    }
}
