package org.example.ejercicio2;

public interface IUniqueStack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
