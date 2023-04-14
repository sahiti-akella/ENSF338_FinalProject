package main.java.myLib.datastructures.nodes;

public class TNode {
    
    // Member Variables
    public int data;
    public TNode left;
    public TNode right;
    private TNode parent;
    private int balance;
    public int height;

    // Default Constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // Overload Constructor
    public TNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // Overload Constructor
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    // Getters and Setters
    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return this.right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // print Function

    public void print(){
        System.out.println("Data: " + data);
        System.out.println("Balance: " + balance);
    }

    // toString Function

    public String toString(){
        return Integer.toString(data);
    }
}
