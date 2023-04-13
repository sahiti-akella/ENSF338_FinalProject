package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class CDLL extends DLL{
    public CDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public CDLL(DNode node) {
        head = node;
        tail = node;
        head.setPrev(tail);
        tail.setNext(head);
        size = 1; 
    }

    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }
    
    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
    public void deleteHead() {
        super.deleteHead();
       // If the list is circular, set the tail's next reference to the head
       if (tail != null && tail.getNext() != head) {
        tail.setNext(head);
        head.setPrev(tail);
    }
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
    public void delete(DNode node) {
       super.delete(node);
       // update tail's next reference if the list is circular
       if (tail != null && tail.getNext() != head) {
        tail.setNext(head);
        head.setPrev(tail);
        }
    }
    
    public void clear(){
        super.clear();
    }

    public DNode search(DNode node) {
       return super.search(node);
       
    }

    public void print(){
        super.print();
    }
    
    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        DNode current = head.getNext();
        while (current != head) {
            DNode temp = current;
            while (temp.getPrev() != null && temp.getData() < temp.getPrev().getData()) {
                DNode prev = temp.getPrev();
                DNode next = temp.getNext();
                if (prev.getPrev() != null) {
                    prev.getPrev().setNext(temp);
                } else {
                    head = temp;
                }
                temp.setPrev(prev.getPrev());
                temp.setNext(prev);
                prev.setPrev(temp);
                prev.setNext(next);
                if (next != null) {
                    next.setPrev(prev);
                } else {
                    tail = prev;
                }
            }
            current = current.getNext();
        }
    }
    
    @Override
    public void sortedInsert(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            head.setPrev(tail);
            tail.setNext(head);
            size++;
            return;
        }
        if (!isSorted()) {
            sort();
        }
        DNode current = head;
        while (current != tail && current.getData() < node.getData()) {
            current = current.getNext();
        }
        if (current == tail && node.getData() > current.getData()) {
            node.setPrev(current);
            node.setNext(current.getNext());
            current.setNext(node);
            head.setPrev(node);
            tail = node;
        } else if (current == head && node.getData() <= current.getData()) {
            node.setPrev(tail);
            node.setNext(current);
            current.setPrev(node);
            head = node;
            tail.setNext(node);
        } else {
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        size++;
    }
    
    @Override
    public boolean isSorted() {
        if (size <= 1) {
            return true;
        }
        DNode current = head.getNext();
        while (current != head) {
            if (current.getData() < current.getPrev().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
}


