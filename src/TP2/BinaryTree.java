package TP2;

import java.util.ArrayList;

public class BinaryTree {
    private BinaryTree derecha;
    private BinaryTree izquierda;
    private Integer value;

    public BinaryTree(int value) {
        this.value = value;
        this.derecha=null;
        this.izquierda=null;
    }

    public BinaryTree() {
        this.value=null;
        this.derecha = null;
        this.izquierda=null;
    }

    public Integer getRoot(){
        return this.value;
    }

    public boolean hasElem(int val){

        if (this.getRoot().equals(val)){
            return true;
        }
        if (this.getRoot() > val && this.izquierda != null) {
                   return  this.izquierda.hasElem(val);
        }
        if (this.derecha != null) {
                return this.derecha.hasElem(val);
        }

            return false;

    }

    public boolean isEmpty(){
        return (this.getRoot()==null);
    }

    //inserta
    public void insert (Integer val){
        if (this.value==null){
            this.value=val;
        }
        else if (this.value>val){
            if (this.izquierda==null){
                this.izquierda=new BinaryTree(val);
            }
            else {
                izquierda.insert(val);
            }
        }
        else {
            if (this.derecha==null){
                this.derecha=new BinaryTree(val);
            }
            else{
                derecha.insert(val);
            }
        }
    }


    public void printInOrder(){
        if (this.value==null){

            return;
        }

            if (this.izquierda!=null){
                this.izquierda.printInOrder();
            }
            else {
                System.out.print("-,");
            }
            System.out.print(this.value+",");
            if (this.derecha!=null){
                this.derecha.printInOrder();
            }
            else {
                System.out.print("-,");
            }

    }

    public void printPreOrder(){
        if (this.value==null){

            return;
        }

            System.out.print(this.value+",");
            if (this.izquierda!=null){
                this.izquierda.printPreOrder();
            }
            else {
                System.out.print("-,");
            }
            if (this.derecha!=null){
                this.derecha.printPreOrder();
            }
            else {
                System.out.print("-,");
            }

    }

    public void printPostOrder(){
        if (this.value==null){
           return;
        }


            if (this.izquierda!=null){
                this.izquierda.printPostOrder();
            }
            else {
                System.out.print("-,");
            }
            if (this.derecha!=null){
                this.derecha.printPostOrder();
            }
            else {
                System.out.print("-,");
            }
            System.out.print(this.value+",");

    }

    public boolean isLeaf () {
        return (this.izquierda==null && this.derecha==null);
    }

    public int getHeight(){
        if (this.isLeaf()){
            return 0;
        }

        else {
            int left=0,right=0;
            if (this.izquierda!=null){
               left=this.izquierda.getHeight()+1;
            }
            if (this.derecha!=null){
                right=this.derecha.getHeight()+1;
            }
            return Math.max(left,right);
        }

    }

    public ArrayList getLongestBranch(){
        ArrayList left=new ArrayList();
        ArrayList right=new ArrayList();
        left.add(this.getRoot());
        right.add(this.getRoot());

        if (this.izquierda!=null){
            left.addAll(this.izquierda.getLongestBranch());
        }
        if (this.derecha!=null){
            right.addAll(this.derecha.getLongestBranch());
        }

        if (left.size()>right.size()){
            return left;
        }
        else {
            return right;
        }

    }
//Devuelve lista de hojas
    public ArrayList getFrontera(){


        if (this.isLeaf()){
            ArrayList list=new ArrayList<>();
            list.add(this.getRoot());
           return list;
        }

        else {
            ArrayList frontera=new ArrayList<>();
            if (izquierda!=null){
               frontera.addAll( izquierda.getFrontera());
            }
            if (derecha!=null){
                frontera.addAll(derecha.getFrontera());
            }
            return frontera;
        }

    }
//Devuelve el valor màs alto del àrbol
    public int getMaxElem() {
        if (this.derecha==null){
            return this.getRoot();
        }
        else {
            return derecha.getMaxElem();
        }
    }
//Devuelve todos los elementos que se encuentran en el nivel indicado
    public ArrayList getElemAtLevel (int level){
        if (level==0){
            ArrayList list=new ArrayList();
            list.add(this.getRoot());
            return list;
        }

        else {
           ArrayList levelElems=new ArrayList<>();
           if (izquierda!=null) {
               levelElems.addAll(izquierda.getElemAtLevel(level-1));
           }
            if (derecha!=null) {
                levelElems.addAll(derecha.getElemAtLevel(level-1));
            }
            return levelElems;
        }
    }
//Retorna el nivel en que se encuentra un elemento. Si no Se encuentra, devuelve -1
    public int levelOfAnElem(int elem) {
        if (!this.hasElem(elem)){
            return-1;
        }
        else {
            if (this.getRoot() == elem) {
                return 0;
            } else {
                if (this.getRoot() > elem) {
                    return izquierda.levelOfAnElem(elem) + 1;
                } else {
                    return derecha.levelOfAnElem(elem) + 1;
                }

            }
        }
    }

//Suma el valor de todos los nodos que no son hojas
    public Integer sumSinHojas() {

        if (this.isLeaf()){
            return 0;
        }
        else {
                int suma = this.getRoot();

                if (izquierda != null && derecha != null) {
                    return suma += izquierda.sumSinHojas() + derecha.sumSinHojas();
                } else if (izquierda != null && derecha == null) {
                    return suma += izquierda.sumSinHojas();
                } else {
                    return suma += derecha.sumSinHojas();
                }
            }
   }
//Retorna la suma de todos los nodos internos (Todos menos raiz y hojas)
   public int sumInternos () {
        return this.sumSinHojas()-this.getRoot();
   }


}
