package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }
    
    public void enqueue(SNode<Integer> node) {
        super.insertTail(node);
    }
    
    public SNode<Integer> dequeue() {
        if (head == null) {
            return null;
        }
        SNode<Integer> node = head;
        super.deleteHead();
        return node;
    }

    public SNode<Integer> peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    // Override any methods that are not applicable to queue behavior with empty body
    @Override
    public void sortedInsert(SNode<Integer> node) {
    }
    
    @Override
    public void insertHead(SNode<Integer> node) {
    }
    
    @Override
    public void insert(SNode<Integer> node, int position) {
    }
    
    @Override
    public void delete(SNode<Integer> node) {
    }

    @Override
    public void deleteTail() {
    }
    
    @Override
    public void sort() {
    }
}
