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
    public void Push(SNode<Integer> node) {
        super.InsertHead(node);
    }

     /**
     * Deletes the head of the stack if not null
     * @return Returns the popped element
     */
    public SNode<Integer> Pop() {
        SNode<Integer> node = head;
        if (head != null) {
            super.DeleteHead();
        }
        return node;
    }

     /**
     * Returns the head of the stack
     * @return Returns the node at head of stack
     * 
     */
    public SNode<Integer> Peek() {
        return this.head;
    }

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void InsertHead(SNode<Integer> node) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void InsertTail(SNode<Integer> node) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the stack
     * @param position the SNode to add to the stack
     */
    @Override
    public void Insert(SNode<Integer> node, int position) {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void SortedInsert(SNode<Integer> node) {}

     /**
     * Searches for given node in stack
     * @param node Returns node if found, else returns null
     */
    @Override
    public SNode<Integer> Search(SNode<Integer> node) {
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
    public void DeleteHead() {}

    /**
     * No functionality in StackLL
     */
    @Override
    public void DeleteTail() {}

     /**
     * No functionality in StackLL
     * @param node the SNode to add to the list
     */
    @Override
    public void Delete(SNode<Integer> node) {}

    /**
     * No functionality in StackLL
     */
    @Override
    public void Sort() {}

    /**
     * Clears the stack
     */
    @Override
    public void Clear() {
        super.Clear();
    }
    
    /**
     * Overrided print function
     */
    @Override
    public void Print() {
        SNode<Integer> current = head;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

