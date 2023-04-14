package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

/**
 * Circular Doubly Linked List (CDLL) implementation that extends Doubly Linked
 * List (DLL).
 * The CDLL class provides the functionality of a circular doubly linked list.
 */

public class CDLL extends DLL {
    /**
     * Constructs an empty CDLL object.
     * The head, tail, and size are initialized to null and 0 respectively.
     */
    public CDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a CDLL object with a single DNode.
     * The head and tail are set to the node, and the node's previous and next
     * pointers
     * are set to point to itself, creating a circular list.
     *
     * @param node the DNode to add to the list
     */
    public CDLL(DNode<Integer> node) {
        head = node;
        tail = node;
        head.setPrev(tail);
        tail.setNext(head);
        size = 1;
    }

    /**
     * Inserts a new node at the head of the doubly circular linked list.
     * If the list is empty, the new node becomes both the head and tail.
     * Updates tail next and head prev for circular list
     * 
     * @param node the node to be Inserted at the head of the list
     */
    @Override
    public void InsertHead(DNode<Integer> node) {
        super.InsertHead(node);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Inserts a new node at the tail of the doubly circular linked list.
     * If the list is empty, the new node becomes both the head and tail.
     * Updates tail next and head prev for circular list
     * 
     * @param node the node to be Inserted at the tail of the list
     */
    @Override
    public void InsertTail(DNode<Integer> node) {
        super.InsertTail(node);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Inserts a given node at a specific position in the Doubly Circular Linked List.
     * Updates tail next and head prev for circular list
     * 
     * @param node     the node to be Inserted
     * @param position the position where the node should be Inserted, 1-based index
     * @throws IllegalArgumentException if the position is less than 1 or greater
     *                                  than the size of the list + 1
     */
    @Override
    public void Insert(DNode<Integer> node, int position) {
        super.Insert(node, position);
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Deletes the head node of the doubly circular linked list.
     * If the head is the only node in the list, sets both head and tail to null.
     * Decrements the size of the linked list by 1.
     * Updates tail next and head prev for circular list
     */
    @Override
    public void DeleteHead() {
        super.DeleteHead();
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Deletes the tail node of the doubly circular linked list.
     * If the tail is the only node in the list, sets both head and tail to null.
     * Decrements the size of the linked list by 1.
     * Updates tail next and head prev for circular list
     */
    @Override
    public void DeleteTail() {
        super.DeleteTail();
        // If the list is circular, set the tail's next reference to the head
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Deletes a given node from the doubly linked list. If the node is the head, it
     * calls DeleteHead().
     * If the node is the tail, it calls DeleteTail().
     * Otherwise, it removes the node from the list by updating the previous and
     * next nodes to bypass it.
     * Updates tail next and head prev for circular list
     * 
     * @param node the node to be Deleted from the list
     */
    @Override
    public void Delete(DNode<Integer> node) {
        super.Delete(node);
        // update tail's next reference if the list is circular
        if (tail != null && tail.getNext() != head) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    /**
     * Removes all of the elements from the circular doubly linked list.
     */
    public void Clear() {
        super.Clear();
    }

    /**
     * Searches for a given node in the circular doubly linked list
     * 
     * @param node The node to Search for in the list.
     * @return The node if found, null otherwise.
     */
    public DNode<Integer> Search(DNode<Integer> node) {
        return super.Search(node);

    }

    /**
     * Prints the contents of the circular doubly linked list.
     * If the list is empty, it prints a message indicating that.
     * Otherwise, it prints the length of the list, its Sorted status,
     * and the data of each node in the list.
     */
    public void Print() {
        super.Print();
    }

     /**
     * Sorts the elements of the circular doubly linked list in ascending order
     * using the Insertion Sort algorithm.
     */
    @Override
    public void Sort() {
        if (size <= 1) {
            return;
        }
        DNode<Integer> current = head.getNext();
        while (current != head) {
            DNode<Integer> temp = current;
            while (temp.getPrev() != null && temp.getData() < temp.getPrev().getData()) {
                DNode<Integer> prev = temp.getPrev();
                DNode<Integer> next = temp.getNext();
                if (prev.getPrev() != null) {
                    prev.getPrev().setNext(temp);
                } else {
                    head = temp;
                }
                temp.setPrev(prev.getPrev());
                temp.setNext(prev);
                prev.setPrev(temp);
                prev.setNext(next);
                if (next != null) {
                    next.setPrev(prev);
                } else {
                    tail = prev;
                }
            }
            current = current.getNext();
        }
    }

    /**
     * Inserts a new node in the circular doubly linked list while maintaining a Sorted order.
     * If the list is empty, the node is Inserted as the head of the list.
     * @param node the node to be Inserted
    */
    @Override
    public void SortedInsert(DNode<Integer> node) {
        if (head == null) {
            InsertHead(node);
            return;
        }
        if (!IsSorted()) {
            Sort();
        }
        // Find the appropriate position for the new node in the Sorted list
        DNode<Integer> current = head;
        while (current != tail && current.getData() < node.getData()) {
            current = current.getNext();
        }
        // If the new node belongs at the end of the list
        if (current == tail && node.getData() > current.getData()) {
            node.setPrev(current);
            node.setNext(current.getNext());
            current.setNext(node);
            head.setPrev(node);
            tail = node;
        } 
        // If the new node belongs at the beginning of the list
        else if (current == head && node.getData() <= current.getData()) {
            node.setPrev(tail);
            node.setNext(current);
            current.setPrev(node);
            head = node;
            tail.setNext(node);
        } 
        // If the new node belongs somewhere in the middle of the list
        else {
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        size++;
    }

    /**
     * Checks whether the circular doubly linked list is Sorted in non-decreasing order.
     * Returns true if the circular doubly linked list is Sorted in non-decreasing order,
     * false otherwise.
     *
     * @return true if the doubly linked list is Sorted in non-decreasing order,
     *         false otherwise
     */
    @Override
    public boolean IsSorted() {
        if (head == null || size == 1) {
            return true;
        }
        DNode<Integer> current = head.getNext();
        while (current != head) {
            if (current.getData() < current.getPrev().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}
