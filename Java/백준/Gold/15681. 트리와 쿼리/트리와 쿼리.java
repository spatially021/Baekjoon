import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] list;
    private static ArrayList<Integer>[] tree;

    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            list[i1].add(i2);
            list[i2].add(i1);

        }

        makeTree(r, -1);
        subTree(r);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }

    private static void makeTree(int curNode, int p) {
        for (int node : list[curNode]) {
            if (p != node) {
                tree[curNode].add(node);
                parent[node] = curNode;
                makeTree(node, curNode);
            }
        }
    }

    private static void subTree(int curNode) {

        size[curNode] = 1;

        for (int i : tree[curNode]) {
            subTree(i);
            size[curNode] += size[i];
        }

    }

}
