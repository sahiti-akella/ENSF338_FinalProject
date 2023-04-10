package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class CDLL extends DLL{
    public CDLL() {
        super();
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public CDLL(DNode node) {
        super(node);
        this.head = node;
        this.tail = node;
        this.head.setPrev(this.tail);
        this.tail.setNext(this.head);
        size = 1; 
    }

    public void insertHead(DNode node) {
        super.insertHead(node);
    }

    public void insertTail(DNode node) {
        super.insertTail(node);
    }
    
    public void insert(DNode node, int position) {
        super.insert(node, position);
    }

    public void deleteHead() {
        super.deleteHead();
    }

    public void deleteTail() {
        super.deleteTail();
    }
    
    public void delete(DNode node) {
       super.delete(node);
    }
    
    public DNode search(DNode node) {
       return super.search(node);
    }

    public void print(){
        super.print();
    }
    
    public void clear(){
        super.clear();
    }

}


