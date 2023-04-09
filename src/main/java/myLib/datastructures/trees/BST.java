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

   public static void main(String[] args) {
    
    // Create a new BST object
    BST bst = new BST();

    // Insert some values into the BST
    bst.Insert(7);
    bst.Insert(2);
    bst.Insert(13);
    bst.Insert(10);
    bst.Insert(3);
    bst.Insert(1);
    bst.Insert(8);
    bst.Insert(12);
    bst.Insert(15);

    // Print the root node
    System.out.println("Root node: " + bst.getRoot().getData());

    // Print the tree in-order
    System.out.print("In-order traversal: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    // Print the tree in breadth-first order
    System.out.println("Breadth-first traversal:");
    bst.printBF();

    // Test the Search() function
    System.out.println("Searching for value 10...");
    TNode result = bst.Search(10);
    if (result != null) {
        System.out.println("Value found: " + result.getData());
    } else {
        System.out.println("Value not found in the tree.");
    }

    // Test the Delete() function
    System.out.println("Deleting values 7 and 10...");
    bst.Delete(7);
    bst.Delete(10);

    // Print the root node again after deletion
    System.out.println("Root node after deletion: " + bst.getRoot().getData());

    // Print the tree in-order again after deletion
    System.out.print("In-order traversal after deletion: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    // Print the tree in breadth-first order again after deletion
    System.out.println("Breadth-first traversal after deletion:");
    bst.printBF();

    // Insert a new value into the BST
    bst.Insert(6);

    // Print the root node again after insertion
    System.out.println("Root node after insertion: " + bst.getRoot().getData());

    // Print the tree in-order again after insertion
    System.out.print("In-order traversal after insertion: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    // Print the tree in breadth-first order again after insertion
    System.out.println("Breadth-first traversal after insertion:");
    bst.printBF();
}

}
