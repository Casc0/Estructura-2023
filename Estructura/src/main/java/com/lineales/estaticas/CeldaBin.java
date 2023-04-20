package com.lineales.estaticas;

public class CeldaBin {

    private Object elem;
    private int derecho, izquierdo;
    private boolean enUso;

    public CeldaBin(Object elem, int derecho, int izquierdo, boolean enUso) {
        this.elem = elem;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
        this.enUso = enUso;
    }
    
    
    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setDerecho(int derecho) {
        this.derecho = derecho;
    }

    public void setIzquierdo(int izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    public Object getElem() {
        return elem;
    }

    public int getDerecho() {
        return derecho;
    }

    public int getIzquierdo() {
        return izquierdo;
    }

    public boolean getEnUso() {
        return enUso;
    }

    
    
}
