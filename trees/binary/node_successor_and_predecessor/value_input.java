import java.io.*;

class Solution {
    static Node successor(Node root, int target) {
        Node successor = null;
        // Doing a binary search to find the target node and while doing this,
        // keeping a "may be" successor node as the solution, because if I reached
        // the target and found it has no right subtree, then the successor should
        // be the last anscestor that I'm on its left subtree.
        while (root != null && root.value != target){
            if (root.value > target){
                successor = root;
                root = root.left;
            } else if (root.value < target){
                root = root.right;
            }
        }

        if (root != null) {
            if (root.right != null) {
                root = root.right;
                // If there is a right subtree then the successor is the most left node
                // in the right subtree.
                while (root != null){
                    successor = root;
                    root = root.left;
                }
            }
        } else {
            System.out.println("Target node not found");
            return null;
        }
        return successor;
    }

    static Node predecessor(Node root, int target) {
        Node predecessor = null;
        // Doing a binary search to find the target node and while doing this,
        // keeping a "may be" predecessor node as the solution, because if I reached
        // the target and found it has no left subtree, then the predecessor should
        // be the last anscestor that I'm on its right subtree.
        while (root != null && root.value != target) {
            if (root.value > target) {
                root = root.left;
            } else if (root.value < target) {
                predecessor = root;
                root = root.right;
            }
        }

        if (root != null) {
            if (root.left != null) {
                root = root.left;
                // If there is a left subtree then the predecessor is the most right node
                // in the left subtree.
                while (root != null){
                    predecessor = root;
                    root = root.right;
                }
            }
        } else {
            System.out.println("Target node not found");
            return null;
        }

        return predecessor;
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.right = new Node(30);

        root.left = new Node(10);
        root.left.left = new Node(1);

        root.left.right = new Node(15);
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(17);

        Node successor = successor(root, 15);
        System.out.println(successor == null ? null : successor.value);
    }
}