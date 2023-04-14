package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    /**
     This is a Queue based on Singly Linked List data structure and extends the singlyLL
     */ 

    /**
     Creates an empty queue
     */ 
    public QueueLL() {
        super();
    }

    /**
     * Creates a queue consisting of argument node 
     * @param node Node to be added to queue
     */
    public QueueLL(SNode<Integer> node) {
        super(node);
    }

    /**
     * Adds argument node to queue tail
     * @param node Node to be added to queue tail
     */
    public void enqueue(SNode<Integer> node) {
        super.insertTail(node);
    }

    /**
     * Deletes node at queue head
     * @return - Returns dequeued node
     */
    public SNode<Integer> dequeue() {

        SNode<Integer> node = this.head;
        super.deleteHead();
        return node;
    }
    
    /**
     * Function to return head of queue
     * @return - Returns null if head is null, else returns head
     */
    public SNode<Integer> peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    /**
     * No functionality in QueueLL
     * @param node argument node - no functionality in QueueLL
     */
    @Override
    public void sortedInsert(SNode<Integer> node) {}

    /**
     * No functionality in QueueLL
     * @param node argument node - no functionality in QueueLL
     */
    @Override
    public void insertHead(SNode<Integer> node) {}

    /**
     * Inserts argument node at argument position
     * @param node the SNode to add to the list
     * @param position the SNode to add to the list
     */
    @Override
    public void insert(SNode<Integer> node, int position) {}

    /**
     * No functionality in QueueLL
     * @param node argument node - no functionality in QueueLL
     */
    @Override
    public void delete(SNode<Integer> node) {}

    /**
     * Deletes tail of queue
     */
    @Override
    public void deleteTail() {}

    /**
     * No functionality in QueueLL
     */
    @Override
    public void sort() {}

    /**
     * Clears all queue elements
     */
    @Override
    public void clear() {
        super.clear();
    }
 
}
