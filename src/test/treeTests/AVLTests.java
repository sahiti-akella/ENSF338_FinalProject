package test.treeTests;

import main.java.myLib.datastructures.nodes.*;
import main.java.myLib.datastructures.trees.*;

public class AVLTests {
    public static void main(String[] args) {
       
        AVL avl = new AVL(30);

        // insert some nodes into the tree
        avl.Insert(9);
        avl.Insert(20);
        avl.Insert(79);
        avl.Insert(5);
        avl.Insert(16);
        avl.Insert(8);

        
        System.out.println("\nPrinting in Breadth First Order:");
        avl.printBF();

        TNode node = new TNode(50);
        node.setLeft(new TNode(30));
        node.getLeft().setLeft(new TNode(20));
        node.getLeft().setRight(new TNode(40));
        node.setRight(new TNode(70));
        node.getRight().setLeft(new TNode(60));
        node.getRight().setRight(new TNode(80));

        AVL balancedTree = new AVL(node);
   
        System.out.println("\nPrinting in Breadth First Order:");
        balancedTree.printBF();

        avl.Delete(14);

        TNode nodetosearch = avl.Search(40);
        if (nodetosearch  != null) {
            System.out.println("\nSearch for 40: \n" + nodetosearch.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }

        TNode nodetosearch2 = avl.Search(79);
        if (nodetosearch2  != null) {
            System.out.println("\nSearch for 79: \n" + nodetosearch2.data + " was found in the tree");
        } else {
            System.out.println("Value not found in tree");
        }
    }
}
