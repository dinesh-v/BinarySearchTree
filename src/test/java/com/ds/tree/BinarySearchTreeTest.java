package com.ds.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

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
        assertFalse(binarySearchTree.isIsomorphic());
        BinarySearchTree rootOnlyTree = new BinarySearchTree();
        // Tree with only root and no children is considered isomorphic
        rootOnlyTree.insertWithArray(3);
        assertTrue(rootOnlyTree.isIsomorphic());
        // Isomorphic tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.setRoot(new Node(1));
        tree.getRoot().left = new Node(2);
        tree.getRoot().right = new Node(3);
        tree.getRoot().left.left = new Node(4);
        tree.getRoot().left.right = new Node(5);
        tree.getRoot().right.left = new Node(6);
        tree.getRoot().left.right.left = new Node(7);
        tree.getRoot().left.right.right = new Node(8);
        BinarySearchTree isomorphicTree = new BinarySearchTree();
        isomorphicTree.setRoot(new Node(1));
        isomorphicTree.getRoot().left = new Node(3);
        isomorphicTree.getRoot().right = new Node(2);
        isomorphicTree.getRoot().right.left = new Node(4);
        isomorphicTree.getRoot().right.right = new Node(5);
        isomorphicTree.getRoot().left.right = new Node(6);
        isomorphicTree.getRoot().right.right.left = new Node(8);
        isomorphicTree.getRoot().right.right.right = new Node(7);
        assertTrue(isomorphicTree.isIsomorphic(tree.getRoot(), isomorphicTree.getRoot()));
    }

    @Test
    public void getNodeHeight() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        assertTrue(binarySearchTree.find(20));
        assertFalse(binarySearchTree.find(556));
    }

    @Test
    public void depthFirstTraversal() throws Exception {
        List<Integer> expected = new LinkedList<>();
        expected.addAll(Arrays.asList(3, 1, 2, 8, 4, 6, 10, 9, 20, 15, 16, 25));
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.PRE_ORDER);
        assertEquals(expected, binarySearchTree.getTreeData());
        expected.addAll(Arrays.asList(1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25));
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.INORDER);
        assertEquals(expected, binarySearchTree.getTreeData());
        expected.addAll(Arrays.asList(2, 1, 6, 4, 9, 16, 15, 25, 20, 10, 8, 3));
        binarySearchTree.depthFirstTraversal(binarySearchTree.getRoot(), BinarySearchTree.DepthFirstTraversal.POST_ORDER);
        assertEquals(expected, binarySearchTree.getTreeData());
    }

}