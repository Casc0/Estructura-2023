
package com.lineales.dinamicas;

public class ArbolBin {
    NodoArbol raiz;
    
    public ArbolBin(){
        raiz = null;
    }
    
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar){
        /*Inserta a elemNuevo como hijo del primer nodo encontrado en preOrden igual a elemPadre
        como hijo izquierdo(I) o derecho(D) segun el caracter ingresado en lugar
        */
        
        boolean exito = true;
        
        if(raiz == null){
            //si el arbol esta vacio, elemNuevo se asigna como raiz
            raiz = new NodoArbol(elemNuevo, null, null);
        } else{ 
            //si el arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(raiz, elemPadre);
            
            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null){
                if(lugar =='I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                
                }else if (lugar == 'D' && nPadre.getDerecho() == null){
                   nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                   
                }else exito = false;        
            }
        }
        
        
        return exito;
    }
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        /* metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene
        Si no se encuentra buscado devuelve null */
        
        NodoArbol resultado = null;
        if(n != null){
            if(n.getElem().equals(buscado)){
                //si el buscado es n, lo devuelve
                resultado = n;
            }else{
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en el HI, busca en el HD
                if(resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    
    public boolean esVacio(){
        boolean vacia = false;
        if(raiz == null){
            vacia = true;
        }
        return vacia;
    }
    
    /*
    public Object padre(Object elem){
        //Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primera aparición de elemento)
    
    }
    
    public int altura(){
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja un árbol vacío tiene altura - 1 y una hoja tiene altura 0)
    }
    
    public int nivel(Object elem){
        //Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol devuelve -1
       
    }
    */
    public void vaciar(){
        raiz = null;
    }
}
