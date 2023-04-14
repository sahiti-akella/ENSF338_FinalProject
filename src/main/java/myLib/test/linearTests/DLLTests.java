package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

/**
 * This class provides a set of tests for the DLL class, which implements a
 * doubly linked list.
 */

 public class DLLTests {
    /**
     * The main method of this class runs a set of tests on the DLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        DLL list = new DLL();
        DNode<Integer> node = new DNode<Integer>(1);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3 1 2");
        list.insertHead(node);
        list.insertTail(new DNode<Integer>(2));
        list.insertHead(new DNode<Integer>(3));
        list.print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5 3 4 1 2 6");
        list.insert(new DNode<Integer>(4), 2);
        list.insert(new DNode<Integer>(5), 1);
        list.insert(new DNode<Integer>(6), 6);
        list.print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3 4 2 ");
        list.deleteHead();
        list.deleteTail();
        System.out.println("Search node: " + list.search(node)); // should print "Search node: 1"
        list.delete(node);
        list.print(); // should print "List content: 3 4 2"
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
        DLL list2 = new DLL(new DNode<Integer>(5));
        list2.print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.insertHead(new DNode<Integer>(4));
        list2.insertHead(new DNode<Integer>(2));
        list2.insertHead(new DNode<Integer>(3));
        list2.insertHead(new DNode<Integer>(1));
        System.out.println("Before sort:");
        list2.print(); // should print "List content: 1 3 2 4 5"
        list2.sort();
        System.out.println("After sort:");
        list2.print(); // should print "List content: 1 2 3 4 5"
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list2.clear();
        list2.print(); // should print "List is empty"

        // Test sortedInsert and sort
        System.out.println("\n-----------Testing sortedInsert, expected: 1 2 3 4 5 6 ");
        list2.sortedInsert(new DNode<Integer>(6));
        list2.sortedInsert(new DNode<Integer>(1));
        list2.sortedInsert(new DNode<Integer>(3));
        list2.sortedInsert(new DNode<Integer>(2));
        list2.sortedInsert(new DNode<Integer>(5));
        list2.sortedInsert(new DNode<Integer>(4));
        list2.print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
    }
}
