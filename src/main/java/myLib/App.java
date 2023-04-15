package main.java.myLib;
import java.util.Scanner;

import main.java.myLib.datastructures.linear.BonusCharSLL;
import main.java.myLib.datastructures.linear.BonusDoubleDLL;
import main.java.myLib.datastructures.linear.CDLL;
import main.java.myLib.datastructures.linear.CSLL;
import main.java.myLib.datastructures.linear.DLL;
import main.java.myLib.datastructures.linear.QueueLL;
import main.java.myLib.datastructures.linear.SLL;
import main.java.myLib.datastructures.linear.StackLL;
import main.java.myLib.datastructures.nodes.DNode;
import main.java.myLib.datastructures.nodes.SNode;
import main.java.myLib.datastructures.nodes.TNode;
import main.java.myLib.datastructures.trees.AVL;
import main.java.myLib.datastructures.trees.BST;


public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("Choose an option:");
            System.out.println("1. Test SLL");
            System.out.println("2. Test DLL");
            System.out.println("3. Test CSLL");
            System.out.println("4. Test CDLL");
            System.out.println("5. Test StackLL");
            System.out.println("6. Test QueueLL");
            System.out.println("7. Test BST");
            System.out.println("8. Test AVL");
            System.out.println("9. Test Bonus Char SLL");
            System.out.println("10. Test Bonus Double DLL");
            System.out.println("11. Exit");
            System.out.print("Enter a number: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Running SLL Tests");
                    testSLL();
                    break;

                case 2:
                    System.out.println("Running DLL Tests");
                    testDLL();
                    break;

                case 3:
                    System.out.println("Running CSLL Tests");
                    testCSLL();
                    break;

                case 4:
                    System.out.println("Running CDLL Tests");
                    testCDLL();
                    break;

                case 5:
                    System.out.println("Running StackLL Tests");
                    testStackLL();
                    break;

                case 6:
                    System.out.println("Running QueueLL Tests");
                    testQueueLL();
                    break;

                case 7:
                    System.out.println("Running BST Tests");
                    testBST();
                    break;

                case 8:
                    System.out.println("Running AVL Tests");
                    testAVL();
                    break;

                case 9:
                    System.out.println("Running Bonus Char SLL Tests");
                    testBonusCharSLLTests();
                    break;

                case 10:
                    System.out.println("Running Bonus Double DLLTests");
                    testBonusDoubleDLLTests();
                    break;

                case 11:
                    System.out.println("Quitting Program");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        input.close();
    }

    private static void testCSLL() {
        System.out.println("\nTESTING CIRCULAR SINGLY LINKED LIST: PREV SHOULD BE NULL AND TAIL NEXT SHOULD BE HEAD");

        // Empty constructor
        CSLL list = new CSLL();
        SNode<Integer> node = new SNode<Integer>(1);

        // CSLL LIST

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
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3 4 2 ");
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

        // CSLL LIST2

        // Test sort
        System.out.println("\n\n---LIST 2---");
        System.out.println("\n-----------Testing constructor and sort: ");
        // Test constructor
        CSLL list2 = new CSLL(new SNode<Integer>(5));
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



    private static void testCDLL() {
    
        System.out.println("\nTESTING CIRCULAR DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD NOT BE NULL");

        // Empty constructor
        CDLL list = new CDLL();
        DNode<Integer> node = new DNode<Integer>(1);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n\n---LIST 1---");
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3 1 2");
        list.InsertHead(node);
        list.InsertTail(new DNode<Integer>(2));
        list.InsertHead(new DNode<Integer>(3));
        list.Print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5 3 4 1 2 6");
        list.Insert(new DNode<Integer>(4), 2);
        list.Insert(new DNode<Integer>(5), 1);
        list.Insert(new DNode<Integer>(6), 6);
        list.Print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3 4 2 ");
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
        CDLL list2 = new CDLL(new DNode<Integer>(5));
        list2.Print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.InsertHead(new DNode<Integer>(4));
        list2.InsertHead(new DNode<Integer>(2));
        list2.InsertHead(new DNode<Integer>(3));
        list2.InsertHead(new DNode<Integer>(1));
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
        list2.SortedInsert(new DNode<Integer>(6));
        list2.SortedInsert(new DNode<Integer>(1));
        list2.SortedInsert(new DNode<Integer>(3));
        list2.SortedInsert(new DNode<Integer>(2));
        list2.SortedInsert(new DNode<Integer>(5));
        list2.SortedInsert(new DNode<Integer>(4));
        list2.Print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());


    }

    private static void testDLL() {
        System.out.println("\nTESTING DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        DLL list = new DLL();
        DNode<Integer> node = new DNode<Integer>(1);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n\n---LIST 1---");
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3 1 2");
        list.InsertHead(node);
        list.InsertTail(new DNode<Integer>(2));
        list.InsertHead(new DNode<Integer>(3));
        list.Print(); // should print "List content: 3 1 2 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5 3 4 1 2 6");
        list.Insert(new DNode<Integer>(4), 2);
        list.Insert(new DNode<Integer>(5), 1);
        list.Insert(new DNode<Integer>(6), 6);
        list.Print(); // should print "List content: 5 3 4 1 2 6 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3 4 2 ");
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
        DLL list2 = new DLL(new DNode<Integer>(5));
        list2.Print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.InsertHead(new DNode<Integer>(4));
        list2.InsertHead(new DNode<Integer>(2));
        list2.InsertHead(new DNode<Integer>(3));
        list2.InsertHead(new DNode<Integer>(1));
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
        System.out.println("\n-----------Testing sortedInsert, expected: 1 2 3 4 5 6 ");
        list2.SortedInsert(new DNode<Integer>(6));
        list2.SortedInsert(new DNode<Integer>(1));
        list2.SortedInsert(new DNode<Integer>(3));
        list2.SortedInsert(new DNode<Integer>(2));
        list2.SortedInsert(new DNode<Integer>(5));
        list2.SortedInsert(new DNode<Integer>(4));
        list2.Print(); // should print "List content: 1 2 3 4 5 6 "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());
       

       
      
      
    }

    private static void testStackLL() {
       
        StackLL stack = new StackLL();
        
        System.out.println("Testing empty constructor...");
        stack.Print(); 
        
        System.out.println("\nTesting constructor with argument node...");
        SNode<Integer> node1 = new SNode<Integer>(1);
        stack = new StackLL(node1);
        stack.Print(); 
        
        // Test push method
        System.out.println("\nTesting push method...");
        SNode<Integer> node2 = new SNode<Integer>(2);
        SNode<Integer> node3 = new SNode<Integer>(3);
        stack.Push(node2);
        stack.Push(node3);
        stack.Print(); 
        
        // Test pop method
        System.out.println("\nTesting pop method...");
        SNode<Integer> popped = stack.Pop();
        System.out.println("Popped node: " + popped.getData()); 
        stack.Print(); 
        
        // Test peek method
        System.out.println("\nTesting peek method...");
        SNode<Integer> peeked = stack.Peek();
        System.out.println("Peeked node: " + peeked.getData()); 
        
        // Test search method
        System.out.println("\nTesting search method...");
        SNode<Integer> node4 = new SNode<Integer>(4);
        SNode<Integer> found = stack.Search(node1);
        System.out.println("Found node: " + found.getData()); 
        found = stack.Search(node4);
        System.out.println("Found node: " + found); 
        
        System.out.println("\nTesting clear method...");
        stack.Clear();
        stack.Print(); 
      
    }

    private static void testQueueLL() {
          // create an empty queue
          QueueLL queue = new QueueLL();

          // enqueue some nodes
          queue.Enqueue(new SNode<>(1));
          queue.Enqueue(new SNode<>(2));
          queue.Enqueue(new SNode<>(3));
  
          // peek at the head node
          System.out.println("Head node: " + queue.peek());
  
          // dequeue some nodes
          System.out.println("Dequeued node: " + queue.Dequeue().getData());
          System.out.println("Dequeued node: " + queue.Dequeue().getData());
  
          // enqueue some more nodes
          queue.Enqueue(new SNode<>(4));
          queue.Enqueue(new SNode<>(5));
  
          // print the queue
          System.out.print("Queue: ");
          printQueue(queue);
  
          // clear the queue
          queue.Clear();
  
          // print the queue
          System.out.print("Queue: ");
          printQueue(queue);
      }
  
      private static void printQueue(QueueLL queue) {
          SNode<Integer> node = queue.peek();
          while (node != null) {
              System.out.print(node.getData() + " ");
              node = node.getNext();
          }
          System.out.println();
       
    }

    private static void testSLL() {
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




    private static void testBST() {
        BST bst = new BST();
    
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(13);
        bst.Insert(10);
        bst.Insert(3);
        bst.Insert(1);
        bst.Insert(8);
        bst.Insert(12);
        bst.Insert(15);
        
        System.out.println("Root node: " + bst.getRoot().getData());
        
        System.out.print("In-order traversal: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal:");
        bst.printBF();
    
        System.out.println("Searching for value 10...");
        TNode result = bst.Search(10);
        if (result != null) {
            System.out.println("Value found: " + result.getData());
        } else {
            System.out.println("Value not found in the tree.");
        }
    
        System.out.println("Deleting values 7 and 10...");
        bst.Delete(7);
        bst.Delete(10);
    
        System.out.println("Root node after deletion: " + bst.getRoot().getData());
 
        System.out.print("In-order traversal after deletion: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
   
        System.out.println("Breadth-first traversal after deletion:");
        bst.printBF();
    
        bst.Insert(6);
    
        System.out.println("Root node after insertion: " + bst.getRoot().getData());
    
        System.out.print("In-order traversal after insertion: ");
        bst.printInOrder(bst.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal after insertion:");
        bst.printBF();

        BST bst1 = new BST(new TNode(20, 0, null, null, null));

        bst1.Insert(6);
        bst1.Insert(23);
        bst1.Insert(14);
        bst1.Insert(19);
        bst1.Insert(8);

        System.out.println("Root node: " + bst1.getRoot().getData());
        
        System.out.print("In-order traversal: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal:");
        bst1.printBF();
    
        System.out.println("Searching for value 10...");
        TNode result1 = bst1.Search(10);
        if (result1 != null) {
            System.out.println("Value found: " + result1.getData());
        } else {
            System.out.println("Value not found in the tree.");
        }
    
        System.out.println("Deleting values 6 and 8...");
        bst1.Delete(6);
        bst1.Delete(8);
    
        System.out.println("Root node after deletion: " + bst1.getRoot().getData());
 
        System.out.print("In-order traversal after deletion: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
   
        System.out.println("Breadth-first traversal after deletion:");
        bst1.printBF();
    
        bst1.Insert(6);
    
        System.out.println("Root node after insertion: " + bst1.getRoot().getData());
    
        System.out.print("In-order traversal after insertion: ");
        bst1.printInOrder(bst1.getRoot());
        System.out.println();
    
        System.out.println("Breadth-first traversal after insertion:");
        bst1.printBF();
    }



    private static void testAVL() {
        AVL avl = new AVL(30);

        // insert some nodes into the tree
        avl.Insert(9);
        avl.Insert(20);
        avl.Insert(79);
        avl.Insert(5);
        avl.Insert(16);
        avl.Insert(8);

        
        System.out.println("\nPrinting in Breadth First Order:");
        avl.printBF();

        TNode node = new TNode(50);
        node.setLeft(new TNode(30));
        node.getLeft().setLeft(new TNode(20));
        node.getLeft().setRight(new TNode(40));
        node.setRight(new TNode(70));
        node.getRight().setLeft(new TNode(60));
        node.getRight().setRight(new TNode(80));

        AVL balancedTree = new AVL(node);
   
        System.out.println("\nPrinting in Breadth First Order:");
        balancedTree.printBF();

        avl.Delete(14);

        TNode nodetosearch = avl.Search(40);
        if (nodetosearch  != null) {
            System.out.println("\nSearch for 40: \n" + nodetosearch.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }

        TNode nodetosearch2 = avl.Search(79);
        if (nodetosearch2  != null) {
            System.out.println("\nSearch for 79: \n" + nodetosearch2.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }
    }

    private static void testBonusCharSLLTests(){
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

    private static void testBonusDoubleDLLTests(){
        System.out.println("\nTESTING DOUBLY LINKED LIST: PREV SHOULD NOT BE NULL AND TAIL NEXT SHOULD BE NULL");

        // Empty constructor
        BonusDoubleDLL list = new BonusDoubleDLL();
        DNode<Double> node = new DNode<Double>(1.0);

        // SLL LIST

        // Test insertHead and insertTail
        System.out.println("\n\n---LIST 1---");
        System.out.println("\n-----------Testing insertHead and insertTail, expected: 3.0 1.0 2.0");
        list.InsertHead(node);
        list.InsertTail(new DNode<Double>(2.0));
        list.InsertHead(new DNode<Double>(3.0));
        list.Print(); // should print "List content: 3.0 1.0 2.0 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test insert
        System.out.println("\n-----------Testing insert, expected: 5.0 3.0 4.0 1.0 2.0 6.0");
        list.Insert(new DNode<Double>(4.0), 2);
        list.Insert(new DNode<Double>(5.0), 1);
        list.Insert(new DNode<Double>(6.0), 6);
        list.Print(); // should print "List content: 5.0 3.0 4.0 1.0 2.0 6.0 "
        System.out.println("\nTail: " + list.tail);
        System.out.println("Tail prev: " + list.tail.getPrev());
        System.out.println("Tail next: " + list.tail.getNext());

        // Test sort, search, deleteHead, deleteTail, and delete
        System.out.println("\n-----------Testing search, deleteHead, deleteTail, and delete, expected: 3.0 4.0 2.0 ");
        list.DeleteHead();
        list.DeleteTail();
        System.out.println("Search node: " + list.Search(node)); // should print "Search node: 1.0"
        list.Delete(node);
        list.Print(); // should print "List content: 3.0 4.0 2.0"
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
        BonusDoubleDLL list2 = new BonusDoubleDLL(new DNode<Double>(5.0));
        list2.Print();
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext() + "\n");
        list2.InsertHead(new DNode<Double>(4.0));
        list2.InsertHead(new DNode<Double>(2.0));
        list2.InsertHead(new DNode<Double>(3.0));
        list2.InsertHead(new DNode<Double>(1.0));
        System.out.println("Before sort:");
        list2.Print(); // should print "List content: 1.0 3.0 2.0 4.0 5.0"
        list2.Sort();
        System.out.println("After sort:");
        list2.Print(); // should print "List content: 1.0 2.0 3.0 4.0 5.0"
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

        // Test clear and print
        System.out.println("\n-----------Testing clear and print, expected: List is empty ");
        list2.Clear();
        list2.Print(); // should print "List is empty"

        // Test sortedInsert and sort
        System.out.println("\n-----------Testing sortedInsert, expected: 1.0 2.0 3.0 4.0 5.0 6.0 ");
        list2.SortedInsert(new DNode<Double>(6.0));
        list2.SortedInsert(new DNode<Double>(1.0));
        list2.SortedInsert(new DNode<Double>(3.0));
        list2.SortedInsert(new DNode<Double>(2.0));
        list2.SortedInsert(new DNode<Double>(5.0));
        list2.SortedInsert(new DNode<Double>(4.0));
        list2.Print(); // should print "List content: 1.0 2.0 3.0 4.0 5.0 6.0  "
        System.out.println("\nTail: " + list2.tail);
        System.out.println("Tail prev: " + list2.tail.getPrev());
        System.out.println("Tail next: " + list2.tail.getNext());

    }
    
    }
   
    


   







