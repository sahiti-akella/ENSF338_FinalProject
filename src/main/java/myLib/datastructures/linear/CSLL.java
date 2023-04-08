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
   
    // testing functions
    public static void main(String[] args) {  
        CSLL csll = new CSLL();
        csll.insertHead(new SNode(1));
        csll.insertHead(new SNode(2));
        csll.insertHead(new SNode(3));
        csll.insertTail(new SNode(4));
        System.out.println("Tail next node: " + csll.tail.getNext());
        System.out.println("Tail " + csll.tail);
    }  
}
