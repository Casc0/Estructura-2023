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
        System.out.println("Arbol: "+arbol.toString());
System.out.println(arbol.padre(5));
        Lista listita= new Lista();
        listita.insertar(4, 1);
        listita.insertar(5,2);
        boolean n=arbol.corroborarCamino(listita);
        System.out.println(arbol.corroborarCamino(listita));
        listita.insertar(67,1);
        System.out.println(arbol.corroborarCamino(listita));
        listita.eliminar(1);
        System.out.println(arbol.toString());
        listita.insertar(8,3);
        System.out.println(arbol.corroborarCamino(listita));
        System.out.println(listita.toString());
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
        
        ArbolGen prueba= new ArbolGen();
        prueba.insertar(20, 9);
        prueba.insertar(13,20);
        prueba.insertar(54, 20);
        prueba.insertar(15,13);
        prueba.insertar(12,13);
        prueba.insertar(11,54);
        prueba.insertar(5,11);
        prueba.insertar(27,54);
        prueba.insertar(4,54);
        prueba.insertar(11,54);
        prueba.insertar(17,27);
        System.out.println(prueba.toString());
        Lista asd= new Lista();
        asd.insertar(5,1);
        asd.insertar(11,1);
        System.out.println(asd.toString());
        System.out.println("devuelve true: "+prueba.corroborarCamino(asd));
        asd.insertar(54, 1);
        System.out.println(asd.toString());
        System.out.println("devuelve true: "+prueba.corroborarCamino(asd));
        asd.eliminar(3);
        System.out.println(asd.toString());
        System.out.println("devuelve true: "+prueba.corroborarCamino(asd));
        asd.insertar(5,3);
        asd.eliminar(2);
        System.out.println(asd.toString());
        System.out.println("devuelve false: "+prueba.corroborarCamino(asd));
   
    }
}
