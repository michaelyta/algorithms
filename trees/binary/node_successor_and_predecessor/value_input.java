import java.io.*;

class Solution {
    static Node successor(Node root, int target) {
        Node successor = null;
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