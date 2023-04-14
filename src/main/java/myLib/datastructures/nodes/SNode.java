package main.java.myLib.datastructures.nodes;

public class SNode<T> {
    private T data;
    private SNode<T> next;
    private SNode<T> prev;

    public SNode(T data) {
        this.data = data;
        next = null;
    }

    public SNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(SNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }
}
