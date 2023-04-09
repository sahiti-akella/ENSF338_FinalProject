package main.java.myLib.datastructures.trees;

import java.util.*;

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
    TNode node = Search(val);
    if (node == null) {
        System.out.println("Value not found in the tree");
        return;
    }
    if (node.getLeft() == null && node.getRight() == null) {
        if (node.getParent() == null) {
            this.root = null;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(null);
        } else {
            node.getParent().setRight(null);
        }
    } else if (node.getLeft() == null) {
        if (node.getParent() == null) {
            this.root = node.getRight();
            node.getRight().setParent(null);
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(node.getRight());
            node.getRight().setParent(node.getParent());
        } else {
            node.getParent().setRight(node.getRight());
            node.getRight().setParent(node.getParent());
        }
    } else if (node.getRight() == null) {
        if (node.getParent() == null) {
            this.root = node.getLeft();
            node.getLeft().setParent(null);
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(node.getLeft());
            node.getLeft().setParent(node.getParent());
        } else {
            node.getParent().setRight(node.getLeft());
            node.getLeft().setParent(node.getParent());
        }
    } else {
        TNode successor = getSuccessor(node);
        node.setData(successor.getData());
        if (successor.getParent().getLeft() == successor) {
            successor.getParent().setLeft(successor.getRight());
            if (successor.getRight() != null) {
                successor.getRight().setParent(successor.getParent());
            }
        } else {
            successor.getParent().setRight(successor.getRight());
            if (successor.getRight() != null) {
                successor.getRight().setParent(successor.getParent());
            }
        }
    }
   }

   // Helper function

   private TNode getSuccessor(TNode node) {
    TNode current = node.getRight();
    while (current.getLeft() != null) {
        current = current.getLeft();
    }
    return current;
}


   // TNode Search(int val)


   public TNode Search(int val){
    TNode current = this.root;
    while (current != null) {
        if (val == current.getData()) {
            return current;
        } else if (val < current.getData()) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }
    }
    return null;
   }

   // printInOrder

   public void printInOrder(TNode node){
    if (node == null) {
        return;
    }
    printInOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    printInOrder(node.getRight());
   }

    // printBF

    public void printBF(){
        if (this.root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            System.out.println();
        }
   }
}
