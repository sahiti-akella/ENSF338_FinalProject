package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    // Default Constructor
    public StackLL() {
        super();
    }

    public void push(SNode<Integer> node) {
        super.insertHead(node);
    }

    public SNode<Integer> pop() {
        SNode<Integer> node = head;
        if (head != null) {
            deleteHead();
        }
        return node;
    }

    public SNode<Integer> peek() {
        return head;
    }

    @Override
    public void insertHead(SNode<Integer> node) {
        super.insertHead(node);
    }

    @Override
    public void insertTail(SNode<Integer> node) {
        // Override with empty body to avoid misuse
    }

    @Override
    public void insert(SNode<Integer> node, int position) {
        super.insert(node, position);
    }

    @Override
    public void sortedInsert(SNode<Integer> node) {
        super.sortedInsert(node);
    }

    @Override
    public SNode<Integer> search(SNode<Integer> node) {
        return super.search(node);
    }

    @Override
    public void deleteHead() {
        super.deleteHead();
    }

    @Override
    public void deleteTail() {
        // Override with empty body to avoid misuse
    }

    @Override
    public void delete(SNode<Integer> node) {
        super.delete(node);
    }

    @Override
    public void sort() {
        super.sort();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void print() {
        super.print();
    }
}

