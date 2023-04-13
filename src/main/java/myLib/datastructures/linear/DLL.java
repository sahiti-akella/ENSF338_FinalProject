package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class DLL{
    
    protected DNode head;
    public DNode tail;
    protected int size;

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
        }
    }
    
    public void deleteHead() {
        if (head != null) {
            // If the head is the only node in the list, set both head and tail to null
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            size--;
        }
    }
    
    public void deleteTail() {
        if (isEmpty()) {
            return;
        }
        if (tail.getPrev() == null) {
            // There is only one node in the list
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
    }
    
    public void delete(DNode node) {
        if (isEmpty()) {
            return;
        }
        if (head == node) { // if node is the head
            head = node.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            size--;
        } else if (tail == node) { // if node is the tail
            tail = node.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
            size--;
        } else { // if node is in the middle
            DNode prev = node.getPrev();
            DNode next = node.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrev(prev);
            }
            size--;
        }
    }
      
    public void clear() {
        while (head != null) {
            DNode next = head.getNext();
            head.setPrev(null);
            head.setNext(null);
            head = next;
        }
        tail = null;
        size = 0;
    }

    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
            // If the list is circular and we have reached the head again, break the loop
            if (current == head && tail != null && tail.getNext() == head) {
                break;
            }
        }
        return null;
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
        DNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (isCircular ? current != head : current != null);
        System.out.println();
    }
    
    public void sort() {
        if (size <= 1) {
            return;
        }
        DNode current = head.getNext();
        while (current != null) {
            DNode next = current.getNext();
            while (current.getPrev() != null && current.getData() < current.getPrev().getData()) {
                DNode prev = current.getPrev();
                DNode prevPrev = prev.getPrev();
                DNode currentNext = current.getNext();
                prev.setNext(currentNext);
                current.setNext(prev);
                current.setPrev(prevPrev);
                prev.setPrev(current);
                if (prevPrev != null) {
                    prevPrev.setNext(current);
                } else {
                    head = current;
                }
                if (currentNext != null) {
                    currentNext.setPrev(prev);
                } else {
                    tail = prev;
                }
            }
            current = next;
        }
    }

    public void sortedInsert(DNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (!isSorted()) {
            sort();
        }
        DNode current = head;
        while (current != null && current.getData() < node.getData()) {
            current = current.getNext();
        }
        if (current == null) {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        } else if (current == head) {
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        } else {
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        size++;
    }
    
    public boolean isSorted() {
        DNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    // helper function
    public boolean isEmpty() {
        return head == null;
    }

}
    

