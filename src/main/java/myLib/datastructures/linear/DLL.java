package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class DLL{
    
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public DLL(DNode node) {
        head = node;
        tail = node;
        size = 1;
    }

    public void insertHead(DNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
        size++;
    }

    public void insertTail(DNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(tail);
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        }
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
        size++;
    }
    
    public void insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
            // If the list is circular, set the tail's next reference to the head
            if (tail != null && tail.getNext() != head) {
                tail.setNext(head);
                head.setPrev(tail);
            }
        }
    }
    
    

    public void print() {
        //System.out.println("List Length: " + size);
        //System.out.println("Sorted: " + isSorted());
        System.out.print("List Content: ");
    
        if (isEmpty()) {
            System.out.println("empty");
        } else {
            DNode curr = head;
            do {
                System.out.print(curr.getData() + " ");
                curr = curr.getNext();
            } while (curr != head);
            System.out.println();
        }
    }
    

    // helper function
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {  
  
        DLL dList = new DLL();  

        System.out.println("\nTESTING INSERTING, DELETING AND SORTING: ");  

        System.out.println("\nInserting nodes: ");  
        dList.insertTail(new DNode(3));
        dList.insertTail(new DNode(2));
        dList.insertHead(new DNode(1));  
        dList.insert(new DNode(4), 3);
        dList.print();
    }
}
