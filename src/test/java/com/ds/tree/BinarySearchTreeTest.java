package com.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test case for Binary search tree
 * TODO: Need to implement dynamic input and dynamic assert
 */
public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree = new BinarySearchTree();


    @Before
    public void setUp() throws Exception {
        binarySearchTree.insertWithArray(3, 1, 8, 2, 4, 10, 6, 9, 20, 15, 25, 16);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void treeHeight() throws Exception {
        assertEquals(6, binarySearchTree.treeHeight(binarySearchTree.getRoot()));
    }

    @Test
    public void testMaxWidth() throws Exception {
        assertEquals(3, binarySearchTree.getMaxWidth());
    }

    @Test
    public void isBalancedNaive() throws Exception {
        assertFalse(binarySearchTree.isBalancedNaive(binarySearchTree.getRoot()));
    }

    @Test
    public void testIsIsomorphicTree() throws Exception {
        BinarySearchTree tree = new BinarySearchTree();

        // Let us create trees shown in above diagram
        /*tree.id = new Node(1);
        tree.id.left = new Node(2);
        tree.id.right = new Node(3);
        tree.id.left.left = new Node(4);
        tree.id.left.right = new Node(5);
        tree.id.right.left = new Node(6);
        tree.id.left.right.left = new Node(7);
        tree.id.left.right.right = new Node(8);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.right.left = new Node(4);
        tree.root2.right.right = new Node(5);
        tree.root2.left.right = new Node(6);
        tree.root2.right.right.left = new Node(8);
        tree.root2.right.right.right = new Node(7);

        if (tree.isIsomorphic(tree.id, tree.root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");*/
    }

    @Test
    public void getNodeHeight() throws Exception {

    }

    @Test
    public void getNodeHeight1() throws Exception {

    }

    @Test
    public void breadthFirstTraversal() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getSuccessor() throws Exception {

    }

    @Test
    public void insertWithArray() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void depthFirstTraversal() throws Exception {
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.PRE_ORDER);
        System.out.println("");
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.INORDER);
        System.out.println("");
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.POST_ORDER);
    }

}