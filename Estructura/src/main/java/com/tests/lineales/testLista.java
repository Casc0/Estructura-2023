
package com.tests.lineales;
import com.lineales.dinamicas.Lista;

public class testLista {
    
    public static void main(String[] args) {
        Lista listita = new Lista();
        int i;
        System.out.println(listita.toString());
        System.out.println(listita.esVacia());
        System.out.println(listita.longitud());
        
        
        for(i = 1; i < 13; i++){
            listita.insertar(i, i);
        }
        System.out.println(listita.toString());
        
        System.out.println(listita.eliminar(6));
        
        Lista clon = listita.clone();
        
        clon.eliminar(6);
        
        System.out.println(clon.toString());
        
        listita.eliminar(listita.localizar(2));
        
        System.out.println(listita.insertar(23, 24));
        
        System.out.println(listita.insertar(23, 4));
        System.out.println(listita.recuperar(4));
        
        
        
        
        
    }    
        
    
}
