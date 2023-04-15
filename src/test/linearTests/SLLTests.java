package test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

/**
 * This class provides a set of tests for the SLL class, which implements a
 * singly linked list.
 */

public class SLLTests {
    /**
     * The main method of this class runs a set of tests on the SLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING SINGLY LINKED LIST: PREV SHOULD BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        SLL list = new SLL();
        SNode<Integer> node = new SNode<Integer>(1);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n\n---LIST 1---");
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3 1 2");
        list.InsertHead(node);
        list.InsertTail(new SNode<Integer>(2));
        list.InsertHead(new SNode<Integer>(3));
        list.Print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5 3 4 1 2 6");
        list.Insert(new SNode<Integer>(4), 2);
        list.Insert(new SNode<Integer>(5), 1);
        list.Insert(new SNode<Integer>(6), 6);
        list.Print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected:  3 4 2 ");
        list.DeleteHead();
        list.DeleteTail();
        System.out.println("Search node: " + list.Search(node)); // should print "Search node: 1"
        list.Delete(node);
        list.Print(); // should print "List content: 3 4 2"
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list.Clear();
        list.Print(); // should print "List is empty"

        // SLL LIST2

        // Test sort
        System.out.println("\n\n---LIST 2---");
        System.out.println("\n-----------Testing constructor and sort: ");
        // Test constructor
        SLL list2 = new SLL(new SNode<Integer>(5));
        list2.Print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.InsertHead(new SNode<Integer>(4));
        list2.InsertHead(new SNode<Integer>(2));
        list2.InsertHead(new SNode<Integer>(3));
        list2.InsertHead(new SNode<Integer>(1));
        System.out.println("Before sort:");
        list2.Print(); // should print "List content: 1 3 2 4 5"
        list2.Sort();
        System.out.println("After sort:");
        list2.Print(); // should print "List content: 1 2 3 4 5"
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list2.Clear();
        list2.Print(); // should print "List is empty"

        // Test sortedInsert and sort
        System.out.println("\n-----------Testing sortedInsert, expected: 1 2 3 4 5 6");
        list2.SortedInsert(new SNode<Integer>(6));
        list2.SortedInsert(new SNode<Integer>(1));
        list2.SortedInsert(new SNode<Integer>(3));
        list2.SortedInsert(new SNode<Integer>(2));
        list2.SortedInsert(new SNode<Integer>(5));
        list2.SortedInsert(new SNode<Integer>(4));
        list2.Print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
    }
}
