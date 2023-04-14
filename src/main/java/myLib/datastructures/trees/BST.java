package main.java.myLib.datastructures.trees;

import java.util.*;

import main.java.myLib.datastructures.nodes.TNode;

/**
 * This class is the implementation of the Binary Search Tree (BST) for integer data.
 */

public class BST {
  
   protected TNode root;

   /**
    * Default constructor initializing root to null
    */
   public BST() {
       this.root = null;
   }

   /**
    * Overload constructor
    * @param val Value
    * @param 0 0 
    * @param null Sets parent to null
    * @param null Sets left to null
    * @param null Sets right to null
    */
   public BST(int val){
       this.root = new TNode(val, 0, null, null, null);
   }

   /**
    * Overload constructor
    * @param obj To be set to root
    */
   public BST(TNode obj){
       this.root = obj;
   }

    /**
    * Gettter
    * @return Returns root
    */
   public TNode getRoot() {
       return this.root;
   }

   /**
    * Setter
    * @param root Sets root
    */
   public void setRoot(TNode root) {
       this.root = root;
   }

    /**
    * Insert node with argument value
    * @param val Value to be inserted
    */
   public void Insert(int val){
       TNode node = new TNode(val, 0, null, null, null);
       Insert(node);
   }

    /**
    * Inserts specified node
    * @param node Node be inserted to the tree
    */
   public void Insert(TNode node){
       if (this.root == null) {
           this.root = node;
       }
       else{
           TNode current = this.root;
            TNode parent;
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

    /**
    * Deletes argument value from tree
    * @param val Value to be deleted
    */
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

    /**
    * Helper function
    * @param node argument node to check right and left sides of node
    * @return Returns successor node
    */
   private TNode getSuccessor(TNode node) {
    TNode current = node.getRight();
    while (current.getLeft() != null) {
        current = current.getLeft();
    }
    return current;
}

    /**
    * Searches for argument node in tree
    * @param val Value to be searched for
    * @return Returns outcome of search - more in tests
    */
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

    /**
    * Prints tree elements in ascending order
    * @param node Checks if node is null or else prints left and right elements
    */
   public void printInOrder(TNode node){
    if (node == null) {
        return;
    }
    printInOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    printInOrder(node.getRight());
   }

    /**
    * Prints tree elements in breadth-first order
    */
    public void printBF(){
        if (this.root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
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
