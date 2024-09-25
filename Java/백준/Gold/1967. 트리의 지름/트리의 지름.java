import java.io.*;
import java.util.*;

public class Main {

    private static Node[] nodes;
    private static int[] radius;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];
        radius = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }

        while (true) {
            String temp = br.readLine();

            if (temp == null || temp.trim().isEmpty()) break;

            StringTokenizer st = new StringTokenizer(temp);

            int index = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            nodes[index].add(to, len);
        }

        DFS(1);

        System.out.println(Arrays.stream(radius).max().getAsInt());
    }

    private static int DFS(int index) {

        ArrayList<Integer> lens = new ArrayList<>();

        for (int i : nodes[index].connected) {
            lens.add(DFS(i) + nodes[index].len.getOrDefault(i, 0));

        }

        lens.sort(Collections.reverseOrder());

        if (lens.isEmpty()) radius[index] = -1;
        else if(lens.size()==1) radius[index]= lens.get(0);
        else radius[index] = lens.get(0) + lens.get(1);

        return lens.isEmpty() ? 0 : lens.get(0);
    }

    private static class Node {

        final int index;
        final ArrayList<Integer> connected;
        final HashMap<Integer, Integer> len;

        public Node(int i) {
            index = i;
            connected = new ArrayList<>();
            len = new HashMap<>();
        }

        public void add(int i, int i1) {
            connected.add(i);
            len.put(i, i1);
        }
    }
}
