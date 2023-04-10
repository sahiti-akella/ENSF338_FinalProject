package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class CSLLTests {
    public static void main(String[] args) {
        CSLL list = new CSLL();

        SNode node = new SNode(1);
    
        // Test insertHead and insertTail
        System.out.println("\nTesting insertHead and insertTail, expected: 312");
        list.insertHead(node);
        list.insertTail(new SNode(2));
        list.insertHead(new SNode(3));
        list.print(); // should print "List content: 3 1 2 "
    
        // Test insert
        System.out.println("\nTesting insert, expected: 534126");
        list.insert(new SNode(4), 2);
        list.insert(new SNode(5), 1);
        list.insert(new SNode(6), 6);
        list.print(); // should print "List content: 5 3 4 1 2 6 "
    
        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\nTesting sort, search, deleteHead, deleteTail, and delete, expected: 234 ");
        list.deleteHead();
        list.deleteTail();
        list.delete(list.search(node));
        list.print(); // should print "List content: 2 3 4 "
    
        // Test clear and print
        System.out.println("\nTesting clear and print, expected: List is empty ");
        list.clear();
        list.print(); // should print "List is empty"

        // Testing sort, checking if tail next is head
        System.out.println("\nTesting sort, checking if tail next is head: ");
        CSLL list2 = new CSLL(new SNode(5));
        list2.insertHead(new SNode(4));
        list2.insertHead(new SNode(2));
        list2.insertHead(new SNode(3));
        list2.insertHead(new SNode(1));
        System.out.println("Before sort:");
        list2.print(); // should print "List content: 1 3 2 4 5"
        list2.sort();
        System.out.println("After sort:");
        list2.print(); // should print "List content: 1 2 3 4 5"
        /* 
        System.out.println("Tail: " + list.tail);
        System.out.println("Tail next: " + list.tail.getNext());
        */

        // Test clear and print
        System.out.println("\nTesting clear and print, expected: List is empty ");
        list.clear();
        list.print(); // should print "List is empty"

        // Test sortedInsert and sort, checking if tail next is head
        System.out.println("\nTesting sortedInsert and sort, checking if tail next is head, expected: 123456");
        list.sortedInsert(new SNode(6));
        list.sortedInsert(new SNode(1));
        list.sortedInsert(new SNode(3));
        list.sortedInsert(new SNode(2));
        list.sortedInsert(new SNode(5));
        list.sortedInsert(new SNode(4));
        list.print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("Tail: " + list.tail);
        System.out.println("Tail next: " + list.tail.getNext());
    }
}
