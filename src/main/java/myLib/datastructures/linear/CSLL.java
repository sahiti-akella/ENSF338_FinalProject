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
    public CSLL(SNode<Integer> node) {
        head = node;
        tail = node;
        tail.setNext(head);
        size = 1; 
    }

    /**
     * Inserts a node at the head of the singly linked list.
     * Also updates the tail's next to the new head.
     * 
     * @param node the node to Insert at the end of the list
     */
    @Override
    public void InsertHead(SNode<Integer> node) {
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
     * @param node the node to Insert at the end of the list
     */
    @Override
    public void InsertTail(SNode<Integer> node) {
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
     * @param node     the node to be Inserted
     * @param position the position at which the node should be Inserted, 1-based index
     * @throws IndexOutOfBoundsException if the position is less than 1 or greater than the size of the list + 1
     */
    public void Insert(SNode<Integer> node, int position) {
        super.Insert(node, position);
    }

    /**
     * Removes the head node from the circular linked list.
     * If the list is empty, the method does nothing.
     */
    @Override
    public void DeleteHead() {
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
    public void DeleteTail() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            SNode<Integer> current = head;
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
     * @param node the node to be Deleted from the linked list.
     */
    @Override
    public void Delete(SNode<Integer> node) {
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            DeleteHead();
            return;
        }
        if (tail.equals(node)) {
            DeleteTail();
            return;
        }
        SNode<Integer> current = head;
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
     * @param node the node to Search for in the list
     * @return the node if found in the list, otherwise null
     */
    public SNode<Integer> Search(SNode<Integer> node) {
        return super.Search(node);
    }

    /**
     * Removes all elements from this linked list.
     * The head, tail, and size of the linked list are all set to null or 0.
     */
    public void Clear() {
        super.Clear();
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
        super.Print();
    }

    /**
     * Inserts a new node into the Sorted circular singly linked list in ascending
     * order.
     * If the list is not Sorted, it will first be Sorted using the Sort() method.
     * 
     * @param node the node to be Inserted into the list
     */
    @Override
    public void SortedInsert(SNode<Integer> node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(node);
        } else if (node.getData() < head.getData()) {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        } else {
            SNode<Integer> current = head;
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
        if (!IsSorted()) {
            Sort();
        }
    }

    /**
     * Sorts the elements in the circular linked list using the Insertion Sort
     * algorithm.
     * The method Sorts the list in place, i.e., it modifies the list by rearranging
     * the nodes.
     * If the list is empty or contains only one element, the method returns
     * immediately without modifying the list.
     */
    @Override
    public void Sort() {
        if (head == null || head == tail) {
            return;
        } else {
            boolean swap = true;
            while (swap) {
                swap = false;
                SNode<Integer> current = head;
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
     * Checks whether the linked list is Sorted in non-decreasing order.
     * Returns true if the linked list is Sorted in non-decreasing order,
     * false otherwise.
     *
     * @return true if the linked list is Sorted in non-decreasing order,
     *         false otherwise
     */
    @Override
    protected boolean IsSorted() {
        if (head == null || size == 1) {
            return true;
        }

        SNode<Integer> current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}