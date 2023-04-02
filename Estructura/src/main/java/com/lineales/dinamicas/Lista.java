package com.lineales.dinamicas;

public class Lista {

    private Nodo cabecera;

    public Lista() {
        cabecera = null;
    }

    public boolean insertar(Object obj, int pos) {
        boolean exito = true;
        if (pos < 1 || this.longitud() + 1 < pos) {
            exito = false;
        } else {
            if (pos == 1) { //crea un nuevo nodo y enlaza la cabecera
                cabecera = new Nodo(obj, cabecera);
            } else { //avanza hasta el nodo en pos - 1
                Nodo aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(obj, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }

        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (pos < 1 || this.longitud() < pos) {
            exito = false;
        } else {
            if (pos == 1) { //crea un nuevo nodo y enlaza la cabecera
                cabecera = cabecera.getEnlace();
            } else { //avanza hasta el nodo en pos - 1
                Nodo aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }

        return exito;
    }

    public Object recuperar(int pos) {
        //es precondicion que la posicion sea valida
        int i = 1;
        Nodo iterador = cabecera;
        boolean encontro = false;
        Object obj = null;
        if (cabecera != null) {
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            while (iterador.getEnlace() != null && !encontro){

                if (pos == i) {
                    encontro = true;
                    obj = iterador.getElem();
                } else {
                    iterador = iterador.getEnlace();
                    i++;
                }

            } 
        }

        return obj;
    }

    public int localizar(Object elem) {
        int pos = 0;
        Nodo iterador = cabecera;
        boolean encontro = false;
        if (cabecera != null || pos >= 1 || pos <= this.longitud()) {
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            while (iterador.getEnlace() != null && !encontro){

                if (iterador.getElem() == elem) {
                    encontro = true;
                } else {
                    iterador = iterador.getEnlace();
                    pos++;
                }

            } 
        }
        if (!encontro) {
            pos = -1;
        }

        return pos;

    }

    public int longitud() {
        int pos = 0;
        Nodo iterador = cabecera;
        if (cabecera != null) {
            pos = 1;
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            while(iterador.getEnlace() != null){
                iterador = iterador.getEnlace();
                pos++;
            } 

        }       

        return pos;
    }

    public void vaciar() {
        cabecera = null;
    }

    public boolean esVacia() {
        return (cabecera == null);
    }

    @Override
    public Lista clone() {
    Lista listita = new Lista();
      if(cabecera!=null){
          listita.clonar(cabecera, listita);
      }
      return listita;
    }
    
     private void clonar(Nodo auxOrig, Lista listita){
        
        Nodo auxiliar;
        if(auxOrig.getEnlace() == null){
            auxiliar = new Nodo(auxOrig.getElem(), null);
            listita.cabecera = auxiliar;
            
        }else{
            listita.clonar(auxOrig.getEnlace(), listita);
            auxiliar = new Nodo(auxOrig.getElem(), listita.cabecera);
            listita.cabecera=auxiliar;
            
        }
        
        
    }

    @Override
    public String toString() {
        String s;

        if (cabecera == null) {
            s = "[Pila vacia";
        } else {
            Nodo aux = cabecera;
            s = "[";

            while (aux != null) {
                s = s + aux.getElem();
                aux = aux.getEnlace();

                if (aux != null) {
                    s = s + ", ";
                }
            }
        }
        s = s + "]";
        return s;
    }
}
