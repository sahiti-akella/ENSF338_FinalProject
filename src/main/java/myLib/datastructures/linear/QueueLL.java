package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }
    
    public void enqueue(SNode node) {
        super.insertTail(node);
    }
    
    public SNode dequeue() {
        if (head == null) {
            return null;
        }
        SNode node = head;
        super.deleteHead();
        return node;
    }

    public SNode peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    // Override any methods that are not applicable to queue behavior with empty body
    @Override
    public void sortedInsert(SNode node) {
    }
    
    @Override
    public void insertHead(SNode node) {
    }
    
    @Override
    public void insert(SNode node, int position) {
    }
    
    @Override
    public void delete(SNode node) {
    }

    @Override
    public void deleteTail() {
    }
    
    @Override
    public void sort() {
    }
}
