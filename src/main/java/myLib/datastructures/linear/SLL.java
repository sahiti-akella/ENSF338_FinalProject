package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class SLL {

    protected SNode head;
    protected SNode tail;
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
        while (current != null) {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
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
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        SNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
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

    // testing functions
    public static void main(String[] args) {  
  
        SLL sList = new SLL();  
        SNode validSearch = new SNode(4);
        SNode invalidSearch = new SNode(8);
  
        System.out.println("Adding nodes to the end of the list: ");  
        sList.insertTail(new SNode(1));  
        sList.print();
        System.out.println("\n");  
  
        System.out.println("Adding nodes to the end of the list: ");  
        sList.insertTail(new SNode(3));  
        sList.print();  
        System.out.println("\n");  
  
        System.out.println("Adding nodes to the end of the list: ");  
        sList.insertTail(validSearch);  
        sList.print();
        System.out.println("\n");  
  
        System.out.println("Adding nodes to the end of the list: ");  
        sList.insertTail(new SNode(7));  
        sList.print();
        System.out.println("\n");  

        System.out.println("Adding nodes to the start of the list: ");  
        sList.insertHead(new SNode(2));  
        sList.print();
        System.out.println("\n");  

        System.out.println("Adding nodes to specified position in the list: ");  
        sList.insert(new SNode(5), 3);  
        sList.print();
        System.out.println("\n");  

        System.out.println("Sort and insert node in the list: ");  
        sList.sortedInsert(new SNode(6));  
        sList.print();
        System.out.println("\n");  

        System.out.println("Finding node..");
        SNode node1 = sList.search(validSearch);  
        System.out.println(node1);
        System.out.println("\n");  

        System.out.println("Finding non existent node..");
        SNode node2 = sList.search(invalidSearch);  
        System.out.println(node2);
        System.out.println("\n");  

        System.out.println("Deleting head");
        sList.deleteHead(); 
        sList.print();
        System.out.println("\n");  

        System.out.println("Deleting tail");
        sList.deleteTail(); 
        sList.print();
        System.out.println("\n");  

        System.out.println("Deleting specified node");
        sList.delete(validSearch); 
        sList.print();
        System.out.println("\n");  

        System.out.println("Clearing entire list");
        sList.clear(); 
        sList.print();
        System.out.println("\n");  

    }  
}  
    

