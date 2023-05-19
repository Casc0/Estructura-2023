package com.jerarquicas.dinamicas;

import com.jerarquicas.dinamicas.NodoArbol;
import com.lineales.dinamicas.Lista;
import com.lineales.dinamicas.Cola;

public class ArbolBin {

    NodoArbol raiz;

    public ArbolBin() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /*Inserta a elemNuevo como hijo del primer nodo encontrado en preOrden igual a elemPadre
        como hijo izquierdo(I) o derecho(D) segun el caracter ingresado en lugar
         */

        boolean exito = true;

        if (raiz == null) {
            //si el arbol esta vacio, elemNuevo se asigna como raiz
            raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //si el arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(raiz, elemPadre);

            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));

                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));

                } else {
                    exito = false;
                }
            }
        }

        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene
        Si no se encuentra buscado devuelve null */

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en el HI, busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        boolean vacia = false;
        if (raiz == null) {
            vacia = true;
        }
        return vacia;
    }

    public Object padre(Object elem) {
        //Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primera aparición de elemento)
        Object elemPadre = null;
        if (elem != null) {
            elemPadre = obtenerNodoPadre(raiz, elem);
        }

        return elemPadre;
    }

    private NodoArbol obtenerNodoPadre(NodoArbol n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene en sus hijos
        Si no se encuentra buscado devuelve null */

        NodoArbol resultado = null;
        if (n != null) {
            NodoArbol izq = n.getIzquierdo();
            NodoArbol der = n.getDerecho();
            if ((izq != null && izq.getElem().equals(buscado)) || (der != null && der.getElem().equals(buscado))) {
                //si el buscado es uno de los hijos de n, lo devuelve
                resultado = n;
            } else {
                //el buscado no es ninguno de los hijos: busca primero en el HI
                resultado = obtenerNodoPadre(izq, buscado);
                //si no lo encontro en el HI, busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodoPadre(der, buscado);
                }
            }
        }
        return resultado;
    }

    public int altura() {
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja un árbol vacío tiene altura - 1 y una hoja tiene altura 0)
        int alt = -1;

        //si el arbol esta vacio devuelve -1
        if (raiz != null) {
            //si el arbol es una hoja devuelve 0
            if (raiz.getDerecho() == null && raiz.getIzquierdo() == null) {
                alt = 0;
            } else {
                alt = auxAltura(raiz);
            }
        }
        return alt;
    }

    private int auxAltura(NodoArbol n) {
        int alt = 0, altI, altD;
        if (n != null) {

            altI = auxAltura(n.getIzquierdo()) + 1;
            altD = auxAltura(n.getDerecho()) + 1;
            alt = Math.max(altI, altD);
        }
        return alt;
    }

    public int nivel(Object elem) {
        //Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol devuelve -1
        int niv = -1;

        //si el arbol esta vacio devuelve -1
        if (raiz != null && elem != null) {
            //si el arbol es una hoja devuelve 0
            niv = auxNivel(raiz, elem, 0);
        }

        return niv;
    }

    private int auxNivel(NodoArbol nodo, Object elem, int iterador) {
        int nivel = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = iterador;
            } else {
                NodoArbol izq = nodo.getIzquierdo(), der = nodo.getDerecho();

                if (nivel == -1) {
                    nivel = auxNivel(izq, elem, iterador + 1);
                }

                if (nivel == -1) {
                    nivel = auxNivel(der, elem, iterador + 1);
                }
            }

        }
        return nivel;
    }

    public void vaciar() {
        raiz = null;
    }

    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPreOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud());
            //recorre a sus hijos en preOrden
            listarPreOrdenAux(nodo.getIzquierdo(), lis);
            listarPreOrdenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        Lista lis = new Lista();
        listarPosOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPosOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            //recorre a sus hijos en posOrden
            listarPosOrdenAux(nodo.getIzquierdo(), lis);
            listarPosOrdenAux(nodo.getDerecho(), lis);
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud());
        }
    }

    public Lista listarInorden() {
        Lista lis = new Lista();
        listarInOrdenAux(raiz, lis);
        return lis;
    }

    private void listarInOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            //recorre a sus hijo en inOrden
            listarInOrdenAux(nodo.getIzquierdo(), lis);
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud());

            listarInOrdenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarNiveles() {
        Lista listita = new Lista();
        Cola colita = new Cola();
        NodoArbol nodo = raiz;

        return listita;
    }
//    
//    @Override
//    public ArbolBin  clone(){
//        
//    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoArbol n) {
        String arbol = "";
        if (n != null) {
            arbol = n.getElem().toString();
            if (n.getIzquierdo() != null) {
                arbol = arbol + " HI:" + n.getIzquierdo().getElem();
            } else {
                arbol = arbol + " HI: - ";
            }
            if (n.getDerecho() != null) {
                arbol = arbol + " HD:" + n.getDerecho().getElem() + "\n";
            } else {
                arbol = arbol + " HD: - " + "\n";
            }
            arbol = arbol + toStringAux(n.getIzquierdo());
            arbol = arbol + toStringAux(n.getDerecho());
        }
        return arbol;
    }

}
