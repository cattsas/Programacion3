package TP1;

public class Main {

    public static MySimpleLinkedList<Integer> fromDisorderedToOrdered(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2){

        MyIt<Integer> it1= (MyIt<Integer>) list1.iterator();

        MySimpleLinkedList<Integer> ord=new MySimpleLinkedList<>();
        boolean encontrado;
        int valor1,valor2;
        while (it1.hasNext()){
            MyIt<Integer> it2= (MyIt<Integer>) list2.iterator();
            encontrado=false;
            valor1=it1.next();
            while (it2.hasNext() && !encontrado){
                valor2=it2.next();
                if (valor1==valor2){
                    encontrado=true;
                    ord.insertInorder(valor1);
                }
            }

        }
        return ord;
    }


    public static void main(String[] args) {


       MySimpleLinkedList<Integer> list1= new MySimpleLinkedList<>();
       list1.insertFront(2);
       list1.insertFront(1);
       list1.insertFront(5);
       list1.insertFront(3);
       list1.insertFront(8);
       list1.insertFront(4);
       list1.insertFront(7);
       list1.insertFront(6);

        MySimpleLinkedList<Integer> list2= new MySimpleLinkedList<>();
        list2.insertFront(68);
        list2.insertFront(57);
        list2.insertFront(44);
        list2.insertFront(28);
        list2.insertFront(7);
        list2.insertFront(6);
        list2.insertFront(5);
        list2.insertFront(3);



        MySimpleLinkedList<Integer> commonList= new MySimpleLinkedList<>();
        Pila pila=new Pila(list2);
        System.out.println(list1);
        System.out.println(list2);

       System.out.println("El elemento en el tope de la pila es "+pila.top());
    //   pila.reverse();
    //    pila.originalReverse();
       System.out.println("La posiciòn en que se encuentra el elemento buscado es "+list2.indexOf(99));

        System.out.println(commonList.comElemsScndordered(list1,list2));
       System.out.println("El valor que se ubica en la posiciòn ingresada es "+list1.get(4));
        System.out.println("El elemento extraìdo de la primera posiciòn es "+list1.extractFront());
        System.out.println(list1.isEmpty());
        System.out.println("E tamaño de la lista es "+list1.size());

         System.out.println("Los elementos comunes ordenados de 2 listas desordenadas son: "+fromDisorderedToOrdered(list1,list2));


    }
}