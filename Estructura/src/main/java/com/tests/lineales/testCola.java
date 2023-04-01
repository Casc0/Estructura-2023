package com.tests.lineales;

import com.lineales.dinamicas.Cola;


public class testCola {

    public static void main(String[] args) {
        Cola fila = new Cola();
        int i;
        System.out.println(fila.toString());
        System.out.println(fila.esVacia());
        for(i = 1; i < 13; i++){
            fila.poner(i);
        }
        System.out.println(fila.toString());
        
        System.out.println(fila.sacar());
        System.out.println(fila.obtenerFrente());
        
        Cola clon = fila.clone();
        
        System.out.println(clon.toString());
        
        
        

    }
}
