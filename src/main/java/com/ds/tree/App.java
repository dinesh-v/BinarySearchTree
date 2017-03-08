package com.ds.tree;

/**
 * Class to test Binary Search Tree functionality
 */
public class App {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Tree Image - resources/Complete-Example-1.png
        bst.insert(3);
        Node x = bst.insert(8);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(9);
        bst.insert(20);
        bst.insert(25);
        bst.insert(15);
        bst.insert(16);


        /*bst.insertWithArray(5, 10, 15, 20, 25, 30, 35);
        // Binary search tree with 6 leaf nodes. <a href="http://2.bp.blogspot.com/-3eyinMSgNi4/Vio9pd_tdYI/AAAAAAAAD-8/zT2D0lgWa8s/s1600/binary%2BSearch%2BTree%2Bin%2BJava.png"><a/>*//*
        bst.insertWithArray(7, 5, 3, 6, 1, 4, 12, 9, 15, 8, 10, 13, 17);*/

        System.out.println(" In order Depth first traversal : ");
        bst.depthFirstTraversal(bst.getRoot(), BinarySearchTree.DepthFirstTraversal.INORDER);
        System.out.println("\n Breadth first traversal");
        System.out.println("\n The max width of tree is : " + bst.getMaxWidth());
        /*System.out.println("\n Tree height (Sum of longest path edges from root to leaf) : " + bst.treeHeight(BinarySearchTree.root));
        System.out.println("\n Height of the node is : " + bst.getNodeHeight(BinarySearchTree.root, x));
        System.out.println("\n Is the tree balanced (or) balance naive? ");
        System.out.println(bst.isBalancedNaive(BinarySearchTree.root));

        System.out.println("\n Check whether Node with value 4 exists : " + bst.find(4));
        System.out.println("\n Delete Node with no children (2) : " + bst.delete(2));
        bst.display(root);
        System.out.println("\n Delete Node with one child (4) : " + bst.delete(4));
        bst.display(root);
        System.out.println("\n Delete Node with Two children (10) : " + bst.delete(10));
        bst.display(root);
        System.out.println("\n Tree height");
        System.out.println(bst.treeHeight(BinarySearchTree.root));*/
    }
}
