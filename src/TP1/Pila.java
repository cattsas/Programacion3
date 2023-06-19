package TP1;

public class Pila {
    private MySimpleLinkedList<Integer>  list;

    public Pila(MySimpleLinkedList<Integer> list) {
        this.list = list;
    }

    public void push (Integer value){
        list.insertFront(value);
    }
    public Integer pop() {
        return list.extractFront();
    }

    public Integer top () {
        return this.list.get(0);//también puede resolverse con "return this.list.first.getValue();"
    }

    public void originalReverse () {
        MySimpleLinkedList<Integer> rever= new MySimpleLinkedList<>();
        while (!this.list.isEmpty()){
            rever.insertFront(this.list.extractFront());
        }
        this.list=rever;
        System.out.println(this.list);
    }

    public Pila reverse () {//no altera TP1.Pila original
        MySimpleLinkedList<Integer> reverList= new MySimpleLinkedList<>();
        Pila rever= new Pila(reverList);
        Node cursor=new Node<>();
        cursor=this.list.getFirst();
        while (rever.list.size()<this.list.size()){
            rever.list.insertFront((Integer) cursor.getValue());
            cursor=cursor.getNext();

        }
        System.out.println(reverList);
        return rever;
    }


}
