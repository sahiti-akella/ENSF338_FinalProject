package main.java.myLib.datastructures.nodes;

public class DNode {
    
    private int data;
    private DNode prev;
    private DNode next;


    public DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Getters and Setters
    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public DNode getPrev() {
        return this.prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public DNode getNext() {
        return this.next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
