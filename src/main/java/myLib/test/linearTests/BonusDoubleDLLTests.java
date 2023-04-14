package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

/**
 * This class provides a set of tests for the BonusDoubleDLL class, which implements a
 * doubly linked list.
 */

 public class BonusDoubleDLLTests {
    /**
     * The main method of this class runs a set of tests on the SLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        BonusDoubleDLL list = new BonusDoubleDLL();
        DNode<Double> node = new DNode<Double>(1.0);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3.0 1.0 2.0");
        list.insertHead(node);
        list.insertTail(new DNode<Double>(2.0));
        list.insertHead(new DNode<Double>(3.0));
        list.print(); // should print "List content: 3.0 1.0 2.0 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5.0 3.0 4.0 1.0 2.0 6.0");
        list.insert(new DNode<Double>(4.0), 2);
        list.insert(new DNode<Double>(5.0), 1);
        list.insert(new DNode<Double>(6.0), 6);
        list.print(); // should print "List content: 5.0 3.0 4.0 1.0 2.0 6.0 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3.0 4.0 2.0 ");
        list.deleteHead();
        list.deleteTail();
        System.out.println("Search node: " + list.search(node)); // should print "Search node: 1.0"
        list.delete(node);
        list.print(); // should print "List content: 3.0 4.0 2.0"
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list.clear();
        list.print(); // should print "List is empty"

        // SLL LIST2

        // Test sort
        System.out.println("\n-----------Testing constructor and sort: ");
        // Test constructor
        BonusDoubleDLL list2 = new BonusDoubleDLL(new DNode<Double>(5.0));
        list2.print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.insertHead(new DNode<Double>(4.0));
        list2.insertHead(new DNode<Double>(2.0));
        list2.insertHead(new DNode<Double>(3.0));
        list2.insertHead(new DNode<Double>(1.0));
        System.out.println("Before sort:");
        list2.print(); // should print "List content: 1.0 3.0 2.0 4.0 5.0"
        list2.sort();
        System.out.println("After sort:");
        list2.print(); // should print "List content: 1.0 2.0 3.0 4.0 5.0"
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list2.clear();
        list2.print(); // should print "List is empty"

        // Test sortedInsert and sort
        System.out.println("\n-----------Testing sortedInsert, expected: 1.0 2.0 3.0 4.0 5.0 6.0 ");
        list2.sortedInsert(new DNode<Double>(6.0));
        list2.sortedInsert(new DNode<Double>(1.0));
        list2.sortedInsert(new DNode<Double>(3.0));
        list2.sortedInsert(new DNode<Double>(2.0));
        list2.sortedInsert(new DNode<Double>(5.0));
        list2.sortedInsert(new DNode<Double>(4.0));
        list2.print(); // should print "List content: 1.0 2.0 3.0 4.0 5.0 6.0  "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
    }
}
