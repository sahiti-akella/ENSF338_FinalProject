package test.linearTests;

import main.java.myLib.datastructures.linear.QueueLL;
import main.java.myLib.datastructures.nodes.SNode;

public class QueueLLTests {

    /**
     * The main method of this class runs a set of tests on the QueueLL class.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        // create an empty queue
        QueueLL queue = new QueueLL();

        // enqueue some nodes
        queue.Enqueue(new SNode<>(1));
        queue.Enqueue(new SNode<>(2));
        queue.Enqueue(new SNode<>(3));

        // peek at the head node
        System.out.println("Head node: " + queue.peek());

        // dequeue some nodes
        System.out.println("Dequeued node: " + queue.Dequeue().getData());
        System.out.println("Dequeued node: " + queue.Dequeue().getData());

        // enqueue some more nodes
        queue.Enqueue(new SNode<>(4));
        queue.Enqueue(new SNode<>(5));

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
