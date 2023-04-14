package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

/**
 * The DLL class represents a doubly linked list data structure.
 * It is used to store a sequence of nodes that each contain a
 * reference to the previous and next nodes in the sequence.
 */

public class DLL {

    protected DNode<Integer> head;
    public DNode<Integer> tail;
    protected int size;

    /**
     * Creates an empty doubly linked list.
     */
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Creates a doubly linked list with a single node.
     * 
     * @param node the node to be added to the list
     */
    public DLL(DNode<Integer> node) {
        this.head = node;
        this.tail = node;
        this.head.setPrev(tail);
        this.size = 1;
    }

    /**
     * Inserts the given node at the head of the doubly linked list.
     * 
     * @param node the node to be inserted
     */
    public void insertHead(DNode<Integer> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(null);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
        this.size++;
    }

    /**
     * Inserts the given node at the tail of the doubly linked list.
     * 
     * @param node the node to be inserted
     */
    public void insertTail(DNode<Integer> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(this.tail);
            node.setNext(null);
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Inserts a given node at a specific position in the Doubly Linked List.
     * 
     * @param node     the node to be inserted
     * @param position the position where the node should be inserted, 1-based index
     * @throws IllegalArgumentException if the position is less than 1 or greater
     *                                  than the size of the list + 1
     */
    public void insert(DNode<Integer> node, int position) {
        if (position < 1 || position > this.size + 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 1) {
            insertHead(node);
        } else if (position == this.size + 1) {
            insertTail(node);
        } else {
            DNode<Integer> current = this.head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            this.size++;
        }
    }

    /**
     * Deletes the head node of a doubly linked list.
     * If the list is empty, no action is taken.
     */
    public void deleteHead() {
        if (this.head == null) {
            return;
        }
        if (this.head != null) {
            // If the head is the only node in the list, set both head and tail to null
            if (this.head == tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNext();
                this.head.setPrev(null);
            }
            this.size--;
        }
    }

    /**
     * Deletes the tail node of a doubly linked list.
     * If the list is empty, no action is taken.
     */
    public void deleteTail() {
        if (this.head == null) {
            return;
        }
        if (this.tail.getPrev() == null) {
            // There is only one node in the list
            this.head = null;
            this.tail = null;
        } else {
            this.tail = tail.getPrev();
            this.tail.setNext(null);
        }
        this.size--;
    }

    /**
     * Deletes a given node from the doubly linked list. If the node is the head, it
     * calls deleteHead().
     * If the node is the tail, it calls deleteTail().
     * Otherwise, it removes the node from the list by updating the previous and
     * next nodes to bypass it.
     * 
     * @param node the node to be deleted from the list
     */
    public void delete(DNode<Integer> node) {
        if (this.head == null) {
            return;
        }
        if (this.head == node) { // if node is the head
            deleteHead();
        } else if (this.tail == node) { // if node is the tail
            deleteTail();
        } else { // if node is in the middle
            DNode<Integer> prev = node.getPrev();
            DNode<Integer> next = node.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrev(prev);
            }
            this.size--;
        }
    }

    /**
     * Removes all of the elements from the doubly linked list.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Searches for a given node in the doubly linked list.
     * Can work with circular
     * 
     * @param node The node to search for in the list.
     * @return The node if found, null otherwise.
     */
    public DNode<Integer> search(DNode<Integer> node) {
        DNode<Integer> current = this.head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
            // If the list is circular and we have reached the head again, break the loop
            if (current == this.head && this.tail != null && this.tail.getNext() == this.head) {
                break;
            }
        }
        return null;
    }

    /**
     * Prints the contents of the doubly linked list.
     * Can work with circular
     * If the list is empty, it prints a message indicating that.
     * Otherwise, it prints the length of the list, its sorted status,
     * and the data of each node in the list.
     */
    public void print() {
        if (this.size == 0) {
            System.out.println("List is empty");
            return;
        }
        boolean isCircular = (this.tail != null && this.tail.getNext() == this.head);
        System.out.println("List length: " + this.size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        DNode<Integer> current = this.head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (isCircular ? current != this.head : current != null);
        System.out.println();
    }

    /**
     * Sorts the elements of the doubly linked list in ascending order
     * using the insertion sort algorithm.
     */
    public void sort() {
        if (this.size <= 1) {
            return;
        }
        DNode<Integer> current = this.head.getNext();
        while (current != null) {
            DNode<Integer> next = current.getNext();
            while (current.getPrev() != null && current.getData() < current.getPrev().getData()) {
                DNode<Integer> prev = current.getPrev();
                DNode<Integer> prevPrev = prev.getPrev();
                DNode<Integer> currentNext = current.getNext();
                prev.setNext(currentNext);
                current.setNext(prev);
                current.setPrev(prevPrev);
                prev.setPrev(current);
                if (prevPrev != null) {
                    prevPrev.setNext(current);
                } else {
                    this.head = current;
                }
                if (currentNext != null) {
                    currentNext.setPrev(prev);
                } else {
                    this.tail = prev;
                }
            }
            current = next;
        }
    }

    /**
     * Inserts a new node in the doubly linked list while maintaining a sorted order.
     * If the list is empty, the node is inserted as the head of the list.
     * @param node the node to be inserted
    */
    public void sortedInsert(DNode<Integer> node) {
        if (this.head == null) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        // Traverse the list to find the position to insert the node
        DNode<Integer> current = this.head;
        while (current != null && current.getData() < node.getData()) {
            current = current.getNext();
        }
        // If the node should be inserted at the end of the list
        if (current == null) {
            node.setPrev(tail);
            this.tail.setNext(node);
            this.tail = node;
        } 
        // If the node should be inserted at the beginning of the list
        else if (current == this.head) {
            node.setPrev(null);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        } 
        // If the node should be inserted in the middle of the list
        else {
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        this.size++;
    }

    /**
     * Checks whether the doubly linked list is sorted in non-decreasing order.
     * Returns true if the doubly linked list is sorted in non-decreasing order,
     * false otherwise.
     *
     * @return true if the doubly linked list is sorted in non-decreasing order,
     *         false otherwise
     */
    public boolean isSorted() {
        if (this.head == null || this.size == 1) {
            return true;
        }
        DNode<Integer> current = this.head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}
