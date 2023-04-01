package com.tests.lineales;

import com.lineales.dinamicas.Pila;
import java.util.Scanner;

public class testPila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decision;
        boolean clon = true;
        boolean seguir = true;
        Pila pilita = new Pila();

        while (seguir) {
            System.out.println("Que quiere hacer?");
            System.out.println("1. Apilar una secuencia");
            System.out.println("2. Desapilar un objeto");
            System.out.println("3. Vaciar pila");
            System.out.println("4. Verificar si pila esta vacia");
            System.out.println("5. Ver que hay en la pila");
            System.out.println("6. Obtener el tope de la pila");
            System.out.println("7. Ver el clon");
            System.out.println("8. Terminar");
            decision = sc.nextInt();

            switch (decision) {
                default:
                    System.out.println("Ingreso un numero incorrecto");
                    break;

                case 1:
                    cargarN(pilita);
                    break;

                case 2:
                    pilita.desapilar();
                    break;

                case 3:
                    pilita.vaciar();
                    break;

                case 4:
                    System.out.println(pilita.esVacio());
                    break;

                case 5:
                    System.out.println(pilita.toString());
                    break;

                case 6:
                    System.out.println(pilita.obtenerTope());
                    break;

                case 7:
                    Pila pilota = pilita.clone();
                    System.out.println(pilota.toString());
                    break;

                case 8:
                    seguir = false;
                    break;
            }
        }

        System.out.println("Que tenga buen dia.");

    }

    public static void cargarN(Pila p) {
        int i = 1;
        while (p.apilar(i) && i < 20) {
            i++;
        }
    }

}
