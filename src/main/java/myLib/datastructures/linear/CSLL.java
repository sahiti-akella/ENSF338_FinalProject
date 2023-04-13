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
    public void sort(){
        if(head == null || head == tail){
            return;
        }else{
            boolean swapped = true;
            while(swapped){
                swapped = false;
                SNode current = head;
                while(current.getNext() != head){
                    if(current.getData() > current.getNext().getData()){
                        int temp = current.getData();
                        current.setData(current.getNext().getData());
                        current.getNext().setData(temp);
                        swapped = true;
                    }
                    current = current.getNext();
                }
            }
        }
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
    
}