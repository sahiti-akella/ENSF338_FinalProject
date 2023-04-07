package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class SLL {

    private SNode head;
    private SNode tail;
    private int size;

    public SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        tail = head;
        size = 1; // CHANGE TO INCREMENT
    }

    public void insertHead(SNode node) {
       if (head == null) {
        head = node;
        tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
      if (head == null) {
        head = node;
        tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position){
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position for insertion");
        }
        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
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

    public void sortedInsert(SNode node){
        // Implement
    }

    public void search(SNode node){
        // Implement
    }

    public void deleteHead(){
        // Implement
    }

    public void deleteTail(){
        // Implement
    }

    public void delete(SNode node){
        // Implement
    }

    public void sort(){
        // Implement
    }

    public void clear(){
        // Implement
    }

    public void print(){
        // Implement
    }



    // testing functions
    public void display() {  
        //Node current will point to head  
        SNode current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Adding nodes to the end of the list: ");  
        while(current != null) {  
            //Prints each node by incrementing pointer  
            System.out.print(current.getData() + " ");  
            current = current.getNext();  
        }  
        System.out.println();  
    }  
  
    public static void main(String[] args) {  
  
        SLL sList = new SLL();  
  
        //Adding 1 to the list  
        sList.insertTail(new SNode(1));  
        sList.display();  
  
        //Adding 2 to the list  
        sList.insertTail(new SNode(2));  
        sList.display();  
  
        //Adding 3 to the list  
        sList.insertTail(new SNode(3));  
        sList.display();  
  
        //Adding 4 to the list  
        sList.insertTail(new SNode(4));  
        sList.display();  

        sList.insert(new SNode(5), 3);  
        sList.display();
    }  
}  
    

