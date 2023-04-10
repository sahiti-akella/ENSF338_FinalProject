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

    public void insert(SNode node, int position) {
        super.insert(node, position);
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

    public void delete(SNode node) {
        super.delete(node);
    }

    public SNode search(SNode node) {
        return super.search(node);
    }    

    public void clear() {
        super.clear();
    }

    public void print() {
       super.print();
    }
   
    @Override
    public void sortedInsert(SNode node) {
        if (head == null) {
            node.setNext(node);
            head = node;
            tail = node;
        } else if (node.getData() < head.getData()) {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        } else {
            SNode current = head;
            while (current.getNext() != head && node.getData() > current.getNext().getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            if (current == tail) {
                tail = node;
            }
        }
    
        size++;
        if (!isSorted()) {
            sort();
        }
    }    

    @Override
    public void sort() {
        if (head == null || head.getNext() == head) {
            return;
        }
    
        SNode current = head;
        do {
            boolean sorted = true;
            SNode temp = current.getNext();
            while (temp != head && temp != current) {
                if (current.getData() > temp.getData()) {
                    swap(current, temp);
                    sorted = false;
                }
                temp = temp.getNext();
            }
            if (sorted) {
                break;
            }
            current = current.getNext();
        } while (current != head);
    }
    
    // helper functions
    @Override
    protected boolean isSorted() {
        if (head == null || head.getNext() == head) {
            return true;
        }
        
        SNode current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    private void swap(SNode node1, SNode node2) {
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }
    
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
}