package main.java.myLib.test.treeTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.trees.*;

public class BSTTests {
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
