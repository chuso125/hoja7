/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja7;

/**
 *
 * @author Colegio
 */
import java.util.*; 
/**
 *
 * @author Colegio
 */
public class Heap<E extends Comparable<E>> {
    ArrayList<E> lista = new ArrayList<E>(); 
    public Heap() {}
    
    public Heap(E[] objects) {
        int i; 
        for (i = 0; i < objects.length; i++)
            agregar(objects[i]); 
    }
    
    public void agregar(E newObject) {
        lista.add(newObject); 
        int cIndex = lista.size() -1;
        
        while (cIndex > 0) {
            int indexPadre = (cIndex - 1)/2;
            if ((lista.get(cIndex).compareTo(lista.get(indexPadre))) > 0) {
                E temp = lista.get(cIndex); 
                lista.set(cIndex,lista.get(indexPadre)); 
                lista.set(indexPadre,temp); 
            }
            else 
                break; //El Arbol ya es un heap; 
            cIndex = indexPadre; 
        }         
    }
    
    public E remove() {
        if (lista.isEmpty()) return null; 
        E obj = lista.get(0); 
        lista.set(0,lista.get(lista.size()-1)); 
        lista.remove(lista.size()-1);
        int cIndex = 0; 
        while (cIndex < lista.size()) {
            int hijoIzquierdo = 2 * cIndex +1; 
            int hijoDerecho = 2 * cIndex +2; 
            if (hijoIzquierdo >= lista.size()) break; 
            int max = hijoIzquierdo; 
            if (hijoDerecho < lista.size()) {
                if ((lista.get(max).compareTo(lista.get(hijoDerecho))) < 0) {
                    max = hijoDerecho; 
                }
            }
            if (lista.get(cIndex).compareTo(lista.get(max)) < 0) {
                E temp = lista.get(max); 
                lista.set(max, lista.get(cIndex)); 
                lista.set(cIndex, temp); 
                cIndex = max; 
            }
            else break;
        }
        return obj; 
    }
    
    public int getSize() {
        return lista.size(); 
    }
}
