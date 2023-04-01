package com.lineales.estaticas;

public class Pila{

    private static final int tamanio = 20;
    private int tope;
    private Object[] arreglo;

    public Pila(){
        arreglo = new Object[tamanio];
        tope = -1;
    }

    public boolean apilar(Object obj){
        //devuelve true o false si se pudo añadir el elemento al final de la pila.
        boolean sePudo;

        if(tope+1 < tamanio){
            tope++;
            arreglo[tope] = obj;
            sePudo = true;
        } else sePudo = false;

        return sePudo;
    }

    public boolean desapilar(){
        //quita el ultimo elemento de la pila y mueve el tope

        boolean sePudo;

        if(tope != -1){
            arreglo[tope] = null;
            tope--;
            sePudo = true;
        } else sePudo = false;

        return sePudo;
    }

    public Object obtenerTope(){
        //devuelve el elemento en el tope
        Object obj;
        if(tope != -1){
            obj = arreglo[tope];
        } else obj = null;
        return obj;
    }

    public boolean esVacio(){
        //si el tope esta fuera de rango es que no tiene elementos la pila
        boolean vacio = false;
        if (tope == -1){
            vacio = true;
        }

        return vacio;
    }

    public void vaciar(){
        //vacia la pila
        int i;
        for(i = 0; i <= tope; i++){
           arreglo[i]=null;
        }
        tope = -1;
    }

    public Pila clone(){
        Pila clon = new Pila();
        clon.arreglo = this.arreglo.clone();
        clon.tope = this.tope;
        return clon;
    }




    public String toString(){
        int i;
        String cad ;
        if(tope == -1){
            cad = "[Pila vacia]";
        }else {
            cad = "[";
            for(i = 0; i < tope; i++){
                cad = cad + arreglo[i] + ", ";
            }
            cad = cad + arreglo[i] + "]";

        }
        return cad;
    }





}
