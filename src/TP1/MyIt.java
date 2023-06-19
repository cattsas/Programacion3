package TP1;

import java.util.Iterator;

public class MyIt<T> implements Iterator {

    private Node<T> cursor;

    public MyIt(Node<T> first) {
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        return (this.cursor!=null);
    }

    @Override
    public T next() {
        T info = (T) this.cursor.getValue();
        this.cursor = this.cursor.getNext();
        return info;
    }
}
