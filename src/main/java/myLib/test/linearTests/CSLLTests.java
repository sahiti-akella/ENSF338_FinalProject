package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class CSLLTests {
    public static void main(String[] args) {  
        CSLL csList = new CSLL();

        SNode validSearch = new SNode(4);
        SNode invalidSearch = new SNode(8);
        SNode nodeToDelete = new SNode(9);

        System.out.println("\nTESTING ADDING, DELETING AND SORTING: ");  
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(nodeToDelete);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(new SNode(3));  
        csList.print();  
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(validSearch);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(new SNode(7));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nAdding nodes to the start of the list: ");  
        csList.insertHead(new SNode(2));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nAdding nodes to specified position in the list: ");  
        csList.insert(new SNode(5), 3);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nSort and insert node in the list: ");  
        csList.sortedInsert(new SNode(6));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting head: ");
        csList.deleteHead(); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting tail: ");
        csList.deleteTail(); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting specified node: ");
        csList.delete(nodeToDelete); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nTESTING SEARCHING AND CLEARING: ");  

        System.out.println("\nFinding node..");
        SNode node1 = csList.search(validSearch);  
        System.out.println("Node (null if not found): " + node1);

        System.out.println("\nFinding non existent node..");
        SNode node2 = csList.search(invalidSearch);  
        System.out.println("Node (null if not found): " + node2);

        System.out.println("\nClearing entire list:");
        csList.clear(); 
        csList.print();
        System.out.println("\n");  

    }  
}
