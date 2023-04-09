package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class SLLTests {
    public static void main(String[] args) {  
  
        SLL sList = new SLL();  
        SNode validSearch = new SNode(4);
        SNode invalidSearch = new SNode(8);
        SNode nodeToDelete = new SNode(7);

        System.out.println("\nTESTING INSERTING, DELETING AND SORTING: ");  

        System.out.println("\nInserting nodes to tail: ");  
        sList.insertTail(nodeToDelete);  
        sList.print();
  
        System.out.println("\nInserting nodes to tail: ");  
        sList.insertTail(new SNode(3));  
        sList.print();  
  
        System.out.println("\nInserting nodes to tail: ");  
        sList.insertTail(new SNode(2));  
        sList.print();
  
        System.out.println("\nInserting nodes to tail: ");  
        sList.insertTail(new SNode(9));  
        sList.print();

        System.out.println("\nInserting nodes to head: ");  
        sList.insertHead(validSearch);  
        sList.print();

        System.out.println("\nSorted insert node: ");  
        sList.sortedInsert(new SNode(6));  
        sList.print();

        System.out.println("\nInserting nodes: ");  
        sList.insert(new SNode(5), 3);  
        sList.print();

        System.out.println("\nDeleting node: ");
        sList.delete(nodeToDelete); 
        sList.print();

        System.out.println("\nDeleting head: ");
        sList.deleteHead(); 
        sList.print();

        System.out.println("\nDeleting tail: ");
        sList.deleteTail(); 
        sList.print();

        System.out.println("\nTESTING SEARCHING AND CLEARING: ");  

        System.out.println("\nFinding node..");
        SNode node1 = sList.search(validSearch);  
        System.out.println("Node (null if not found): " + node1);

        System.out.println("\nFinding non existent node..");
        SNode node2 = sList.search(invalidSearch);  
        System.out.println("Node (null if not found): " + node2);

        System.out.println("\nClearing list: ");
        sList.clear(); 
        sList.print();
        System.out.println("\n");  
    } 
}
