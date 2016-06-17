import java.io.*;

class Solution {
    static Node successor(Node root, Node target) {
        if (target == null) return null;
        if (target.right != null) {
            target = target.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        } else {
            while (target.parent != null && target != target.parent.left) {
                target = target.parent;
            }

            return target.parent;
        }
    }

    static Node predecessor(Node root, Node target) {
        if (target == null) return null;
        if (target.left != null) {
            target = target.left;
            while (target.right != null) {
                target = target.right;
            }
            return target;
        } else {
            while (target.parent != null && target.parent.right != target) {
                target = target.parent;
            }
            return target.parent;
        }
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;

        }
        public Node(int value) {
            this(value, null);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.right = new Node(30, root);

        root.left = new Node(10, root);
        root.left.left = new Node(1, root.left);

        root.left.right = new Node(15, root.left);
        root.left.right.left = new Node(13, root.left.right);
        root.left.right.right = new Node(17, root.left.right);

        Node successor = successor(root, root.left);
        System.out.println(successor == null ? null : successor.value);
    }
}