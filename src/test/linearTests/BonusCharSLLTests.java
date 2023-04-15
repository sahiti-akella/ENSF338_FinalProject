package test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

/**
 * This class provides a set of tests for the BonusCharSLL class, which implements a
 * singly linked list.
 */

public class BonusCharSLLTests {
    /**
     * The main method of this class runs a set of tests on the BonusCharSLL class.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTESTING SINGLY LINKED LIST: PREV SHOULD BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        BonusCharSLL list = new BonusCharSLL();
        SNode<Character> node = new SNode<Character>('a');

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n\n---LIST 1---");
        System.out.println("\n-----------Testing insertHead and insertTail, expected: c a b");
        list.InsertHead(node);
        list.InsertTail(new SNode<Character>('b'));
        list.InsertHead(new SNode<Character>('c'));
        list.Print(); // should print "List content: c a b "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: e c d a b f");
        list.Insert(new SNode<Character>('d'), 2);
        list.Insert(new SNode<Character>('e'), 1);
        list.Insert(new SNode<Character>('f'), 6);
        list.Print(); // should print "List content: e c d a b f "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: c d b ");
        list.DeleteHead();
        list.DeleteTail();
        System.out.println("Search node: " + list.Search(node)); // should print "Search node: a"
        list.Delete(node);
        list.Print(); // should print "List content: c d b"
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
        BonusCharSLL list2 = new BonusCharSLL(new SNode<Character>('e'));
        list2.Print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.InsertHead(new SNode<Character>('d'));
        list2.InsertHead(new SNode<Character>('b'));
        list2.InsertHead(new SNode<Character>('c'));
        list2.InsertHead(new SNode<Character>('a'));
        System.out.println("Before sort:");
        list2.Print(); // should print "List content: a c b d e"
        list2.Sort();
        System.out.println("After sort:");
        list2.Print(); // should print "List content: a b c d e"
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list2.Clear();
        list2.Print(); // should print "List is empty"

        
        // Test sortedInsert and sort
        System.out.println("\n-----------Testing sortedInsert, expected: a b c d e f");
        list2.SortedInsert(new SNode<Character>('f'));
        list2.SortedInsert(new SNode<Character>('a'));
        list2.SortedInsert(new SNode<Character>('c'));
        list2.SortedInsert(new SNode<Character>('b'));
        list2.SortedInsert(new SNode<Character>('e'));
        list2.SortedInsert(new SNode<Character>('d'));
        list2.Print(); // should print "List content: a b c d e f "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
        
    }
}
