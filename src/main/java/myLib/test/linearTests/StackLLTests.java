package main.java.myLib.test.linearTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.linear.*;

public class StackLLTests {

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
        stack.push(node2);
        stack.push(node3);
        stack.Print(); 
        
        // Test pop method
        System.out.println("\nTesting pop method...");
        SNode<Integer> popped = stack.pop();
        System.out.println("Popped node: " + popped.getData()); // expected output: Popped node: 3
        stack.Print(); // expected output: Stack: 2 1
        
        // Test peek method
        System.out.println("\nTesting peek method...");
        SNode<Integer> peeked = stack.peek();
        System.out.println("Peeked node: " + peeked.getData()); // expected output: Peeked node: 2
        
        // Test search method
        System.out.println("\nTesting search method...");
        SNode<Integer> node4 = new SNode<Integer>(4);
        SNode<Integer> found = stack.Search(node1);
        System.out.println("Found node: " + found.getData()); // expected output: Found node: 1
        found = stack.Search(node4);
        System.out.println("Found node: " + found); // expected output: Found node: null
        
        // Test clear method
        System.out.println("\nTesting clear method...");
        stack.Clear();
        stack.Print(); // expected output: Stack:
    }
    
}
