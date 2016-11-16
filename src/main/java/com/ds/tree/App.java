package com.ds.tree;

/**
 * Class to test Binary Search Tree functionality
 */
public class App {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        // Tree Image - http://algorithms.tutorialhorizon.com/files/2014/09/Complete-Example-1.png
        b.insert(3);
        Node x = b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);


        /*b.insertWithArray(5, 10, 15, 20, 25, 30, 35);
        // Binary search tree with 6 leaf nodes. <a href="http://2.bp.blogspot.com/-3eyinMSgNi4/Vio9pd_tdYI/AAAAAAAAD-8/zT2D0lgWa8s/s1600/binary%2BSearch%2BTree%2Bin%2BJava.png"><a/>*//*
        b.insertWithArray(7, 5, 3, 6, 1, 4, 12, 9, 15, 8, 10, 13, 17);*/

        System.out.println(" In order Depth first traversal : ");
        b.depthFirstTraversal(BinarySearchTree.root, BinarySearchTree.DepthFirstTraversal.INORDER);
        System.out.println("\n Breadth first traversal");
        System.out.println("\n The max width of tree is : " + b.getMaxWidth());
        /*System.out.println("\n Tree height (Sum of longest path edges from root to leaf) : " + b.treeHeight(BinarySearchTree.root));
        System.out.println("\n Height of the node is : " + b.getNodeHeight(BinarySearchTree.root, x));
        System.out.println("\n Is the tree balanced (or) balance naive? ");
        System.out.println(b.isBalancedNaive(BinarySearchTree.root));

        System.out.println("\n Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("\n Delete Node with no children (2) : " + b.delete(2));
        b.display(root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        b.display(root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        b.display(root);
        System.out.println("\n Tree height");
        System.out.println(b.treeHeight(BinarySearchTree.root));*/
    }
}
