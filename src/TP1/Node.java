package TP1;

public class Node<T> {
    private T value;
    private Node next;

    public Node() {
      this.value=null;
      this.next=null;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public Integer getValue() {
        return (Integer) value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
