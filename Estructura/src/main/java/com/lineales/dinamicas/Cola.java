package com.lineales.dinamicas;

public class Cola {

    private Nodo frente, fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean poner(Object elem) {
        Nodo nuevo = new Nodo(elem, null);

        //caso base cuando la cola esta vacia
        if (frente == null) {
            frente = nuevo;

            //sino esta vacia, el enlace de fin es el nuevo nodo    
        } else {
            fin.setEnlace(nuevo);
        }
        fin = nuevo;

        return true;
    }

    public boolean sacar() {
        boolean exito = false;

        if (frente != null) {
            frente = frente.getEnlace();
            exito = true;

            if (frente == null) {
                fin = null;
            }
        }
        return exito;

    }

    public Object obtenerFrente() {
        Object objFrente = null;
        if (frente != null) {
            objFrente = frente.getElem();
        }
        return objFrente;
    }

    public boolean esVacia() {
        return ((frente == null) && (fin == null));
    }

    public void vaciar() {
        frente = null;
        fin = frente;
    }

    @Override
    public String toString() {
        String s = "";

        if (frente == null) {
            s = "[Pila vacia";
        } else {
            Nodo aux = frente;
            s = "[";

            while (aux != null) {
                s = s + aux.getElem().toString();
                aux = aux.getEnlace();

                if (aux != null) {
                    s = s + ", ";
                }
            }
        }
        s = s + "]";
        return s;
    }

    @Override
    public Cola clone(){
      Cola colita = new Cola();
      if(frente!=null){
          colita=clonar(frente, colita);
      }
      return colita;
    }
    
    private Cola clonar(Nodo auxOrig, Cola colita){
        
        Nodo auxiliar;
        if(auxOrig.getEnlace() == null){
            auxiliar = new Nodo(auxOrig.getElem(), null);
            colita.frente = auxiliar;
            colita.fin =  colita.frente;
            
        }else{
            colita.clonar(auxOrig.getEnlace(), colita);
            auxiliar = new Nodo(auxOrig.getElem(), colita.frente);
            colita.frente=auxiliar;
            
        }
        
        return colita;
    }

}
