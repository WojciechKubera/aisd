import java.util.ArrayList;
import java.util.LinkedList;

/**
     * Created by Wojtek on 2016-04-26.
     */
    public class Tree {
    Node root;

    public void createTree( String onp) {
        String [] tab = onp.split(" ");
        for (int i = 0; i<tab.length; i++){
            System.out.println(tab[i]);

        }
        Stos<Node> node = new Stos<>();
        String operatory = "+-/*%";
        for (int i = 0; i<tab.length; i++){
            if(operatory.contains(tab[i])){
                Node a = node.Pop();
                Node b = node.Pop();
                Node c = new Node(tab[i], true);
               c.leftChild = b;
                c.rightChild = a;
                node.Push(c);
            }else {
                node.Push(new Node(tab[i], false));
            }
        }
        root = node.Pop();
    }


    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            postOrderTraverseTree(focusNode.rightChild);
            postOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);

        }
    }


    public int oblicz(Node node){
        if( node.flaga()){
            int a = oblicz(node.leftChild);
            int b = oblicz(node.rightChild);
            String operatory = "+-*/%";

            switch (operatory.indexOf(node.opr())) {
                case 0: return a + b;
                case 1: return a - b;
                case 2: return a * b;
                case 3: return a / b;
                case 4: return a % b;
            }
        }
        return node.value();
    }



    public int size(Node focusNode){
        if (focusNode == null){
            return 0;
        }
        return 1+size(focusNode.getLeftChild())+ size(focusNode.getRightChild());
    }
    public int leaf(Node focusNode){
        if (focusNode == null){
            return 0;
        }
        return ((1+size(focusNode.getLeftChild())+ size(focusNode.getRightChild()))+1)/2;
    }
    public int height(Node focusNode){
        if (focusNode == null){
            return 0;
        }
        return ((1+size(focusNode.getLeftChild())+ size(focusNode.getRightChild()))-1)/2;
    }

    class Node {

      boolean operator =false;
        String name;

        Node leftChild;
        Node rightChild;

        Node(String name,boolean operator) {
            this.name = name;
            this.operator = operator;
        }
        public Node getLeftChild(){
            return  leftChild;
        }
        public Node getRightChild(){
            return  rightChild;
        }
        boolean flaga(){
            return operator;
        }

        int value(){
            return Integer.parseInt(name);
        }
        String opr(){
            return name;
        }

        public String toString() {

            return name ;


        }

    }
}