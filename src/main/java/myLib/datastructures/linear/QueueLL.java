package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }
    
    public void enqueue(SNode node) {
        super.insertTail(node);
    }
    
    public void dequeue() {
        super.deleteHead();
    }

    // Override any methods that are not applicable to queue behavior with empty body
    @Override
    public void sortedInsert(SNode node) {
        // do nothing
    }
    
    @Override
    public void insertHead(SNode node) {
        // do nothing
    }
    
    @Override
    public void insert(SNode node, int position) {
        // do nothing
    }
    
    @Override
    public void delete(SNode node) {
        // do nothing
    }

    @Override
    public void deleteTail() {
        // do nothing
    }
    
    @Override
    public void sort() {
        // do nothing
    }
}
