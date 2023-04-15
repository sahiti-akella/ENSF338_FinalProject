package test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class StackLLTests {

    /**
     * The main method of this class runs a set of tests on the StackLL class.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args) {
    
        StackLL stack = new StackLL();
        
        System.out.println("Testing empty constructor...");
        stack.Print(); 
        
        System.out.println("\nTesting constructor with argument node...");
        SNode<Integer> node1 = new SNode<Integer>(1);
        stack = new StackLL(node1);
        stack.Print(); 
        
        // Test push method
        System.out.println("\nTesting push method...");
        SNode<Integer> node2 = new SNode<Integer>(2);
        SNode<Integer> node3 = new SNode<Integer>(3);
        stack.Push(node2);
        stack.Push(node3);
        stack.Print(); 
        
        // Test pop method
        System.out.println("\nTesting pop method...");
        SNode<Integer> popped = stack.Pop();
        System.out.println("Popped node: " + popped.getData()); 
        stack.Print(); 
        
        // Test peek method
        System.out.println("\nTesting peek method...");
        SNode<Integer> peeked = stack.Peek();
        System.out.println("Peeked node: " + peeked.getData()); 
        
        // Test search method
        System.out.println("\nTesting search method...");
        SNode<Integer> node4 = new SNode<Integer>(4);
        SNode<Integer> found = stack.Search(node1);
        System.out.println("Found node: " + found.getData()); 
        found = stack.Search(node4);
        System.out.println("Found node: " + found); 
        
        System.out.println("\nTesting clear method...");
        stack.Clear();
        stack.Print(); 
    }
    
}
