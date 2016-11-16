package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree {

    static Node root;
    static int maxWidth = 0;

    BinarySearchTree() {
        root = null;
    }

    int treeHeight(Node root) {
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
    boolean isBalancedNaive(Node node) {
        if (root == null) return true;
        int heightDifference = treeHeight(node.left) - treeHeight(node.right);
        return Math.abs(heightDifference) <= 1 && isBalancedNaive(node.left) && isBalancedNaive(node.right);
    }

    int getNodeHeight(Node root, Node node, int height) {
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
    int getNodeHeight(Node root, Node node) {
        if (root == null) return 0;
        return getNodeHeight(root, node, 1);
    }

    /**
     * Breadth first Traversal aka Level order traversal
     * <a href="http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/">
     * Breadth-First Search/Traversal in a Binary Tree</a>
     *
     * @param root Root element
     */
    void breadthFirstTraversal(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        int levelNodes;
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            levelNodes = q.size();
            if (maxWidth < levelNodes) {
                maxWidth = levelNodes;
            }
            Node n = q.remove();
            System.out.print(" " + n.data);
            if (n.left != null) {
                q.add(n.left);
                System.out.println("");
            }
            if (n.right != null)
                q.add(n.right);
            --levelNodes;
        }
    }

    int getMaxWidth() {
        breadthFirstTraversal(root);
        return maxWidth;
    }

    boolean find(int id) {
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

    boolean delete(int id) {
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

    Node getSuccessor(Node deleteNode) {
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

    Node insertWithArray(int... tree) {
        Node fullTree = null;
        for (int i :
                tree) {
            fullTree = insert(i);
        }
        return fullTree;
    }

    Node insert(int id) {
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
     * Depth First Traversal
     * Inorder DFT is used in this method
     *
     * @param root Root element
     */
    void depthFirstTraversalInOrder(Node root) {
        if (root != null) {
            depthFirstTraversalInOrder(root.left);
            System.out.print(" " + root.data);
            depthFirstTraversalInOrder(root.right);
        }
    }

    /**
     * Depth First Traversal
     * Pre order DFT is used in this method
     *
     * @param root Root element
     */
    void depthFirstTraversal(Node root, DepthFirstTraversal type) {
        if (root != null) {
            if (type == DepthFirstTraversal.PREORDER) System.out.print(" " + root.data);
            depthFirstTraversal(root.left, type);
            if (type == DepthFirstTraversal.INORDER) System.out.print(" " + root.data);
            depthFirstTraversal(root.right, type);
            if (type == DepthFirstTraversal.POSTORDER) System.out.print(" " + root.data);
        }
    }

    enum DepthFirstTraversal {
        INORDER, PREORDER, POSTORDER
    }
}