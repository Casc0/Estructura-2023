package com.conjuntistas.dinamicas;

public class ArbolABB {

    private NodoABB raiz;

    public ArbolABB() {
        raiz = null;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;

        if (raiz == null) {
            raiz = new NodoABB(elem, null, null);
        } else {
            exito = insertarAux(raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elem) {
        //precondicion: n no es nulo
        boolean exito = true;
        Object elemNodo = nodo.getElem();
        if (elem.compareTo(elemNodo) == 0) {
            //error, elemento repetido
            exito = false;
        } else if (elem.compareTo(elemNodo) < 0) {
            //elemento es menor que elemNodo
            //si tiene HI baja a la izquierda, sino agrega elemento
            if (nodo.getIzquierdo() != null) {
                exito = insertarAux(nodo.getIzquierdo(), elem);
            } else {
                nodo.setIzquierdo(new NodoABB(elem, null, null));
            }
        } else {
            //elemento es mayor que elemNodo
            //si tiene HD baja a la derecha, sino agrega elemento
            if (nodo.getDerecho() != null) {
                exito = insertarAux(nodo.getDerecho(), elem);
            } else {
                nodo.setDerecho(new NodoABB(elem, null, null));
            }

        }
        return exito;
    }
    
    public boolean eliminar(Comparable elemento) {
        boolean exito = false;
        NodoABB padre;
        if (this.raiz != null) {
            if (this.raiz.getElem().compareTo(elemento) == 0) {
                this.raiz = eliminarAux(this.raiz);
                exito = true;
            } else {
                padre = encontrarPadre(this.raiz, elemento);
                if (padre != null) {
                    if (padre.getIzquierdo() != null && elemento.compareTo(padre.getIzquierdo().getElem()) == 0) {
                        padre.setIzquierdo(eliminarAux(padre.getIzquierdo()));
                    } else {
                        padre.setDerecho(eliminarAux(padre.getDerecho()));
                    }
                    exito = true;
                }
            }
        }
        return exito;
    }

    private NodoABB eliminarAux(NodoABB n) {
        // Ingresa el nodo que deseo eliminar
        NodoABB HD = null, HI = null, candidato = null, padre, aux;
        if (n != null) {
            HD = n.getDerecho();
            HI = n.getIzquierdo();
            // Caso 1 no tiene hijos RETORNA NULL
            if (HI != null && HD == null) { // CASO 2
                // SOLO tiene hijo izquierdo el que quiero eliminar CASO 2
                candidato = HI;
            } else if (HI == null && HD != null) { // CASO 2
                // SOLO tiene hijo derecho el que quiero eliminar CASO 2
                candidato = HD;
            } else if (HI != null && HD != null) { // CASO 3
                // CASO 3 porque tiene ambos hijos
//                candidato = encontrarMinimo(HD); // CANDIDATO
//                n.setElem(candidato.getElem());  // Almacena el CANDIDATO en el que deseo eliminar
//                
//                // El CANDIDATO solo tendra hijo DERECHO o NINGUNO
//                // Seteo como izquierdo de HD el elemento de la recursion 
//                aux = eliminarAux(candidato);
//                if (aux == null) {
//                    n.setDerecho(aux);
//                } else{
//                    HD.setIzquierdo(aux);
//                }
//                candidato = n;
                //Entonces seteo como hijo izquierdo de HD la recursion de eliminarse el de su subarbol
                System.out.println("hijo derecho " + HD.getElem());
                padre = encontrarMinimoPadre(HD);
                if (padre != null) {
                    System.out.println("padre " + padre.getElem());
                    n.setElem(padre.getIzquierdo().getElem());
                    padre.setIzquierdo(eliminarAux(padre.getIzquierdo()));
                } else {
                    n.setElem(n.getDerecho().getElem());
                    n.setDerecho(eliminarAux(HD));
                }
                candidato = n;
            }
        }
        return candidato;
    }

    private NodoABB encontrarPadre(NodoABB n, Comparable elemento) {
        // Si se manda el elemento y es igual al elemento del nodo 
        NodoABB padre = null, hijo;
        int comparar = 0;
        if (n != null) {
            comparar = elemento.compareTo(n.getElem());
            if (comparar > 0) {
                hijo = n.getDerecho();
                // El elemento se encuentra en la parte derecha del arbol porque es mayor a n
                if (hijo != null && hijo.getElem().compareTo(elemento) == 0) {
                    padre = n;
                } else {
                    padre = encontrarPadre(n.getDerecho(), elemento);
                }
            } else if (comparar < 0) {
                hijo = n.getIzquierdo();
                // El elemento se encuentra en la parte izquierda del arbol porque es menor a n
                if (hijo != null && hijo.getElem().compareTo(elemento) == 0) {
                    padre = n;
                } else {
                    padre = encontrarPadre(n.getIzquierdo(), elemento);
                }
            }
        }
        return padre;
    }
    
    private NodoABB encontrarMinimoPadre(NodoABB nRaiz) {
        NodoABB min = nRaiz;

        if (min.getIzquierdo() == null) {
            min = null;
        } else {
            while (min.getIzquierdo() != null && min.getIzquierdo().getIzquierdo() != null) {
                min = min.getIzquierdo();
            }
        }
        return min;
    }

    public boolean esVacio() {
        boolean vacio = true;
        if (raiz == null) {
            vacio = false;
        }
        return vacio;
    }

    public void vaciar() {
        raiz = null;
    }
}
