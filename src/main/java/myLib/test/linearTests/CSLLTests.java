package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

/**
 * This class provides a set of tests for the CSLL class, which implements a
 * circular singly linked list.
 */

public class CSLLTests {
    /**
     * The main method of this class runs a set of tests on the CSLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING CIRCULAR SINGLY LINKED LIST: PREV SHOULD BE NULL AND TAIL NEXT SHOULD BE HEAD");

        // Empty constructor
        CSLL list = new CSLL();
        SNode node = new SNode(1);

        // CSLL LIST

        // Test insertHead and insertTail
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3 1 2");
        list.insertHead(node);
        list.insertTail(new SNode(2));
        list.insertHead(new SNode(3));
        list.print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5 3 4 1 2 6");
        list.insert(new SNode(4), 2);
        list.insert(new SNode(5), 1);
        list.insert(new SNode(6), 6);
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

        // CSLL LIST2

        // Test sort
        System.out.println("\n-----------Testing constructor and sort: ");
        // Test constructor
        CSLL list2 = new CSLL(new SNode(5));
        list2.print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.insertHead(new SNode(4));
        list2.insertHead(new SNode(2));
        list2.insertHead(new SNode(3));
        list2.insertHead(new SNode(1));
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
        System.out.println("\n-----------Testing sortedInsert, expected: 1 2 3 4 5 6");
        list2.sortedInsert(new SNode(6));
        list2.sortedInsert(new SNode(1));
        list2.sortedInsert(new SNode(3));
        list2.sortedInsert(new SNode(2));
        list2.sortedInsert(new SNode(5));
        list2.sortedInsert(new SNode(4));
        list2.print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
    }
}
