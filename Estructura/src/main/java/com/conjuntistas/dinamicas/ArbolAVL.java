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

    private void rotacionDer(NodoAVL padre, NodoAVL r) {
        System.out.println("rotacion derecha");
        NodoAVL h = r.getIzquierdo();
        if (calcularBalance(h) < 0) {
            rotacionIzq(r, h);
            h = r.getIzquierdo();
        }
        NodoAVL aux = h.getDerecho();

        r.setIzquierdo(null);
        if (r == padre.getDerecho()) {
            padre.setDerecho(h);
        } else {
            padre.setIzquierdo(h);
        }
        h.setDerecho(r);
        r.setIzquierdo(aux);

    }

    private void rotacionIzq(NodoAVL padre, NodoAVL r) {
        System.out.println("rotacion izquierda");
        
        NodoAVL h = r.getDerecho();
        if (calcularBalance(h) > 0) {
            rotacionDer(r, h);
            h = r.getDerecho();
        }
        NodoAVL aux = h.getIzquierdo();

        if (r == padre.getDerecho()) {
            padre.setDerecho(h);
        } else {
            padre.setIzquierdo(h);
        }
        h.setIzquierdo(r);
        r.setDerecho(aux);
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
