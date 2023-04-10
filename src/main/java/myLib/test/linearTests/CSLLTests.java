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
    
        // Test sortedInsert and sort
        System.out.println("\nTesting sortedInsert and sort, expected: 123456");
        list.sortedInsert(new SNode(6));
        list.sortedInsert(new SNode(1));
        list.sortedInsert(new SNode(3));
        list.sortedInsert(new SNode(2));
        list.sortedInsert(new SNode(5));
        list.sortedInsert(new SNode(4));
        list.print(); // should print "List content: 1 2 3 4 5 6 "
    }
}
