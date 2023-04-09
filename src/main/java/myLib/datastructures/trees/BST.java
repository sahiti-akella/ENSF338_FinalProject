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
       this.root = new TNode(val, 0, null, null, null);
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


   public void Insert(int val){
       TNode node = new TNode(val, 0, null, null, null);
       Insert(node);
   }


   // Insert(TNode node)


   public void Insert(TNode node){
       if (this.root == null) {
           this.root = node;
       }
       else{
           TNode current = this.root;
       TNode parent = null;
       while (true) {
           parent = current;
           if (node.getData() < current.getData()) {
               current = current.getLeft();
               if (current == null) {
                   parent.setLeft(node);
                   node.setParent(parent);
                   return;
               }
           } else {
               current = current.getRight();
               if (current == null) {
                   parent.setRight(node);
                   node.setParent(parent);
                   return;
               }
           }
       }
       }
      
   }


   // Delete(int val)


   public void Delete(int val){
       // Implement
   }


   // TNode Search(int val)


   public TNode Search(int val){
        // Implement, get rid of return root
        return root;
   }


   // printInOrder


   public void printInOrder(TNode node){
      // Implement
   }


    // printBF


    public void printBF(){
       // Implement
   }


}
