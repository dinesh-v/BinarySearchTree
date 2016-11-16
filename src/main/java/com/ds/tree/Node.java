package com.ds.tree;

/**
 * Binary tree contains only 2 children at the most.
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
