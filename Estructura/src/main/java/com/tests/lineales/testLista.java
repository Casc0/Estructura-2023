
package com.tests.lineales;
import com.lineales.dinamicas.Lista;

public class testLista {
    
    public static void main(String[] args) {
        Lista listita = new Lista();
        int j;
        System.out.println(listita.toString());
        System.out.println(listita.esVacia());
        System.out.println(listita.longitud());
        
        
        for(j = 1; j < 6; j++){
            listita.insertar(j, j);
        }
        System.out.println(listita.toString());
        
        
        
        int longi = listita.longitud();
	        for (int i = -1; i <= longi + 2; i++) {
	            if (i > 0 && i <= longi) {
	                System.out.println("Recupera " + i + " \tespera " + i + " retorna " + listita.recuperar(i) + ":\t\t" + (((int) listita.recuperar(i) == i) ));
	            } else {
	                System.out.println("Recupera " + i + " \tespera NULL retorna " + listita.recuperar(i) + ":\t" + ((listita.recuperar(i) == null)));
	            }
	        }
        
        
        
        
        
    }    
        
    
}
