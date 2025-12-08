package com.icesi.structures;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> newNode = new Node<>(data);

        if (size == 0) { // lista vacía
            first = newNode;
            last = newNode;
            size++;
        } else if (index == 0) { // insertar al inicio
            addFirst(data);
        } else if (index == size) { // insertar al final
            addLast(data);
        } else { // insertar en medio
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
            size++;
        }
    }

    public void addFirst(T data) {
        if (size == 0) {
            first = new Node<>(data);
            last = first;
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        if (size == 0) {
            first = new Node<>(data);
            last = first;
        }  else {
            Node<T> newNode = new Node<>(data);
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);

        Node<T> toRemove;

        if (size == 1) {                    // sólo un elemento
            toRemove = first;
            first = null;
            last = null;
            size--;
        } else if (index == 0) {            // eliminar primero
            return removeFirst();
        } else if (index == size - 1) {     // eliminar último
            return removeLast();
        } else {                            // eliminar en medio
            toRemove = first;
            for (int i = 0; i < index; i++) {
                toRemove = toRemove.getNext();
            }
            toRemove.getPrevious().setNext(toRemove.getNext());
            toRemove.getNext().setPrevious(toRemove.getPrevious());
            size--;
        }
        return toRemove.getData();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = first.getData();
            first = last = null;
            size--;
            return data;
        }
        else {
            Node<T> toRemove = first;
            first = first.getNext();
            first.setPrevious(null);
            size--;
            return toRemove.getData();
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if(size == 1) {
            T data = last.getData();
            last = first = null;
            size--;
            return data;
        }
        else {
            Node<T> toRemove = last;
            last = last.getPrevious();
            last.setNext(null);
            size--;
            return toRemove.getData();
        }
    }

    public void exchange(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (i == j) return; // no hace nada

        // Asegurar que i < j para recorrer menos
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        Node<T> nodeI = first;
        for (int k = 0; k < i; k++) {
            nodeI = nodeI.getNext();
        }

        Node<T> nodeJ = nodeI;
        for (int k = i; k < j; k++) {
            nodeJ = nodeJ.getNext();
        }

        // intercambiar valores
        T tempData = nodeI.getData();
        nodeI.setData(nodeJ.getData());
        nodeJ.setData(tempData);
    }
}
