package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    // Default Constructor
    public StackLL() {
        super();
    }

    public void push(SNode node) {
        super.insertHead(node);
    }

    public SNode pop() {
        SNode node = head;
        if (head != null) {
            deleteHead();
        }
        return node;
    }

    public SNode peek() {
        return head;
    }

    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
    }

    @Override
    public void insertTail(SNode node) {
        // Override with empty body to avoid misuse
    }

    @Override
    public void insert(SNode node, int position) {
        super.insert(node, position);
    }

    @Override
    public void sortedInsert(SNode node) {
        super.sortedInsert(node);
    }

    @Override
    public SNode search(SNode node) {
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
    public void delete(SNode node) {
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

