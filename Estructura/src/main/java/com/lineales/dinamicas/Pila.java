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
        
        if (!this.esVacio()) {
            //tope.setElem(null);
            tope = tope.getEnlace();
            sePudo = true;
        }
        
        return sePudo;
    }
    
    public Object obtenerTope() {               
        return tope.getElem();
    }
    
    public boolean esVacio() {
        boolean vacia = false;
        if (tope == null) {
            vacia = true;
        }
        return vacia;
    }
    
    public void vaciar() {
        
        tope = null;
    }
    
    public Pila clone() {
        Pila clon = new Pila();
        Nodo n = tope;
        tope = new Nodo(n.getElem(), null);
        Nodo y = clon.tope;        
        while (n.getEnlace() != null) {                       
            
            n = n.getEnlace();
            
            Nodo x = n;
            
            y.setEnlace(x
            );
            
            y = y.getEnlace();
        }
        return clon;
    }
    
    @Override
    public String toString() {
        String s = "";
        
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
