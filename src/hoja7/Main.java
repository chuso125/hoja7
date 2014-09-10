/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja7;

import java.util.Scanner;

/**
 *
 * @author manuelgomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        ArbolHuffman arbol = new ArbolHuffman();
        System.out.print("Ingrese su texto: ");
        String texto = entrada.nextLine();
        
        int[] vec = arbol.frequencia(texto); 
  
       System.out.printf("%s%s%s\n","Caracter", "Frequencia", "Codigo");  
       
       arbol = arbol.obtenerArbol(vec); 
       String[] codigo = new String[256];
       arbol.asignarCodigo(arbol.raiz, codigo);
           
       for (int i = 0; i < codigo.length; i++)
         if (vec[i] != 0) 
           System.out.printf("%s%d%s\n", (char)i + "",vec[i], codigo[i]);
    }
    
}
