package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;
public class CSLL extends SLL {

    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        head.setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        if (size == 0) {
            node.setNext(node);
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (size == 0) {
            node.setNext(node);
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void insert(SNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position for insertion");
        }
        if (position == 1) {
            insertHead(node);
            tail.setNext(head); 
        } else if (position == size + 1) {
            insertTail(node);
            tail.setNext(head); 
        } else {
            SNode current = head;
            for (int i = 2; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }
    
    @Override
    public void deleteHead() {
        if (size == 0) {
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

    @Override
    public void deleteTail() {
        if (size == 0) {
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
            tail.setNext(head); // loop back to head node
        }
        size--;
    }

    @Override
    public SNode search(SNode node) {
        if (head == null) {
            return null;
        }
        SNode current = head;
        do {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }    

    @Override
    public void print() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        SNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }
   
    @Override
    public void sortedInsert(SNode node) {
        if (head == null) {
            node.setNext(node);
            head = node;
            tail = node;
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

    @Override
    public void sort() {
        if (head == null || head.getNext() == head) {
            return;
        }
    
        SNode current = head;
        do {
            boolean sorted = true;
            SNode temp = current.getNext();
            while (temp != head && temp != current) {
                if (current.getData() > temp.getData()) {
                    swap(current, temp);
                    sorted = false;
                }
                temp = temp.getNext();
            }
            if (sorted) {
                break;
            }
            current = current.getNext();
        } while (current != head);
    }
    
    // helper functions
    @Override
    protected boolean isSorted() {
        if (head == null || head.getNext() == head) {
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
    

    private void swap(SNode node1, SNode node2) {
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }
    
    // testing functions
    public static void main(String[] args) {  
        
        CSLL csList = new CSLL();

        SNode validSearch = new SNode(4);
        SNode invalidSearch = new SNode(8);
        SNode nodeToDelete = new SNode(9);

        System.out.println("\nTESTING ADDING, DELETING AND SORTING: ");  
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(nodeToDelete);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(new SNode(3));  
        csList.print();  
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(validSearch);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());
  
        System.out.println("\nAdding nodes to the end of the list: ");  
        csList.insertTail(new SNode(7));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nAdding nodes to the start of the list: ");  
        csList.insertHead(new SNode(2));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nAdding nodes to specified position in the list: ");  
        csList.insert(new SNode(5), 3);  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nSort and insert node in the list: ");  
        csList.sortedInsert(new SNode(6));  
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting head: ");
        csList.deleteHead(); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting tail: ");
        csList.deleteTail(); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nDeleting specified node: ");
        csList.delete(nodeToDelete); 
        csList.print();
        System.out.println("Tail: " + csList.tail);
        System.out.println("Tail next: " + csList.tail.getNext());

        System.out.println("\nTESTING SEARCHING AND CLEARING: ");  

        System.out.println("\nFinding node..");
        SNode node1 = csList.search(validSearch);  
        System.out.println("Node (null if not found): " + node1);

        System.out.println("\nFinding non existent node..");
        SNode node2 = csList.search(invalidSearch);  
        System.out.println("Node (null if not found): " + node2);

        System.out.println("\nClearing entire list:");
        csList.clear(); 
        csList.print();
        System.out.println("\n");  
        
    }  
}
