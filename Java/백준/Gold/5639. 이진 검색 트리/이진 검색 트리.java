import java.io.*;

public class Main {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Node root = null;

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;

            int key = Integer.parseInt(input);
            if (root == null) {
                root = new Node(key, null);
            } else {
                insertNode(root, key);
            }
        }

        postOrderTraversal(root);

        System.out.println(sb);
    }

    private static void insertNode(Node node, int key) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, node);
            } else {
                insertNode(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(key, node);
            } else {
                insertNode(node.right, key);
            }
        }
    }

    private static void postOrderTraversal(Node node) {
        if (node == null) return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        sb.append(node.key).append("\n");
    }

    private static class Node {
        final int key;
        final Node parent;
        Node left;
        Node right;

        private Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
        }
    }
}
