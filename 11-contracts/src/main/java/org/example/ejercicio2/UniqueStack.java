package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * INVARIANT:
 * - No hay elementos duplicados en la lista.
 * - Ningún elemento es nulo.
 */
public class UniqueStack<E> implements IUniqueStack<E> {
    private List<E> elements;

    public UniqueStack() {
        elements = new ArrayList<>();
    }

    /**
     * PRECONDITION: item != null && !contains(item)
     * POSTCONDITION: el item fue agregado al tope de la pila
     */
    @Override
    public void push(E item) {
        if (item == null)
            throw new NullPointerException("El item no puede ser nulo.");
        if (elements.contains(item))
            throw new IllegalArgumentException("El elemento ya existe.");

        elements.add(item);
        assert repOK() : "La inserción del item violó el invariante del stack.";
    }

    /**
     * PRECONDITION: la pila no está vacía
     * POSTCONDITION: el elemento tope fue eliminado
     */
    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();

        E item = peek();
        elements.removeLast();
        assert repOK() : "La eliminación violó el invariante del stack.";
        return item;
    }

    /**
     * PRECONDITION: la pila no está vacía
     * POSTCONDITION: el estado no cambia
     */
    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return elements.getLast();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    /**
     * Verifica el invariante de representación.
     */
    public boolean repOK() {
        // Ningún elemento nulo y sin duplicados
        List<E> seen = new ArrayList<>();
        for (E e : elements) {
            if (e == null || seen.contains(e)) return false;
            seen.add(e);
        }
        return true;
    }
}
