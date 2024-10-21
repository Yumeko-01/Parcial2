/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial.pkg2;

import java.util.ArrayList;

public class IHeap<T extends Comparable<T>> implements IHeap<T> {
    private ArrayList<T> elementos;
    private boolean esMaxHeap;

    public Heap(boolean esMaxHeap) {
        this.elementos = new ArrayList<>();
        this.esMaxHeap = esMaxHeap;
    }

    public void add(T elemento) {
        elementos.add(elemento);
        siftUp();
    }

    public T peek() {
        return elementos.isEmpty() ? null : elementos.get(0);
    }

    public T poll() {
        if (elementos.isEmpty()) return null;
        T resultado = elementos.get(0);
        elementos.set(0, elementos.remove(elementos.size() - 1));
        siftDown();
        return resultado;
    }

    public int size() {
        return elementos.size();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public void siftUp() {
        int index = elementos.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if ((esMaxHeap && elementos.get(index).compareTo(elementos.get(parentIndex)) > 0) ||
                (!esMaxHeap && elementos.get(index).compareTo(elementos.get(parentIndex)) < 0)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void siftDown() {
        int index = 0;
        int lastIndex = elementos.size() - 1;

        while (index <= lastIndex) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int targetIndex = index;

            if (leftChildIndex <= lastIndex && 
                (esMaxHeap ? elementos.get(leftChildIndex).compareTo(elementos.get(targetIndex)) > 0 : 
                elementos.get(leftChildIndex).compareTo(elementos.get(targetIndex)) < 0)) {
                targetIndex = leftChildIndex;
            }
            if (rightChildIndex <= lastIndex && 
                (esMaxHeap ? elementos.get(rightChildIndex).compareTo(elementos.get(targetIndex)) > 0 : 
                elementos.get(rightChildIndex).compareTo(elementos.get(targetIndex)) < 0)) {
                targetIndex = rightChildIndex;
            }
            if (targetIndex == index) break;
            swap(index, targetIndex);
            index = targetIndex;
        }
    }

    private void swap(int index1, int index2) {
        T temp = elementos.get(index1);
        elementos.set(index1, elementos.get(index2));
        elementos.set(index2, temp);
    }

    public ArrayList<T> toList() {
        return new ArrayList<>(elementos);
    }
}