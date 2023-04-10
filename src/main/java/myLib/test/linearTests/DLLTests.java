package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class DLLTests {
    public static void main(String[] args) {
        DLL list = new DLL();

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
        list.sortedInsert(new DNode(6));
        list.sortedInsert(new DNode(1));
        list.sortedInsert(new DNode(3));
        list.sortedInsert(new DNode(2));
        list.sortedInsert(new DNode(5));
        list.sortedInsert(new DNode(4));
        list.print(); // should print "List content: 1 2 3 4 5 6 "
        
    }
}
