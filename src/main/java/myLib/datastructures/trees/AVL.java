package main.java.myLib.datastructures.trees;

import main.java.myLib.datastructures.nodes.TNode;

public class AVL extends BST {
    
     
    private TNode root;

    /**
    * Default constructor
    */
     public AVL() {
         super();
     }
 
    /**
    * Overloaded constructor
    * @param val
    */
     public AVL(int val){
        super(val);
     }

    /**
    * Overloaded constructor
    * @param obj
    */
     public AVL(TNode obj){
        super(obj);
        this.root = balance(obj);
     }

    /**
    * Overrided insert
    * @param val
    */
    @Override
    public void Insert(int val){
        super.Insert(val);
        this.root = balance(this.root);
    }

    /**
    * Overrided insert
    * @param node
    */
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        this.root = balance(this.root);
    }

    /**
    * Overrided delete
    * @param val
    */
    @Override
    public void Delete(int val){
        this.root = deleteNode(this.root, val);
    }

    /**
    * Helper function
    * @param node 
    * @param val
    */
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
    
    /**
    * Helper function
    * @param node 
    */
    private TNode findMin(TNode node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return findMin(node.getLeft());
        }
    }

   

    /**
    * Helper function
    * @param node 
    */
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

    /**
    * Helper function
    * @param node 
    */
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
    * Helper function
    * @param node 
    */
    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
    * Helper function
    * @param node 
    */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    /**
    * Helper function
    * @param node 
    */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }
}
