package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

/**
 * The DLL class represents a doubly linked list data structure.
 * It is used to store a sequence of nodes that each contain a
 * reference to the previous and next nodes in the sequence.
 */

public class DLL {

    protected DNode head;
    public DNode tail;
    protected int size;

    /**
     * Creates an empty doubly linked list.
     */
    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Creates a doubly linked list with a single node.
     * 
     * @param node the node to be added to the list
     */
    public DLL(DNode node) {
        head = node;
        tail = node;
        size = 1;
    }

    /**
     * Inserts the given node at the head of the doubly linked list.
     * 
     * @param node the node to be inserted
     */
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    /**
     * Inserts the given node at the tail of the doubly linked list.
     * 
     * @param node the node to be inserted
     */
    public void insertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.setPrev(null);
            node.setNext(null);
        } else {
            node.setPrev(tail);
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Inserts a given node at a specific position in the Doubly Linked List.
     * 
     * @param node     the node to be inserted
     * @param position the position where the node should be inserted, 1-based index
     * @throws IllegalArgumentException if the position is less than 1 or greater
     *                                  than the size of the list + 1
     */
    public void insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }

    /**
     * Deletes the head node of the linked list.
     * If the head is the only node in the list, sets both head and tail to null.
     * Otherwise, updates the head reference to the next node and sets the previous
     * reference of the new head to null.
     * Decrements the size of the linked list by 1.
     */
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head != null) {
            // If the head is the only node in the list, set both head and tail to null
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            size--;
        }
    }

    /**
     * Deletes the tail node of a doubly linked list.
     * If the list is empty, no action is taken.
     */
    public void deleteTail() {
        if (head == null) {
            return;
        }
        if (tail.getPrev() == null) {
            // There is only one node in the list
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
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
    public void delete(DNode node) {
        if (head == null) {
            return;
        }
        if (head == node) { // if node is the head
            deleteHead();
        } else if (tail == node) { // if node is the tail
            deleteTail();
        } else { // if node is in the middle
            DNode prev = node.getPrev();
            DNode next = node.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrev(prev);
            }
            size--;
        }
    }

    /**
     * Removes all of the elements from the doubly linked list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Searches for a given node in the doubly linked list.
     * Can work with circular
     * 
     * @param node The node to search for in the list.
     * @return The node if found, null otherwise.
     */
    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
            // If the list is circular and we have reached the head again, break the loop
            if (current == head && tail != null && tail.getNext() == head) {
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
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        boolean isCircular = (tail != null && tail.getNext() == head);
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        DNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (isCircular ? current != head : current != null);
        System.out.println();
    }

    /**
     * Sorts the elements of the doubly linked list in ascending order
     * using the insertion sort algorithm.
     */
    public void sort() {
        if (size <= 1) {
            return;
        }
        DNode current = head.getNext();
        while (current != null) {
            DNode next = current.getNext();
            while (current.getPrev() != null && current.getData() < current.getPrev().getData()) {
                DNode prev = current.getPrev();
                DNode prevPrev = prev.getPrev();
                DNode currentNext = current.getNext();
                prev.setNext(currentNext);
                current.setNext(prev);
                current.setPrev(prevPrev);
                prev.setPrev(current);
                if (prevPrev != null) {
                    prevPrev.setNext(current);
                } else {
                    head = current;
                }
                if (currentNext != null) {
                    currentNext.setPrev(prev);
                } else {
                    tail = prev;
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
    public void sortedInsert(DNode node) {
        if (head == null) {
            insertHead(node);
            return;
        }
        if (!isSorted()) {
            sort();
        }
        // Traverse the list to find the position to insert the node
        DNode current = head;
        while (current != null && current.getData() < node.getData()) {
            current = current.getNext();
        }
        // If the node should be inserted at the end of the list
        if (current == null) {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        } 
        // If the node should be inserted at the beginning of the list
        else if (current == head) {
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        } 
        // If the node should be inserted in the middle of the list
        else {
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        size++;
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
        if (head == null || size == 1) {
            return true;
        }
        DNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}
