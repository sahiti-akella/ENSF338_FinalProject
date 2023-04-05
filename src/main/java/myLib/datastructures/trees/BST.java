package main.java.myLib.datastructures.trees;

import main.java.myLib.datastructures.nodes.TNode;

public class BST {
    
    // Member Variables
    private TNode root;

    // Default Constructor
    public BST() {
        this.root = null;
    }

    // Overload Constructors
    public BST(int val){
        this.root.setData(val);
    }

    public BST(TNode obj){
        this.root = obj;
    }

    // Getters and Setters

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    // Insert(int val)

    public void insert(int val){
        // Implement
    }

    // Insert(TNode node)

    public void insert(TNode node){
        // Implement
    }

    // Delete(int val)

    public void delete(int val){
        // Implement
    }

    // TNode Search(int val)

    public TNode search(int val){
         // Implement, get rid of return root
         return root;
    }

    // printInOrder

    public void printInOrder(){
        // Implement
    }

     // printBF

     public void printBF(){
        // Implement
    }







}
