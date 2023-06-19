package TP1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{

    private Node <Integer>first;
    private int size;

    public MySimpleLinkedList() {
        this.first=null;
        this.size=0;
    }

    public MySimpleLinkedList(Node first) {
        this.first = first;
        this.size = 1;
    }

    public Node getFirst() {
        return first;
    }

    public void insertFront(T i) {
        Node<T> temp= new Node<T>(i,first);
        first= (Node<Integer>) temp;
        size++;
    }

    public T extractFront(){
        if (first!=null){
            Node<T> temp;
            temp= (Node<T>) first;
            first=temp.getNext();
            size--;
            return (T) temp.getValue();
        }
        else {
            return null;
        }
    }

    public boolean isEmpty(){
        return (this.size==0);
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String list="";
        Node <T> temp;
        temp= (Node<T>) this.first;
        while (temp!=null){
            list+=temp.getValue();
            if (temp.getNext()!=null){
                list+=",";
            }
            temp=temp.getNext();
        }
        return list;
    }

    public T get (int index){
        if (index<=this.size && this.size()>0){
            Node <T> temp;
            temp= (Node<T>) first;
            int cont=0;
            while (cont<index){
                temp=temp.getNext();
                cont++;
            }
            return (T) temp.getValue();
        }
        else {
            return null;
        }
    }

    //Devuelve elementos comunes a dos listas, ambas desordenadas
    public MySimpleLinkedList<T> comElemsDisordered(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
         Node<T> tmp1;
         Node<T> tmp2;
         MySimpleLinkedList<T> commons=new MySimpleLinkedList<>();

         tmp1= (Node<T>) list1.first;
         while (tmp1!=null){
             tmp2= (Node<T>) list2.first;
             while (tmp2!=null){
                 if (tmp1.getValue()==tmp2.getValue()){
                     commons.insertFront((T) tmp1.getValue());
                 }
                 tmp2=tmp2.getNext();
             }
             tmp1=tmp1.getNext();
         }
        return commons;
    }

    //Devuelve elementos comunes a dos listas, la primera desordenada y la segunda ordenada
    public MySimpleLinkedList<Integer> comElemsScndordered(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2){
        Node<Integer> tmp1;
        Node<Integer> tmp2;
        MySimpleLinkedList<T> commons=new MySimpleLinkedList<>();

        tmp1=list1.first;
        while (tmp1!=null){
            tmp2=list2.first;
            while (tmp2!=null && tmp2.getValue()<=tmp1.getValue()){
                if (tmp1.getValue()==tmp2.getValue()){
                    commons.insertFront((T) tmp1.getValue());
                }
                tmp2=tmp2.getNext();
            }
            tmp1=tmp1.getNext();
        }
        return (MySimpleLinkedList<Integer>) commons;
    }

    public int indexOf(int value){
        int pos=0;
        Node<Integer> cursor=this.first;

        while (cursor.getNext()!=null && cursor.getValue()!=value){
            pos++;
            cursor=cursor.getNext();
        }
        if (cursor.getValue()==value){
            return pos;
        }
        else{
            return-1;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIt<T>((Node<T>) this.first);
    }

    public void insertInorder(int value){
        Node<Integer> aux=new Node<>(value);
        Node<Integer> pos=new Node<>();
        if (this.first!=null) {
            if (this.first.getValue() < value) {
                pos = this.first;
                while (pos.getNext() != null && pos.getNext().getValue() < value) {
                    pos = pos.getNext();
                }
                aux.setNext(pos.getNext());
                pos.setNext(aux);
            }
            else {
                aux.setNext(first);
                first=aux;
            }
        }
        else {
            this.first=aux;
        }
    }
}
