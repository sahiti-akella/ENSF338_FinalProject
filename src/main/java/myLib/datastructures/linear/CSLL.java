package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;
public class CSLL extends SLL {
    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        head.setNext(head); // loop back to head node
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
            tail.setNext(head); // loop back to head node
        }
        size++;
    }
   
    public static void main(String[] args) {  
        CSLL csll = new CSLL();
        csll.insertHead(new SNode(1));
        csll.insertHead(new SNode(2));
        csll.insertHead(new SNode(3));
        System.out.println("Tail next node: " + csll.tail.getNext());
        System.out.println("Tail " + csll.tail);

    }  
}
