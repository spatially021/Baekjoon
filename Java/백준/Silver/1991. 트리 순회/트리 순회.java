import java.io.*;
import java.util.*;

public class Main {
    private static Node[] nodes=new Node[26];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            char c = st.nextToken().charAt(0);
            Node node = new Node(c);
            node.addLeft(st.nextToken().charAt(0));
            node.addRight(st.nextToken().charAt(0));
            nodes[c-'A']=node;
        }

        front('A');
        sb.append("\n");
        middle('A');
        sb.append("\n");
        back('A');

        System.out.println(sb);

    }


    private static void front(char c){

        Node node=nodes[c-'A'];
        sb.append(node.getValue());
        if(node.getLeft()!='.') front(node.getLeft());
        if(node.getRight()!='.') front(node.getRight());

    }

    private static void middle(char c){

        Node node=nodes[c-'A'];
        if(node.getLeft()!='.') middle(node.getLeft());
        sb.append(node.getValue());
        if(node.getRight()!='.') middle(node.getRight());

    }

    private static void back(char c){

        Node node=nodes[c-'A'];
        if(node.getLeft()!='.') back(node.getLeft());
        if(node.getRight()!='.') back(node.getRight());
        sb.append(node.getValue());

    }

    private static class Node {

        private final char value;
        private char left;
        private char right;

        public Node(char c) {
            value = c;
        }

        public void addLeft(char c) {
            left = c;
        }

        public void addRight(char c) {
            right = c;
        }

        public char getLeft() {
            return left;
        }

        public char getRight() {
            return right;
        }

        public char getValue() {
            return value;
        }
    }

}
