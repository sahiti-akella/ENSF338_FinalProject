package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

/**
 * The SLL class represents a singly linked list data structure.
 * It contains a reference to the head node, tail node and the size of the
 * linked list.
 */

public class SLL {

    protected SNode<Integer> head;
    public SNode<Integer> tail;
    protected int size;

    /**
     * Constructs an empty singly linked list.
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a singly linked list with the given head node.
     * 
     * @param head the head node of the singly linked list.
     */
    public SLL(SNode<Integer> node) {
        this.head = node;
        this.tail = node;
        this.size = 1; 
    }

    /**
     * Inserts a node at the head of the singly linked list.
     * 
     * @param node the node to be Inserted.
     */
    public void InsertHead(SNode<Integer> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.size++;
    }

    /**
     * Inserts a node at the tail of the singly linked list.
     * 
     * @param node the node to be Inserted.
     */
    public void InsertTail(SNode<Integer> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Inserts a new node at the specified position in the linked list.
     * If 5 Inserted at position 2 of linked list 1234 = 15234
     * 
     * @param node     the node to be Inserted
     * @param position the position at which the node should be Inserted, 1-based index
     * @throws IndexOutOfBoundsException if the position is less than 1 or greater than the size of the list + 1
     */
    public void Insert(SNode<Integer> node, int position) {
        if (position < 1 || position > this.size + 1) {
            throw new IndexOutOfBoundsException("Invalid position for Insertion");
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == this.size + 1) {
            InsertTail(node);
        } else {
            SNode<Integer> current = this.head;
            for (int i = 2; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            this.size++;
        }
    }

    /**
     * Inserts a new node into the Sorted singly linked list in ascending order.
     * If the list is not Sorted, it will first be Sorted using the Sort() method.
     * 
     * @param node the node to be Inserted into the list
     */
    public void SortedInsert(SNode<Integer> node) {
        if (this.head == null || node.getData() < this.head.getData()) {
            InsertHead(node);
        } else {
            SNode<Integer> current = this.head;
            while (current.getNext() != null && node.getData() > current.getNext().getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
        if (!IsSorted()) {
            Sort();
        }
    }

    /**
     * Searches for a given node in the singly linked list, starting from the head.
     * 
     * @param node the node to Search for in the list
     * @return the node if found in the list, otherwise null
     */
    public SNode<Integer> Search(SNode<Integer> node) {
        SNode<Integer> current = this.head;
        boolean isCircular = false;
        while (current != null && !isCircular) {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
            if (current == this.head) {
                isCircular = true;
            }
        }
        return null;
    }

    /**
     * Removes the head node of this linked list. If the list is empty, this method
     * does nothing.
     */
    public void DeleteHead() {
        if (this.head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        this.head = this.head.getNext();
        this.size--;
    }

    /**
     * Removes the tail node of this linked list. If the list is empty, this method
     * does nothing.
     */
    public void DeleteTail() {
        if (this.head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        SNode<Integer> current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        current.setNext(null);
        this.tail = current;
        this.size--;
    }

    /**
     * Deletes a given node from the linked list.
     * 
     * @param node the node to be Deleted from the linked list.
     */
    public void Delete(SNode<Integer> node) {
        if (this.head == null) {
            return;
        }
        if (this.head.equals(node)) {
            DeleteHead();
            return;
        }
        if (this.tail.equals(node)) {
            DeleteTail();
            return;
        }
        SNode<Integer> current = this.head;
        while (current.getNext() != null && !current.getNext().equals(node)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
            this.tail = current;
        }
        this.size--;
    }

    /**
     * Sorts the elements of the singly linked list in non-descending order using
     * Insertion Sort algorithm.
     * The Sorting is performed in-place, so no new linked list is created.
     */
    public void Sort() {
        if (this.head == null || this.head.getNext() == null || this.IsSorted()) {
            return;
        }

        SNode<Integer> newHead = null;
        SNode<Integer> current = this.head;
        while (current != null) {
            SNode<Integer> next = current.getNext();
            if (newHead == null || current.getData() < newHead.getData()) {
                current.setNext(newHead);
                newHead = current;
            } else {
                SNode<Integer> Search = newHead;
                while (Search.getNext() != null && current.getData() > Search.getNext().getData()) {
                    Search = Search.getNext();
                }
                current.setNext(Search.getNext());
                Search.setNext(current);
            }
            current = next;
        }

        head = newHead;
    }

    /**
     * Removes all elements from this linked list.
     * The head, tail, and size of the linked list are all set to null or 0.
     */
    public void Clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Prints the contents of the linked list to the console.
     * If the list is empty, the method prints "List is empty".
     * Otherwise, the method prints the length of the list, the Sorted status of the
     * list, and the content of the list.
     * The content of the list is printed as a space-separated sequence of elements.
     * If the list is circular (i.e., the tail node's next pointer points to the
     * head node), the method prints all elements
     * of the list once, starting from the head node and stopping when the method
     * reaches the head node again.
     */
    public void Print() {
        if (this.size == 0) {
            System.out.println("List is empty");
            return;
        }
        boolean isCircular = (this.tail != null && this.tail.getNext() == this.head);
        System.out.println("List length: " + this.size);
        System.out.println("Sorted status: " + (IsSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        SNode<Integer> current = this.head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (isCircular ? current != this.head : current != null);
        System.out.println();
    }

    /**
     * Checks whether the linked list is Sorted in non-decreasing order.
     * Returns true if the linked list is Sorted in non-decreasing order,
     * false otherwise.
     *
     * @return true if the linked list is Sorted in non-decreasing order,
     *         false otherwise
     */
    protected boolean IsSorted() {
        if (this.head == null || this.size == 1) {
            return true;
        }
        SNode<Integer> current = this.head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}
