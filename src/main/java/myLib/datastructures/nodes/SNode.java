package main.java.myLib.datastructures.nodes;

public class SNode {
    private int data;
    private SNode next;
    private SNode prev;

    public SNode(int data) {
        this.data = data;
        next = null;
    }

    public SNode getPrev() {
        return this.prev;
    }

    public void setPrev(SNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}