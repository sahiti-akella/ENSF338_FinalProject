package main.java.myLib.datastructures.trees;

import main.java.myLib.datastructures.nodes.TNode;

public class AVL extends BST {
    
     // Member Variables
     private TNode root;

     // Default Constructor
     public AVL() {
         this.root = null;
     }
 
     // Overload Constructors
     public AVL(int val){
        this.root = new TNode(val, 0, null, null, null);
     }

     public AVL(TNode obj){
        this.root = obj;

        if (obj.getLeft() != null || obj.getRight() != null) {
            this.root = balance(obj);
        }
     }

     // Insert(int val)
    @Override
    public void Insert(int val){
        super.Insert(val);
        this.root = balance(this.root); // To balance tree
    }

    // Insert(TNode node)
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        this.root = balance(this.root); // To balance tree
    }

    // Delete(int val)
    @Override
    public void Delete(int val){
        this.root = deleteNode(this.root, val);
    }

    // Helper functions for Delete function

    private TNode deleteNode(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree");
            return null;
        }
    
        if (val < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(deleteNode(node.getRight(), val));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else {
                TNode temp = findMin(node.getRight());
                node.setData(temp.getData());
                node.setRight(deleteNode(node.getRight(), temp.getData()));
            }
        }
    
        if (node != null) {
            node = balance(node);
        }
    
        return node;
    }
    
    private TNode findMin(TNode node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return findMin(node.getLeft());
        }
    }

    // TNode Search(int val)

    public TNode Search(int val){
       return super.Search(val);
    }

    // printInOrder

    public void printInOrder(){
       super.printInOrder(root);
    }

     // printBF

     public void printBF(){
        super.printBF();
    }

     // Helper methods
     private TNode balance(TNode node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) >= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private int getBalanceFactor(TNode node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }
}
