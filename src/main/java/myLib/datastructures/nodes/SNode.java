package main.java.myLib.datastructures.nodes;

public class SNode {
    private int data;
    private SNode next;

    public SNode(int data) {
        this.data = data;
        next = null;
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