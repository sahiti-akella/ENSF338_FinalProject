package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    /**
    * This is a Stack based on Singly Linked List data structure and extends the singlyLL
    */

    /**
    * Empty Stack
    */
    public StackLL() {
        super();
    }

    /**
    * Empty Stack consisting of argument node
    * @param node the SNode to add to the stack
    */
    public StackLL(SNode<Integer> node) {
        super(node);
    }

    /**
     * Adds argument node to the start of the stack
     * @param node the SNode to add to the stack
     */
    public void push(SNode<Integer> node) {
        super.insertHead(node);
    }

     /**
     * Deletes the head of the stack if not null
     * @return Returns the popped element
     */
    public SNode<Integer> pop() {
        SNode<Integer> node = head;
        if (head != null) {
            super.deleteHead();
        }
        return node;
    }

     /**
     * Returns the head of the stack
     * @return Returns the node at head of stack
     * 
     */
    public SNode<Integer> peek() {
        return this.head;
    }

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void insertHead(SNode<Integer> node) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void insertTail(SNode<Integer> node) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the stack
     * @param position the SNode to add to the stack
     */
    @Override
    public void insert(SNode<Integer> node, int position) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void sortedInsert(SNode<Integer> node) {}

     /**
     * Searches for given node in stack
     * @param node Returns node if found, else returns null
     */
    @Override
    public SNode<Integer> search(SNode<Integer> node) {
        SNode<Integer> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode == node) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * No functionality in StackLL
     */
    @Override
    public void deleteHead() {}

    /**
     * No functionality in StackLL
     */
    @Override
    public void deleteTail() {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void delete(SNode<Integer> node) {}

    /**
     * No functionality in StackLL
     */
    @Override
    public void sort() {}

    /**
     * Clears the stack
     */
    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void print() {
        SNode<Integer> current = head;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

