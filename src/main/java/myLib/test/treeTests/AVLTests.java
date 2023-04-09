package main.java.myLib.test.treeTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.trees.*;

public class AVLTests {
    public static void main(String[] args) {

        AVL avlTree = new AVL();

        // Insert elements into the AVL tree
        avlTree.Insert(8);
        avlTree.Insert(6);
        avlTree.Insert(9);
        avlTree.Insert(5);
        avlTree.Insert(7);

        // Print the inorder traversal of the AVL tree
        System.out.println("Inorder Traversal of AVL Tree:");
        avlTree.printInOrder(); // Should print "5 6 7 8 9"

        // Print the breadth-first traversal of the AVL tree
        System.out.println("Breadth-First Traversal of AVL Tree:");
        avlTree.printBF(); // Should print "8 6 9 5 7"

        // Search for a value in the AVL tree
        System.out.println("Search for 6 in AVL Tree:");
        TNode node = avlTree.Search(6);
        if (node != null) {
            System.out.println("Node found in AVL Tree: " + node.getData());
        } else {
            System.out.println("Node not found in AVL Tree");
        }

        // Delete a value from the AVL tree
        System.out.println("Delete 8 from AVL Tree:");
        avlTree.Delete(8);

        // Print the inorder traversal of the AVL tree after deletion
        System.out.println("Inorder Traversal of AVL Tree after deletion:");
        avlTree.printInOrder(); // Should print "5 6 7 9"

        // Print the breadth-first traversal of the AVL tree after deletion
        System.out.println("Breadth-First Traversal of AVL Tree after deletion:");
        avlTree.printBF(); // Should print "6 9 5 7"

        // Insert a node with value 4 into the AVL tree
        TNode newNode = new TNode(4, 0, null, null, null);
        avlTree.Insert(newNode);

        // Print the inorder traversal of the AVL tree after insertion
        System.out.println("Inorder Traversal of AVL Tree after insertion:");
        avlTree.printInOrder(); // Should print "4 5 6 7 9"
    }
}
