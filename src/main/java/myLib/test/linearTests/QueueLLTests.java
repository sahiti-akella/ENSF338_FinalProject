package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.linear.QueueLL;
import main.java.myLib.datastructures.nodes.SNode;

public class QueueLLTests {

    public static void main(String[] args) {
        // create an empty queue
        QueueLL queue = new QueueLL();

        // enqueue some nodes
        queue.enqueue(new SNode<>(1));
        queue.enqueue(new SNode<>(2));
        queue.enqueue(new SNode<>(3));

        // peek at the head node
        System.out.println("Head node: " + queue.peek());

        // dequeue some nodes
        System.out.println("Dequeued node: " + queue.dequeue().getData());
        System.out.println("Dequeued node: " + queue.dequeue().getData());

        // enqueue some more nodes
        queue.enqueue(new SNode<>(4));
        queue.enqueue(new SNode<>(5));

        // print the queue
        System.out.print("Queue: ");
        printQueue(queue);

        // clear the queue
        queue.Clear();

        // print the queue
        System.out.print("Queue: ");
        printQueue(queue);
    }

    private static void printQueue(QueueLL queue) {
        SNode<Integer> node = queue.peek();
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

}
