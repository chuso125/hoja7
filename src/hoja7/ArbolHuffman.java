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
public class ArbolHuffman implements Comparable<ArbolHuffman> {
    Nodo raiz;

    public ArbolHuffman(int p, char e){
        raiz = new Nodo(e,p);
    }
    
    public ArbolHuffman(ArbolHuffman arbol1, ArbolHuffman arbol2){
        raiz = new Nodo();
        raiz.izquierda = arbol1.raiz;
        raiz.derecha = arbol2.raiz;
        raiz.peso = arbol1.raiz.peso + arbol2.raiz.peso;
    }

    @Override
    public int compareTo(ArbolHuffman o) {
        if(raiz.peso< o.raiz.peso)
            return 1;
        else if (raiz.peso==o.raiz.peso)
            return 0;
        else 
            return -1;
    }
    
}
