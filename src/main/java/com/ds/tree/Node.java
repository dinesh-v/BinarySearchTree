package com.ds.tree;

/**
 * Binary tree contains only 2 children at the most.
 */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
