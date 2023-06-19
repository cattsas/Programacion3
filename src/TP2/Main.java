package TP2;
import TP1.*;

import java.util.ArrayList;

public class Main {

    public static boolean inOrder(ArrayList<Integer> ar, int inicio){
        if (inicio>=(ar.size()-1)){
            return true;
        }
        else {
            if (ar.get(inicio)>ar.get(inicio+1)){
                return false;
            }
            else{
                return inOrder(ar,inicio+1);
            }
        }
    }

    public static int searchInList(MySimpleLinkedList list, int elem, int pos){
        if (pos>=list.size()){
            return -1;
        }
        else {
            if (list.get(pos).equals(elem)){
                return pos;
            }
            else {
                return searchInList(list,elem,pos+1);
            }
        }
    }

    public static int searchInOrderedArray(ArrayList<Integer> ar, int elem, int inicio){
        if (inicio>ar.size()-1 || ar.get(inicio)>elem){
            return -1;
        }
        else {
            if (ar.get(inicio).equals(elem)){
                return inicio;
            }
            else {
                return searchInOrderedArray(ar,elem,++inicio);
            }
        }
    }

    public static void decBin(int n) {
        if (n<2) {
            System.out.print(n);
        } else {
            decBin(n / 2);
            System.out.println(n % 2);
        }
    }

    public static long fibonacci (int tope){
        if (tope<2){
            return(tope);
        }
        else {
            return((fibonacci(tope-1)+fibonacci(tope-2)));
        }

    }

    public static void burbujeo (ArrayList<Integer> ar){
        int i,j,aux;

        for (i=0;i<ar.size()-1;i++){
            for (j=0;j<ar.size()-1-i;j++){
                if (ar.get(j)>ar.get(j+1)){
                    aux=ar.get(j);
                    ar.set(j,ar.get(j+1));
                    ar.set(j+1,aux);
                }
                System.out.println(ar);
            }
        }

    }

    public static void seleccion (ArrayList<Integer> ar){
        int i,j,aux;
        for (i=0;i<=ar.size()-1;i++){
            for (j=i+1;j<=ar.size()-1;j++){
                if (ar.get(j)<ar.get(i)){
                    aux=ar.get(i);
                    ar.set(i,ar.get(j));
                    ar.set(j,aux);
                }

            }
            System.out.println(ar);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> myAr=new ArrayList<>();
        myAr.add(5);
        myAr.add(3);
        myAr.add(1);
        myAr.add(2);


        MySimpleLinkedList<Integer> myList=new MySimpleLinkedList<>();
        myList.insertFront(2);
        myList.insertFront(1);
        myList.insertFront(3);
        myList.insertFront(7);
        myList.insertFront(6);

        System.out.println(myAr);
        System.out.println(inOrder(myAr,0));
        System.out.println(myList);
        System.out.println(searchInList(myList,9,0));
        System.out.println(searchInOrderedArray(myAr,5,0));
        decBin(14);
        System.out.println(fibonacci(4));
        burbujeo(myAr);
        seleccion(myAr);

        BinaryTree tree=new BinaryTree();
        tree.insert(15);
        tree.insert(4);
        tree.insert(7);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.insert(12);
        tree.insert(17);


        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
        System.out.println();
        tree.printInOrder();
        System.out.println("La raiz del arbol es "+tree.getRoot());
        System.out.println(tree.hasElem(99));
        System.out.println((tree.isEmpty()));
      System.out.println(tree.isLeaf());
        System.out.println(tree.getHeight());
        System.out.println(tree.getLongestBranch());
        System.out.println(tree.getFrontera());
        System.out.println(tree.getMaxElem());
          System.out.println(tree.sumInternos());
        System.out.println(tree.levelOfAnElem(6));



    }

}
