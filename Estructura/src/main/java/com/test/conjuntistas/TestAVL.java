package com.test.conjuntistas;

import com.conjuntistas.dinamicas.ArbolAVL;

public class TestAVL {

    public static void main(String[] args) {
        ArbolAVL a = new ArbolAVL();
        a.insertar(10);
        a.insertar(5);
        a.insertar(20);
        a.insertar(25);

        a.insertar(1);
        a.insertar(8);
        a.insertar(30);
        a.insertar(7);
        System.out.println(a.eliminar(7));
        System.out.println(a.toString());
    }
}
