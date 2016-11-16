package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private static Node root;

    private BinarySearchTree() {
        root = null;
    }

    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
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

        System.out.println("Original Tree : ");
        b.display(BinarySearchTree.root);
        System.out.println("");
        b.levelOrderQueue(BinarySearchTree.root);
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

    private int treeHeight(Node root) {
        if (root == null) return 0;
        return (1 + Math.max(treeHeight(root.left), treeHeight(root.right)));
    }

    /**
     * If difference between left and right height of tree at any given branch is greater than 1
     * then the tree is unbalanced at which case, false will be returned
     * <a href="http://algorithms.tutorialhorizon.com/find-whether-if-a-given-binary-tree-is-balanced/">
     * Find whether if a Given Binary Tree is Balanced?</a>
     *
     * @param node Pass root node
     * @return Returns true if balance and false if not balances
     */
    private boolean isBalancedNaive(Node node) {
        if (root == null) return true;
        int heightDifference = treeHeight(node.left) - treeHeight(node.right);
        return Math.abs(heightDifference) <= 1 && isBalancedNaive(node.left) && isBalancedNaive(node.right);
    }

    private int getNodeHeight(Node root, Node node, int height) {
        if (root == null) return 0;
        if (root == node) return height;

        //Check if node is present in the left sub tree
        int level = getNodeHeight(root.left, node, height + 1);
        /*System.out.println("Left : " + level + " , height : " + height);*/
        if (level != 0) return level;

        //Check if node is present in the right sub tree
        level = getNodeHeight(root.right, node, height + 1);
        /*System.out.println("Right : " + level + " , height : " + height);*/
        return level;
    }

    /**
     * Finding the level of the node. The node passes along with root must have all the predecessors
     * i.e all of children as in main tree. So it is better to get the node when inserting into tree
     * <a href="http://algorithms.tutorialhorizon.com/get-the-height-of-a-node-in-a-binary-tree/">Get height of node in binary tree</a>
     *
     * @param root Root element
     * @param node Node object starting from root till node
     * @return Returns height of the node
     */
    private int getNodeHeight(Node root, Node node) {
        if (root == null) return 0;
        return getNodeHeight(root, node, 1);
    }

    /**
     * Breadth first search
     * <a href="http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/">
     * Breadth-First Search/Traversal in a Binary Tree</a>
     *
     * @param root Root element
     */
    private void levelOrderQueue(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(" " + n.data);
            if (n.left != null) {
                q.add(n.left);
                System.out.println("");
            }
            if (n.right != null)
                q.add(n.right);
        }
    }

    private boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        // successorParent
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    private Node insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return newNode;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return newNode;
                }
            }
        }
    }

    /**
     * Display in sorted order.
     *
     * @param root Root element
     */
    private void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
}