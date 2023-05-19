package com.jerarquicas.dinamicas;

import com.lineales.dinamicas.Cola;
import com.lineales.dinamicas.Lista;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        /*Dado un elemento elemNuevo y un elemento elemPadre, agrega elemNuevo como hijo de la primer
        aparición de elemPadre. Para que la operación termine con éxito debe existir un nodo en el árbol con
        elemento = elemPadre. No se establece ninguna preferencia respecto a la posición del hijo respecto a sus
        posibles hermanos. Esta operación devuelve verdadero cuando se pudo agregar elemNuevo a la estructura
        y falso en caso contrario.
         */

        boolean exito = false;

        if (raiz == null) {
            //si el arbol esta vacio, elemNuevo se asigna como raiz
            raiz = new NodoGen(elemNuevo, null, null);
            exito = true;
        } else {
            //si el arbol no esta vacio, busca al padre
            NodoGen nPadre = obtenerNodo(raiz, elemPadre);

            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                nPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, nPadre.getHijoIzquierdo()));
                exito = true;

            }
        }

        return exito;

    }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene
        Si no se encuentra buscado devuelve null */

        NodoGen resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //n no es el buscado: busca primero en el HI y de ahi en sus hermanos hasta encontrar
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    resultado = obtenerNodo(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
                }

            }
        }
        return resultado;
    }

    public boolean pertenece(Object elem) {
        boolean esta = false;
        if (elem != null && raiz != null) {
            if (obtenerNodo(raiz, elem) != null) {
                esta = true;
            }
        }
        return esta;
    }

    public Lista ancestros(Object elem) {
        Lista l1 = new Lista();
        obtenerAncestros(raiz, l1, elem);
        return l1;
    }

    private boolean obtenerAncestros(NodoGen n, Lista l1, Object elem) {
        boolean aux = false;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                aux = true;
            } else {
                l1.insertar(n.getElem(), l1.longitud() + 1);
                NodoGen hijo = n.getHijoIzquierdo();

                while (hijo != null && aux == false) {
                    aux = obtenerAncestros(hijo, l1, elem);
                    hijo = hijo.getHermanoDerecho();
                }
                if (aux == false) {
                    l1.eliminar(l1.longitud());
                }
            }

        }
        return aux;

    }

    public int altura() {
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja un árbol vacío tiene altura - 1 y una hoja tiene altura 0)
        int alt = -1;

        //si el arbol esta vacio devuelve -1
        if (raiz != null) {
            //si el arbol es una hoja devuelve 0
            if (raiz.getHijoIzquierdo() == null) {
                alt = 0;
            } else {
                alt = auxAltura(raiz);
            }
        }
        return alt;
    }

    private int auxAltura(NodoGen n) {
        int alt = -1;
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                alt = Math.max(alt, auxAltura(hijo));
                hijo = hijo.getHermanoDerecho();
            }
            alt++;
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

    private int auxNivel(NodoGen nodo, Object elem, int iterador) {
        int nivel = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = iterador;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && nivel == -1) {
                    nivel = auxNivel(hijo, elem, iterador + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return nivel;
    }

    public Object padre(Object elem) {
        //Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primera aparición de elemento)
        Object elemPadre = null;
        if (elem != null && raiz != null) {
            if (!raiz.getElem().equals(elem)) {
                //consigue el nodo padre o nulo si no existe el elemento dentro del arbol
                NodoGen nodo = obtenerNodoPadre(raiz, elem);
                //si es nulo, no puede usar el getElem
                if (nodo != null) {
                    elemPadre = nodo.getElem();
                }
            }

        }

        return elemPadre;
    }

    private NodoGen obtenerNodoPadre(NodoGen n, Object buscado) {
        /* metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene en sus hijos
        Si no se encuentra buscado devuelve null */

        NodoGen resultado = null;
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null && resultado == null) {
                if (hijo.getElem().equals(buscado)) {
                    //si el buscado es el hijo de n, lo devuelve
                    resultado = n;
                } else {
                    resultado = obtenerNodoPadre(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
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

    public void vaciar() {
        raiz = null;
    }

    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPreOrdenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            //recorre a sus hijos en preOrden
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPreOrdenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }

        }
    }

    public Lista listarPosorden() {
        Lista lis = new Lista();
        listarPosOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPosOrdenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {

            //recorre a sus hijos en posOrden
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPosOrdenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

        }
    }

    public Lista listarInorden() {
        Lista lis = new Lista();
        listarInOrdenAux(raiz, lis);
        return lis;
    }

    private void listarInOrdenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            //recorre a sus hijo izquierdo en inOrden
            listarInOrdenAux(hijo, lis);
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            if (hijo != null) {
                hijo = hijo.getHermanoDerecho();
                while (hijo != null) {
                    listarInOrdenAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarNiveles() {
        Lista lis = new Lista();
        Cola colita = new Cola();
        //listarNivelesAux(raiz, colita, lis);
        colita.poner(raiz);
        while (!colita.esVacia()) {
            NodoGen nodo = (NodoGen) colita.obtenerFrente();
            colita.sacar();
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                colita.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }

        return lis;
    }

    public boolean sonFrontera(Lista hojas) {
        boolean esFrontera = false;
        if (raiz != null && !hojas.esVacia()) {
            esFrontera = fronteraAux(raiz, hojas);
        }
        return esFrontera;
    }

    private boolean fronteraAux(NodoGen nodo, Lista lis) {
        boolean esFrontera = true;
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            if (hijo == null) {
                esFrontera = lis.localizar(nodo.getElem()) > 0;
            } else {
                while (hijo != null && esFrontera) {
                    esFrontera = fronteraAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return esFrontera;
    }

    @Override
    public String toString() {
        return toStringAux(raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            //visita el nodo n
            s += n.getElem().toString() + "->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ",";
                hijo = hijo.getHermanoDerecho();
            }

            //comienza recorrido de los hijos de n llamando recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    @Override
    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        if (raiz != null) {
            clon.raiz = cloneAux(raiz);
        }
        return clon;
    }

    private NodoGen cloneAux(NodoGen nodo) {
        NodoGen nodoClon = null, hijo, hijoClon;
        if (nodo != null) {
            //se crea el nodo
            nodoClon = new NodoGen(nodo.getElem(), null, null);

            //se consigue el hijo del nodo original
            hijo = nodo.getHijoIzquierdo();

            //se crea un clon del hijo
            hijoClon = cloneAux(hijo);

            //se setea el hijo izquierdo del nodo clon
            nodoClon.setHijoIzquierdo(hijoClon);
            //mientras existan hermanos en el original, se setean como hermanos en el hijo izquierdo del nodoClon. 
            while (hijo != null) {
                hijo = hijo.getHermanoDerecho();
                hijoClon.setHermanoDerecho(cloneAux(hijo));
                hijoClon = hijoClon.getHermanoDerecho();
            }
        }
        return nodoClon;
    }

    public boolean equals(ArbolGen unArbol) {
        boolean igual = false;
        if (raiz != null && unArbol.raiz != null) {
            igual = equalsAux(raiz, unArbol.raiz);
        } else if (raiz == null & unArbol.raiz == null) {
            igual = true;
        }
        return igual;
    }

    private boolean equalsAux(NodoGen nodo, NodoGen nodoComparar) {
        boolean igual = true;
        if (nodo != null && nodoComparar != null) {
            if (!(nodo.getElem().equals(nodoComparar.getElem()))) {
                igual = false;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                NodoGen hijoComparar = nodoComparar.getHijoIzquierdo();

                igual = equalsAux(hijo, hijoComparar);

                while (hijo != null && hijoComparar != null && igual) {
                    hijo = hijo.getHermanoDerecho();
                    hijoComparar = hijoComparar.getHermanoDerecho();
                    igual = equalsAux(hijo, hijoComparar);

                }
            }
        } else if ((nodo == null && nodoComparar != null) || (nodo != null && nodoComparar == null)) {
            igual = false;
        }

        return igual;
    }

}
