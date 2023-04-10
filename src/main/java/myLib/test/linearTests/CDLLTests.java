package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class CDLLTests {
    public static void main(String[] args) {
        CDLL list = new CDLL();

        DNode node = new DNode(1);
    
        // Test insertHead and insertTail
        System.out.println("\nTesting insertHead and insertTail, expected: 312");
        list.insertHead(node);
        list.insertTail(new DNode(2));
        list.insertHead(new DNode(3));
        list.print(); // should print "List content: 3 1 2 "
    
        // Test insert
        System.out.println("\nTesting insert, expected: 534126");
        list.insert(new DNode(4), 2);
        list.insert(new DNode(5), 1);
        list.insert(new DNode(6), 6);
        list.print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("Tail: " + list.tail);
        System.out.println("Tail next: " + list.tail.getNext());
    
        // Test search, deleteHead, deleteTail, and delete
        System.out.println("\nTesting search, deleteHead, deleteTail, and delete, expected: 342 ");
        list.deleteHead();
        list.deleteTail();
        list.delete(list.search(node));
        list.print(); // should print "List content: 3 4 2 "
    
        // Test clear and print
        System.out.println("\nTesting clear and print, expected: List is empty ");
        list.clear();
        list.print(); // should print "List is empty"

        // Test sort, checking if tail next is head
        System.out.println("\nTesting sort, checking if tail next is head: ");
        CDLL list2 = new CDLL(new DNode(5));
        list2.insertHead(new DNode(4));
        list2.insertHead(new DNode(2));
        list2.insertHead(new DNode(3));
        list2.insertHead(new DNode(1));
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
        list.sortedInsert(new DNode(6));
        list.sortedInsert(new DNode(1));
        list.sortedInsert(new DNode(3));
        list.sortedInsert(new DNode(2));
        list.sortedInsert(new DNode(5));
        list.sortedInsert(new DNode(4));
        list.print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("Tail: " + list.tail);
        System.out.println("Tail next: " + list.tail.getNext());
        
    }
}
