package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class SLL {

    protected SNode head;
    public SNode tail;
    protected int size;

    public SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        tail = head;
        size = 1; // CHANGE TO INCREMENT
    }

    public void insertHead(SNode node) {
       if (head == null) {
        head = node;
        tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
      if (head == null) {
        head = node;
        tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position){
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position for insertion");
        }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 2; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public void sortedInsert(SNode node){
        if (head == null || node.getData() < head.getData()) {
            insertHead(node);
        } else {
            SNode current = head;
            while (current.getNext() != null && node.getData() > current.getNext().getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
        
        if (!isSorted()) {
            sort();
        }
    }

    public SNode search(SNode node){
        SNode current = head;
        boolean isCircular = false;
        while (current != null && !isCircular) {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
            if (current == head) {
                isCircular = true;
            }
        }
        return null;
    }

    public void deleteHead(){
        if (head == null) {
            return;
        }
        head = head.getNext();
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public void deleteTail(){
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        SNode current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        size--;
    }
    
    public void delete(SNode node){
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            deleteHead();
            return;
        }
        if (tail.equals(node)) {
            deleteTail();
            return;
        }
        SNode current = head;
        while (current.getNext() != null && !current.getNext().equals(node)) {
        current = current.getNext();
        }
        if (current.getNext() == null) {
        return;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
        tail = current;
        }
        size--;
    }

    public void sort(){
        if (head == null || head.getNext() == null) {
            return;
        }
        
        SNode newHead = null;
        SNode current = head;
        while (current != null) {
            SNode next = current.getNext();
            if (newHead == null || current.getData() < newHead.getData()) {
                current.setNext(newHead);
                newHead = current;
            } else {
                SNode search = newHead;
                while (search.getNext() != null && current.getData() > search.getNext().getData()) {
                    search = search.getNext();
                }
                current.setNext(search.getNext());
                search.setNext(current);
            }
            current = next;
        }
        
        head = newHead;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        boolean isCircular = (tail != null && tail.getNext() == head);
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        SNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (isCircular ? current != head : current != null);
        System.out.println();
    }

    // helper functions
    protected boolean isSorted() {
        SNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
<<<<<<< HEAD

    // testing
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
    

/* 
    // testing functions
    public static void main(String[] args) {  
  
        SLL sList = new SLL();  
        SNode validSearch = new SNode(4);
        SNode invalidSearch = new SNode(8);
        SNode nodeToDelete = new SNode(7);

        System.out.println("\nTESTING INSERTING, DELETING AND SORTING: ");  

        System.out.println("\nInserting nodes to tail: 7 ");  
        sList.insertTail(nodeToDelete);  
        sList.print();
  
        System.out.println("\nInserting nodes to tail: 3 ");  
        sList.insertTail(new SNode(3));  
        sList.print();  
  
        System.out.println("\nInserting nodes to tail: 2 ");  
        sList.insertTail(new SNode(2));  
        sList.print();
  
        System.out.println("\nInserting nodes to tail: 9 ");  
        sList.insertTail(new SNode(9));  
        sList.print();

        System.out.println("\nInserting nodes to head: 4 ");  
        sList.insertHead(validSearch);  
        sList.print();

        System.out.println("\nSorted insert nodes: 6 ");  
        sList.sortedInsert(new SNode(6));  
        sList.print();

        System.out.println("\nInserting nodes: 5 at position 3");  
        sList.insert(new SNode(5), 3);  
        sList.print();

        System.out.println("\nDeleting node: 7");
        sList.delete(nodeToDelete); 
        sList.print();

        System.out.println("\nDeleting head: ");
        sList.deleteHead(); 
        sList.print();

        System.out.println("\nDeleting tail: ");
        sList.deleteTail(); 
        sList.print();

        System.out.println("\nTESTING SEARCHING AND CLEARING: ");  

        System.out.println("\nFinding node 4 ..");
        SNode node1 = sList.search(validSearch);  
        System.out.println("Node (null if not found): " + node1);

        System.out.println("\nFinding non existent node..");
        SNode node2 = sList.search(invalidSearch);  
        System.out.println("Node (null if not found): " + node2);

        System.out.println("\nClearing list: ");
        sList.clear(); 
        sList.print();
        System.out.println("\n");  

    }  
*/

=======
>>>>>>> fef67f0561dcc513bfe5def12ab776084a610922
}  
    

