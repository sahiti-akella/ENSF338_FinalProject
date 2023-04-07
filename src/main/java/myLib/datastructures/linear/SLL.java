package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class SLL {

    private SNode head;
    private SNode tail;
    private int size;

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

    public void search(SNode node){
        // Implement
    }

    public void deleteHead(){
        // Implement
    }

    public void deleteTail(){
        // Implement
    }

    public void delete(SNode node){
        // Implement
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
        // Implement
    }

    public void print(){
        // Implement
    }


    // helper functions
    private boolean isSorted() {
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
    public void display() {  
        //Node current will point to head  
        SNode current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Adding nodes to the end of the list: ");  
        while(current != null) {  
            //Prints each node by incrementing pointer  
            System.out.print(current.getData() + " ");  
            current = current.getNext();  
        }  
        System.out.println();  
    }  
  
    public static void main(String[] args) {  
  
        SLL sList = new SLL();  
  
        //Adding 1 to the list  
        sList.insertTail(new SNode(1));  
        sList.display();  
  
        //Adding 2 to the list  
        sList.insertTail(new SNode(3));  
        sList.display();  
  
        //Adding 3 to the list  
        sList.insertTail(new SNode(4));  
        sList.display();  
  
        //Adding 4 to the list  
        sList.insertTail(new SNode(7));  
        sList.display();  

        sList.insert(new SNode(5), 3);  
        sList.display();

        sList.sortedInsert(new SNode(6));  
        sList.display();

    }  
}  
    

