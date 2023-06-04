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

    public boolean eliminar(Comparable elem) {
        boolean pudo = false;
        NodoABB izq, der, aEliminar;
        if (raiz != null) {
            //si el elemento es la raiz, se elimina
            if (elem.compareTo(raiz.getElem()) == 0) {
                pudo = true;
                dosHijos(null, raiz);
            } else {
                //sino buscamos el padre del elemento, el nodo con el elemento y vemos que tipo de eliminacion es
                NodoABB padre = eliminarAux(raiz, elem);
                if (padre != null) {
                    pudo = true;
                    //si el padre no es nulo, es porque uno de los hijos tiene al elem, por lo que hay averiguar cual hijo es
                    if ((padre.getDerecho() != null) && (padre.getDerecho().getElem().compareTo(elem) == 0)) {
                        aEliminar = padre.getDerecho();
                    } else {
                        aEliminar = padre.getIzquierdo();
                    }

                    //ahora vemos que tipo de eliminacion es
                    izq = aEliminar.getIzquierdo();
                    der = aEliminar.getDerecho();
                    if (izq != null && der != null) {
                        dosHijos(padre, aEliminar);
                    } else if (izq != null || der != null) {
                        unHijo(padre, aEliminar);
                    } else {
                        //caso hoja
                        esHoja(padre, aEliminar);
                    }

                }

            }
        }
        return pudo;
    }

    private NodoABB eliminarAux(NodoABB n, Comparable elem) {
        boolean pudo = false;
        return pudo;
    }

    private void esHoja(NodoABB padre, NodoABB hijo) {
        NodoABB izq = padre.getIzquierdo();
        //comparamos para averiguar en que posicion esta el hijo, y lo seteamos en nulo

        if (hijo == izq) {
            padre.setIzquierdo(null);
        } else {
            padre.setDerecho(null);
        }

    }

    private void unHijo(NodoABB padre, NodoABB hijo) {
        NodoABB izq = padre.getIzquierdo();
        NodoABB nieto;

        //guardamos el nieto
        if (hijo.getIzquierdo() != null) {
            nieto = hijo.getIzquierdo();
        } else {
            nieto = hijo.getDerecho();
        }

        //comparamos para averiguar en que posicion esta el hijo, y lo reemplazamos con su nieto
        if (hijo == izq) {
            padre.setIzquierdo(nieto);
        } else {
            padre.setDerecho(nieto);
        }

    }

    private void dosHijos(NodoABB padre, NodoABB hijo) {
        //hay un caso unico para la raiz
        if (padre == raiz) {
            NodoABB n = n.getDerecho();
            while(){
                
            }
        } else {
            NodoABB izq = padre.getIzquierdo();

            if (hijo == izq) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
        }

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
