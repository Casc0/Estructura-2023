package com.conjuntistas.dinamicas;

public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public boolean pertenece(Comparable x) {
        boolean esta = false;
        if (raiz != null) {
            esta = buscarElem(raiz, x);
        }
        return esta;
    }

    private boolean buscarElem(NodoAVL n, Comparable x) {
        boolean esta = false;
        if (n != null) {
            int comparacion = x.compareTo(n.getElem());
            if (comparacion == 0) {
                esta = true;
            } else if (comparacion > 0) {
                esta = buscarElem(n.getDerecho(), x);
            } else {
                esta = buscarElem(n.getIzquierdo(), x);
            }
        }

        return esta;
    }

    public boolean insertar(Comparable x) {
        boolean pudo;
        if (raiz == null) {
            raiz = new NodoAVL(x, null, null);
            pudo = true;
            System.out.println("es raiz");
        } else {
            pudo = insertarAux(raiz, x);
            if (pudo) {
                raiz.recalcularAltura();
                rotarRaiz(raiz);
            }
        }
        return pudo;
    }

    private boolean insertarAux(NodoAVL n, Comparable x) {
        boolean exito = false;
        if (n != null) {
            int comparacion = x.compareTo(n.getElem());

            if (comparacion > 0) {
                NodoAVL hijo = n.getDerecho();
                if (hijo != null) {
                    exito = insertarAux(hijo, x);
                } else {
                    n.setDerecho(new NodoAVL(x, null, null));
                    exito = true;
                }
            } else if (comparacion < 0) {
                NodoAVL hijo = n.getIzquierdo();
                if (hijo != null) {
                    exito = insertarAux(hijo, x);
                } else {
                    n.setIzquierdo(new NodoAVL(x, null, null));
                    exito = true;
                }
            }
            if (exito) {
                n.recalcularAltura();
                rotar(n);
            }
        }
        return exito;
    }

    //le llega un nodo, y pregunta si sus hijos estan bien balanceados
    private void rotar(NodoAVL padre) {

        NodoAVL hijoIzq = padre.getIzquierdo(), hijoDer = padre.getDerecho();

        if (hijoIzq != null) {
            int balanceIzq = calcularBalance(hijoIzq);

            if (balanceIzq >= 2) {
                rotacionDer(padre, hijoIzq);
            } else if (balanceIzq <= -2) {
                rotacionIzq(padre, hijoIzq);
            }
        }

        if (hijoDer != null) {
            int balanceDer = calcularBalance(hijoDer);
            if (balanceDer >= 2) {
                rotacionDer(padre, hijoDer);
            } else if (balanceDer <= -2) {
                rotacionIzq(padre, hijoDer);
            }
        }

    }

    private void rotarRaiz(NodoAVL n) {
        int balance = calcularBalance(n);

        if (balance >= 2) {
            rotacionDer(null, n);
        } else if (balance <= -2) {
            rotacionIzq(null, n);
        }

    }

    //devuelve el balance del nodo
    private int calcularBalance(NodoAVL n) {
        int balance = 0;
        NodoAVL hijoIz = n.getIzquierdo(), hijoDer = n.getDerecho();

        if (hijoIz != null && hijoDer != null) {
            balance = hijoIz.getAltura() - hijoDer.getAltura();
        } else if (hijoDer != null) {
            balance = -1 - hijoDer.getAltura();
        } else if (hijoIz != null) {
            balance = hijoIz.getAltura() + 1;
        }
        return balance;
    }

    private void rotacionDer(NodoAVL padre, NodoAVL pivote) {

        //guarda el que va a ser la nueva raiz;
        NodoAVL nuevaRaiz = pivote.getIzquierdo();

        //si el balance de nuevaRaiz es del otro signo, hay que hacer doble rotacion
        if (calcularBalance(nuevaRaiz) < 0) {
            rotacionIzq(pivote, nuevaRaiz);
            nuevaRaiz = pivote.getIzquierdo();
        }
        NodoAVL aux = nuevaRaiz.getDerecho();

        //si padre es nulo es el caso rotacion con raiz;
        if (padre != null) {
            if (pivote == padre.getDerecho()) {
                padre.setDerecho(nuevaRaiz);
            } else {
                padre.setIzquierdo(nuevaRaiz);
            }
        } else {
            raiz = nuevaRaiz;
        }
        pivote.setIzquierdo(aux);
        nuevaRaiz.setDerecho(pivote);

        System.out.println("rotacion derecha");
    }

    private void rotacionIzq(NodoAVL padre, NodoAVL pivote) {

        //guarda el que va a ser la nueva raiz;
        NodoAVL nuevaRaiz = pivote.getDerecho();

        //si el balance de nuevaRaiz es del otro signo, hay que hacer doble rotacion
        if (calcularBalance(nuevaRaiz) > 0) {
            rotacionDer(pivote, nuevaRaiz);
            nuevaRaiz = pivote.getDerecho();
        }
        NodoAVL aux = nuevaRaiz.getIzquierdo();
        //si padre es nulo es el caso rotacion con raiz;
        if (padre != null) {
            if (pivote == padre.getDerecho()) {
                padre.setDerecho(nuevaRaiz);
            } else {
                padre.setIzquierdo(nuevaRaiz);
            }
        } else {
            raiz = nuevaRaiz;
        }

        pivote.setDerecho(aux);
        nuevaRaiz.setIzquierdo(pivote);

        System.out.println("rotacion izquierda Con pivote " + pivote.getElem());
    }

    public boolean eliminar(Comparable x) {
        boolean exito = false;
        if (raiz != null) {
            if (raiz.getElem() != x) {
                exito = eliminarAux(raiz, x);
            } else {
                eliminarlo(null, raiz);
                rotarRaiz(raiz);
            }
        }
        return exito;
    }

    private boolean eliminarAux(NodoAVL n, Comparable x) {
        //n le pregunta a sus hijos si son iguales a x
        boolean exito = false;
        if (n != null) {
            NodoAVL hijoI = n.getIzquierdo(), hijoD = n.getDerecho();
            int comparacion = x.compareTo(n.getElem());

            if (comparacion > 0) {
                if (hijoD != null) {
                    if (hijoD.getElem() == x) {
                        eliminarlo(n, hijoD);
                        exito = true;
                    } else {
                        exito = eliminarAux(hijoD, x);
                    }
                }
            } else if (comparacion < 0) {
                if (hijoI != null) {
                    if (hijoI.getElem() == x) {
                        eliminarlo(n, hijoI);
                        exito = true;
                    } else {
                        exito = eliminarAux(hijoI, x);
                    }
                }
            }
            if (exito) {
                n.recalcularAltura();
                rotar(n);
            }
        }
        return exito;
    }

    private void eliminarlo(NodoAVL padreN, NodoAVL n) {
        NodoAVL hijoI = n.getIzquierdo(), hijoD = n.getDerecho(), aux = null;
        //si n tiene dos hijos, hay que buscar el mayor menor y reemplazar n. Si n tiene un hijo, se setea ese hijo como n, sino se pone null donde estaba n
        if (hijoI != null && hijoD != null) {
            aux = buscarMayorMenor(n);

        } else if (hijoI != null) {
            aux = hijoI;
        } else if (hijoD != null) {
            aux = hijoD;
        }

        //si padreN es null es porque es caso eliminar raiz
        if (padreN == null) {
            raiz = aux;
        } else {
            if (n == padreN.getDerecho()) {
                padreN.setDerecho(aux);
            } else {
                padreN.setIzquierdo(aux);
            }
        }

    }

    private NodoAVL buscarMayorMenor(NodoAVL n) {

        NodoAVL mayorMenor = n.getIzquierdo(), padre = n;
        //se busca el mayor menor solo si el hijoIzq tiene hijo derecho, sino el mayor menor es hijoIzq
        while (mayorMenor.getDerecho() != null) {
            padre = mayorMenor;
            mayorMenor = mayorMenor.getDerecho();
        }
        //si entro en el while, hay que eliminar al mayorMenor del subArbol izquierdo y hay que setearles los hijos de n como suyos, sino solo hay que setearle la rama derecha de n
        if (padre != n) {
            //al padre hay que seterle como nuevo hijo derecho el hijo izquierdo del que va ser eliminado
            padre.setDerecho(mayorMenor.getIzquierdo());
            mayorMenor.setIzquierdo(n.getIzquierdo());
        }
        mayorMenor.setDerecho(n.getDerecho());
        return mayorMenor;
    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoAVL n) {
        String arbol = "";
        if (n != null) {
            arbol += n.getElem().toString();
            arbol += " alt: " + n.getAltura() + " ";
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
