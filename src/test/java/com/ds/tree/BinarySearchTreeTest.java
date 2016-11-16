package com.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dinesh on 16/11/16.
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
        assertEquals(6, binarySearchTree.treeHeight(BinarySearchTree.root));
    }

    @Test
    public void testMaxWidth() throws Exception {
        assertEquals(3, binarySearchTree.getMaxWidth());
    }

    @Test
    public void isBalancedNaive() throws Exception {
        assertFalse(binarySearchTree.isBalancedNaive(BinarySearchTree.root));
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

    }

}