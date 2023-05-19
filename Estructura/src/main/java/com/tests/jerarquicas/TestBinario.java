
package com.tests.jerarquicas;
import com.jerarquicas.dinamicas.ArbolBin;

public class TestBinario {
    public static void main(String[] args) {
        ArbolBin a = new ArbolBin();
        
        System.out.println("Inserto el 10 en raiz " + ((a.insertar(10, 1, 'I')) ));
        System.out.println("Inserto el 9 como hijo I de 10: " + ((a.insertar(9, 10, 'I'))));
        System.out.println("Inserto el 7 como hijo I de 9 " + ((a.insertar(7, 9, 'I'))));
        System.out.println("Inserto el 3 como hijo D de 9 " + ((a.insertar(3, 9, 'D'))));
        System.out.println("Inserto el 15 como hijo D de 10 " + ((a.insertar(15, 10, 'D'))));
        System.out.println("Inserto el 12 como hijo I de 15 " + ((a.insertar(12, 15, 'I'))));
        System.out.println("Inserto el 20 como hijo D de 15 " + ((a.insertar(20, 15, 'D'))));
    
        System.out.println(a.toString());
        System.out.println(a.nivel(7));
    
    }
    
    
}
