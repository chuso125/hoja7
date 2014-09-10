/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja7;

/**
 *
 * @author manuelgomez
 */
public class Nodo {
    int peso;
    char elemento ;
    Nodo izquierda, derecha;
    String codigo="";
    public Nodo(){
    }
    
    public Nodo(char c, int p){
        elemento = c;
        peso = p;
    }

    
}
