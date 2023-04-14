package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class QueueLLTests {
    public static void main(String[] args) {
        
        // Create a new queue
        QueueLL queue = new QueueLL();
        
        // Enqueue some nodes
        SNode<Integer> node1 = new SNode<Integer>(1);
        SNode<Integer> node2 = new SNode<Integer>(2);
        SNode<Integer> node3 = new SNode<Integer>(3);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        
        // Test peek method
        System.out.println("Peek: " + queue.peek().getData());
        
        // Dequeue nodes and print them
        System.out.println("Dequeue: " + queue.dequeue().getData());
        System.out.println("Dequeue: " + queue.dequeue().getData());
        System.out.println("Dequeue: " + queue.dequeue().getData());
        
        // Test dequeue on empty queue
        System.out.println("Dequeue: " + queue.dequeue());
        
        // Test enqueue after dequeuing all nodes
        queue.enqueue(node1);
        System.out.println("Peek: " + queue.peek().getData());
    }
    
}
