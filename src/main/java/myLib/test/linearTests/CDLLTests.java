package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;
/**
 * This class provides a set of tests for the CDLL class, which implements a
 * circular doubly linked list.
 */

 public class CDLLTests {
    /**
     * The main method of this class runs a set of tests on the SLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING CIRCULAR DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD NOT BE NULL");

        // Empty constructor
        CDLL list = new CDLL();
        DNode node = new DNode(1);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 312");
        list.insertHead(node);
        list.insertTail(new DNode(2));
        list.insertHead(new DNode(3));
        list.print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 534126");
        list.insert(new DNode(4), 2);
        list.insert(new DNode(5), 1);
        list.insert(new DNode(6), 6);
        list.print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 342 ");
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
        CDLL list2 = new CDLL(new DNode(5));
        list2.print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.insertHead(new DNode(4));
        list2.insertHead(new DNode(2));
        list2.insertHead(new DNode(3));
        list2.insertHead(new DNode(1));
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
        System.out.println("\n-----------Testing sortedInsert, expected: 123456");
        list2.sortedInsert(new DNode(6));
        list2.sortedInsert(new DNode(1));
        list2.sortedInsert(new DNode(3));
        list2.sortedInsert(new DNode(2));
        list2.sortedInsert(new DNode(5));
        list2.sortedInsert(new DNode(4));
        list2.print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
    }
}
