package com.tests.jerarquicas;

import com.jerarquicas.dinamicas.ArbolGen;
import com.lineales.dinamicas.Lista;

public class TestGenerico {

    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        Lista l1 = new Lista();
        l1.insertar(2, 1);
        l1.insertar(3, 1);
        l1.insertar(7, 1);
        l1.insertar(4, 1);
        l1.insertar(8, 1);
        System.out.println("sonFrontera con arbol vacio, devuelve false: " + arbol.sonFrontera(l1));
        arbol.insertar(1, 2);
        arbol.insertar(4, 1);
        arbol.insertar(3, 1);
        arbol.insertar(2, 1);
        arbol.insertar(5, 4);
        arbol.insertar(8, 5);
        arbol.insertar(7, 5);

        System.out.println("son frontera con todas las hojas y un elemento extra, devuelve true: " + arbol.sonFrontera(l1));
        l1.eliminar(1);
        System.out.println("son frontera con una hoja ausente, devuelve false: " + arbol.sonFrontera(l1));
        l1.vaciar();
        System.out.println("sonFrontera con lista vacia, devuelve false: " + arbol.sonFrontera(l1));

        ArbolGen arbol2 = new ArbolGen();
        arbol2.insertar(1, 2);
        arbol2.insertar(4, 1);
        arbol2.insertar(3, 1);
        arbol2.insertar(2, 1);
        arbol2.insertar(5, 4);
        arbol2.insertar(8, 5);
        arbol2.insertar(7, 5);
        
        System.out.println("Compara dos arboles iguales devuelve true: "+arbol.equals(arbol2));
        arbol2.insertar(7,1);
        System.out.println("Compara dos arboles diferentes devuelve false: "+arbol.equals(arbol2));
        arbol.vaciar();
        System.out.println("Compara con un arbol vacio devuelve false: "+arbol.equals(arbol2));
        arbol2.vaciar();
        System.out.println("Compara dos arboles vacios devuelve true: "+arbol.equals(arbol2));
        
        System.out.println(arbol.padre(5));
    }
}
