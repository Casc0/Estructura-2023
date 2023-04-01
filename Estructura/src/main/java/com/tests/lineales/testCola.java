package com.tests.lineales;

import com.lineales.dinamicas.Cola;


public class testCola {

    public static void main(String[] args) {
        Cola colita = new Cola();
        int i;
        System.out.println(colita.toString());
        System.out.println(colita.esVacia());
        for(i = 1; i < 13; i++){
            colita.poner(i);
        }
        System.out.println(colita.toString());
        
        System.out.println(colita.sacar());
        System.out.println(colita.obtenerFrente());
        
        Cola clon = colita.clone();
        
        System.out.println(clon.toString());
        
        
        

    }
}
