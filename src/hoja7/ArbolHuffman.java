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

    public ArbolHuffman(){
        
    }
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
    
    public ArbolHuffman obtenerArbol(int[] vec){
        Heap<ArbolHuffman> heap = new Heap<ArbolHuffman>();
        for (int i = 0; i < vec.length; i++)
            if (vec[i]>0)
                heap.add(new ArbolHuffman(vec[i], (char)i));
        while(heap.getSize()>1){
            ArbolHuffman arbol1 = heap.remove();
            ArbolHuffman arbol2 = heap.remove();
            heap.add(new ArbolHuffman(arbol1,arbol2));
        }
        
        return heap.remove();
    }
    
    public int[] frequencia(String texto){
        int[] vec = new int[256];  
        for (int i = 0; i < texto.length(); i++)
            vec[(int)texto.charAt(i)]++;
        return vec;
    }
    
    public void asignarCodigo(Nodo r, String[] codigo){
        if(r.izquierda!=null){
            r.izquierda.codigo = r.codigo + "0";
            asignarCodigo(r.izquierda,codigo);
            r.derecha.codigo = r.codigo + "1";
            asignarCodigo(r.derecha,codigo);
        }
        else
            codigo[(int)r.elemento]=r.codigo;
    }
    
    
    
}
