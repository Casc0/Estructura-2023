package com.lineales.dinamicas;

public class Lista {

    private Nodo cabecera;

    public Lista() {
        cabecera = new Nodo(null, null);
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
        if (pos < 1 || this.longitud() + 1 < pos) {
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
        int i = 1;
        Nodo iterador = cabecera;
        boolean encontro = false;
        Object obj = null;
        if (cabecera != null || pos >= 1 || pos <= this.longitud()) {
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            do {

                if (pos == i) {
                    encontro = true;
                    obj = iterador.getElem();
                } else {
                    iterador = iterador.getEnlace();
                    i++;
                }

            } while (iterador.getEnlace() != null && !encontro);
        }

        return obj;
    }

    public int localizar(Object elem) {
        int pos = 0;
        Nodo iterador = cabecera;
        boolean encontro = false;
        if (cabecera != null || pos >= 1 || pos <= this.longitud()) {
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            do {

                if (iterador.getElem() == elem) {
                    encontro = true;
                } else {
                    iterador = iterador.getEnlace();
                    pos++;
                }

            } while (iterador.getEnlace() != null && !encontro);
        }
        if (!encontro) {
            pos = -1;
        }

        return pos;

    }

    public int longitud() {
        int pos = -1;
        Nodo iterador = cabecera;
        if (cabecera != null) {
            pos = 1;
            //mientras no sea el ultimo nodo y no se haya encontrado, se itera nodo por nodo.
            do {
                iterador = iterador.getEnlace();
                pos++;
            } while (iterador.getEnlace() != null);

        }

        return pos;
    }

    public void vaciar() {
        cabecera = null;
    }

    public boolean esVacia() {
        return (cabecera == null);
    }

//    @Override
//    public Lista clone() {
//
//    }

    @Override
    public String toString() {
        String s;

        if (cabecera == null) {
            s = "[Pila vacia";
        } else {
            Nodo aux = cabecera;
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
}
