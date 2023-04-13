package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

/**
 * The CSLL (Circular Singly Linked List) class represents a circular linked
 * list,
 * where each node in the list has a reference to the next node in the list, and
 * the last node has a reference to the first node in the list.
 * This class extends the SLL (Singly Linked List) class, which provides basic
 * linked list functionality.
 */
public class CSLL extends SLL {
    /**
     * Creates an empty circular singly linked list.
     */
    public CSLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Creates a circular singly linked list with the given head node.
     * The tail next of the list is set to the head node.
     * 
     * @param head the first node in the circular linked list
     */
    public CSLL(SNode node) {
        head = node;
        tail = node;
        tail.setNext(head);
        size = 1; 
    }

    /**
     * Inserts a node at the head of the singly linked list.
     * Also updates the tail's next to the new head.
     * 
     * @param node the node to insert at the end of the list
     */
    @Override
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(node);
        } else {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        }
        size++;
    }

    /**
     * Inserts a node at the end of the singly linked list.
     * Also updates the tail's next to the new head.
     * 
     * @param node the node to insert at the end of the list
     */
    @Override
    public void insertTail(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(node);
        } else {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        }
        size++;
    }

    /**
     * Inserts a node at the specified position in the singly linked list.
     * 
     * @param node     the node to be inserted
     * @param position the position at which the node should be inserted, 1-based index
     * @throws IndexOutOfBoundsException if the position is less than 1 or greater than the size of the list + 1
     */
    public void insert(SNode node, int position) {
        super.insert(node, position);
    }

    /**
     * Removes the head node from the circular linked list.
     * If the list is empty, the method does nothing.
     */
    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
    }

    /**
     * Removes the head node from the circular linked list.
     * If the list is empty, the method does nothing.
     */
    @Override
    public void deleteTail() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(head);
        }
        size--;
    }

    /**
     * Deletes a given node from the linked list.
     * 
     * @param node the node to be deleted from the linked list.
     */
    @Override
    public void delete(SNode node) {
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            deleteHead();
            return;
        }
        if (tail.equals(node)) {
            deleteTail();
            return;
        }
        SNode current = head;
        while (current.getNext() != head && !current.getNext().equals(node)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() == head) {
            tail = current;
        }
        size--;
    }

    /**
     * Searches for a given node in the singly linked list, starting from the head.
     * 
     * @param node the node to search for in the list
     * @return the node if found in the list, otherwise null
     */
    public SNode search(SNode node) {
        return super.search(node);
    }

    /**
     * Removes all elements from this linked list.
     * The head, tail, and size of the linked list are all set to null or 0.
     */
    public void clear() {
        super.clear();
    }

    /**
     * Prints the contents of the linked list to the console.
     * If the list is empty, the method prints "List is empty".
     * Otherwise, the method prints the length of the list, the sorted status of the
     * list, and the content of the list.
     * The content of the list is printed as a space-separated sequence of elements.
     * If the list is circular (i.e., the tail node's next pointer points to the
     * head node), the method prints all elements
     * of the list once, starting from the head node and stopping when the method
     * reaches the head node again.
     */
    public void print() {
        super.print();
    }

    /**
     * Inserts a new node into the sorted circular singly linked list in ascending
     * order.
     * If the list is not sorted, it will first be sorted using the sort() method.
     * 
     * @param node the node to be inserted into the list
     */
    @Override
    public void sortedInsert(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(node);
        } else if (node.getData() < head.getData()) {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        } else {
            SNode current = head;
            while (current.getNext() != head && node.getData() > current.getNext().getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            if (current == tail) {
                tail = node;
            }
        }

        size++;
        if (!isSorted()) {
            sort();
        }
    }

    /**
     * Sorts the elements in the circular linked list using the insertion sort
     * algorithm.
     * The method sorts the list in place, i.e., it modifies the list by rearranging
     * the nodes.
     * If the list is empty or contains only one element, the method returns
     * immediately without modifying the list.
     */
    @Override
    public void sort() {
        if (head == null || head == tail) {
            return;
        } else {
            boolean swap = true;
            while (swap) {
                swap = false;
                SNode current = head;
                while (current.getNext() != head) {
                    if (current.getData() > current.getNext().getData()) {
                        int temp = current.getData();
                        current.setData(current.getNext().getData());
                        current.getNext().setData(temp);
                        swap = true;
                    }
                    current = current.getNext();
                }
            }
        }
    }

    /**
     * Checks whether the linked list is sorted in non-decreasing order.
     * Returns true if the linked list is sorted in non-decreasing order,
     * false otherwise.
     *
     * @return true if the linked list is sorted in non-decreasing order,
     *         false otherwise
     */
    @Override
    protected boolean isSorted() {
        if (head == null || size == 1) {
            return true;
        }

        SNode current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}