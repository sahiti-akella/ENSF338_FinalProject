package main.java.myLib.datastructures.nodes;

public class DNode<T>  {
    
    private T data;
    private DNode<T> prev;
    private DNode<T> next;


    public DNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Getters and Setters
    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public DNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public DNode<T> getNext() {
        return this.next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
