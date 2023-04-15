package test.treeTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.trees.*;

public class BSTTests {
    public static void main(String[] args) {
        
        BST bst = new BST();
    
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(13);
        bst.Insert(10);
        bst.Insert(3);
        bst.Insert(1);
        bst.Insert(8);
        bst.Insert(12);
        bst.Insert(15);
        
        System.out.println("Root node: " + bst.getRoot().getData());
        
        System.out.print("In-order traversal: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal:");
        bst.printBF();
    
        System.out.println("Searching for value 10...");
        TNode result = bst.Search(10);
        if (result != null) {
            System.out.println("Value found: " + result.getData());
        } else {
            System.out.println("Value not found in the tree.");
        }
    
        System.out.println("Deleting values 7 and 10...");
        bst.Delete(7);
        bst.Delete(10);
    
        System.out.println("Root node after deletion: " + bst.getRoot().getData());
 
        System.out.print("In-order traversal after deletion: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
   
        System.out.println("Breadth-first traversal after deletion:");
        bst.printBF();
    
        bst.Insert(6);
    
        System.out.println("Root node after insertion: " + bst.getRoot().getData());
    
        System.out.print("In-order traversal after insertion: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal after insertion:");
        bst.printBF();

        BST bst1 = new BST(new TNode(20, 0, null, null, null));

        bst1.Insert(6);
        bst1.Insert(23);
        bst1.Insert(14);
        bst1.Insert(19);
        bst1.Insert(8);

        System.out.println("Root node: " + bst1.getRoot().getData());
        
        System.out.print("In-order traversal: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal:");
        bst1.printBF();
    
        System.out.println("Searching for value 10...");
        TNode result1 = bst1.Search(10);
        if (result1 != null) {
            System.out.println("Value found: " + result1.getData());
        } else {
            System.out.println("Value not found in the tree.");
        }
    
        System.out.println("Deleting values 6 and 8...");
        bst1.Delete(6);
        bst1.Delete(8);
    
        System.out.println("Root node after deletion: " + bst1.getRoot().getData());
 
        System.out.print("In-order traversal after deletion: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
   
        System.out.println("Breadth-first traversal after deletion:");
        bst1.printBF();
    
        bst1.Insert(6);
    
        System.out.println("Root node after insertion: " + bst1.getRoot().getData());
    
        System.out.print("In-order traversal after insertion: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal after insertion:");
        bst1.printBF();
    }
}
