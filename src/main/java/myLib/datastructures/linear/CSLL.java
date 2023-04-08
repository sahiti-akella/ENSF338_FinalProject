package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;
public class CSLL extends SLL {
    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        head.setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        if (size == 0) {
            node.setNext(node);
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (size == 0) {
            node.setNext(node);
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void deleteHead() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(head); // loop back to head node
        }
        size--;
    }

    @Override
    public void delete(SNode node) {
        if (size == 0) {
            return;
        }
        if (size == 1 && head.equals(node)) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if (head.equals(node)) {
            deleteHead();
            return;
        }
        SNode current = head;
        while (current.getNext() != head && !current.getNext().equals(node)) {
            current = current.getNext();
        }
        if (current.getNext().equals(head)) {
            return;
        }
        if (current.getNext().equals(tail)) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
    }

    @Override
    public void clear() {
        super.clear();
        if (head != null) {
            head.setNext(head);
        }
    }

    @Override
    public void print() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        SNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }
   
    // testing functions
    public static void main(String[] args) {  
        CSLL csList = new CSLL();

        SNode node = new SNode(6);

        csList.insertHead(new SNode(1));
        csList.insertHead(new SNode(2));
        csList.insertHead(new SNode(3));
        csList.insertHead(new SNode(5));
        csList.insertHead(node);
        csList.insertTail(new SNode(4));
        csList.print();
        //csList.deleteHead();
        //csList.print();
        csList.deleteTail();
        csList.print();
        csList.delete(node);
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
        csList.clear();
        csList.print();
       
        
    }  
}
