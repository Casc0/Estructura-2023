package com.tests.lineales;

import com.lineales.dinamicas.Lista;
import com.lineales.dinamicas.Pila;
import com.lineales.dinamicas.Cola;

public class PruebaLista {

    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();

//        l1.insertar(2, 1);
//        l1.insertar(4, 2);
//        l1.insertar(6, 3);
//
//        l2.insertar(5, 1);
//        l2.insertar(1, 2);
//        l2.insertar(6, 3);
//        l2.insertar(7, 4);
//
//        Lista l3 = concatenar(l1, l2);
//        System.out.println(l3.toString());

        l1.vaciar();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l1.insertar(3, 3);
        l1.insertar(4, 4);
        l1.insertar(5, 5);
        l1.insertar(6, 6);
        l1.insertar(7, 7);
        l1.insertar(8, 8);
        l1.insertar(9, 9);
        l1.insertar(10, 10);
        l1.insertar(11, 11);
        l1.insertar(12, 11);

        System.out.println(l1.toString());
        l1.vaciar();
        System.out.println(l1.obtenerMultiplos(3));
        
        //System.out.println(comprobar(l1));

    }

    public static Lista concatenar(Lista l1, Lista l2) {
        Lista l3 = l1.clone();
        int i, longi, longi2;
        longi = l2.longitud();
        longi2 = l3.longitud();
        //inserta los elementos de la lista 1 en sus posiciones        
        for (i = 1; i <= longi; i++) {
            l3.insertar(l2.recuperar(i), longi2 + i);
        }

        return l3;
    }

    public static boolean comprobar(Lista l1) {
        Lista clon = l1.clone();
        int cero;
        Object primero;
        boolean distinto = true;
        //guarda la cadena en una pila
        Pila inversa = conseguirCadenaPila(clon);
        
        //devuelve la cadena y la elimina de la lista        
        Cola cadena = conseguirCadenaCola(clon);
    
        cero = l1.localizar(0);

        if (cero == -1) {
            distinto = false;
        } else {

            clon.eliminar(cero);
            while (distinto && clon.recuperar(1) != null) {
                primero = clon.recuperar(1);
                if (cadena.obtenerFrente().equals(primero)) {
                    cadena.sacar();
                    clon.eliminar(1);

                } else if (inversa.obtenerTope().equals(primero)){                    
                    inversa.desapilar();
                    clon.eliminar(1);
                } else {                    
                    distinto = false;
                }
            }           
        }
        return distinto;
    }

    public static Cola conseguirCadenaCola(Lista l1) {
        int cero = l1.localizar(0);
        Cola cadena = new Cola();
        int i =1;
        while(i < cero){
            cadena.poner(l1.recuperar(1));
            l1.eliminar(1);
            i++;
        }        
        l1.eliminar(1);
        return cadena;
    }

    public static Pila conseguirCadenaPila(Lista l1) {
        int cero = l1.localizar(0);
        Pila cadena = new Pila();
        for (int j = 1; j < cero; j++) {
            cadena.apilar(l1.recuperar(j));
        }
        return cadena;
    }
}
