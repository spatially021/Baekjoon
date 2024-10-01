import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    private static Node[] nodes;
    private static int[] radius;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];
        radius = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int index=Integer.parseInt(st.nextToken());

            while (true){

                int toIndex = Integer.parseInt(st.nextToken());
                if(toIndex==-1) break;
                int distance = Integer.parseInt(st.nextToken());

                nodes[index].add(toIndex, distance);
                nodes[toIndex].add(index, distance);
            }

        }

        dfs(1,  new boolean[N + 1]);

        System.out.println(Arrays.stream(radius).max().getAsInt());

    }

    private static int dfs(int index,  boolean[] visited) {

        visited[index] = true;

        ArrayList<Integer> lens = new ArrayList<>();

        for (int[] I : nodes[index].connected) {
            if (visited[I[0]]) continue;
            lens.add(dfs(I[0], visited)+I[1]);

        }

        if (lens.isEmpty()) {
            radius[index] = -1;
            return 0;
        }
        lens.sort(Collections.reverseOrder());
        if (lens.size() == 1) radius[index] = lens.get(0);
        else radius[index]=lens.get(0)+lens.get(1);


        return lens.get(0);
    }


    private static class Node {

        final int index;

        final ArrayList<int[]> connected = new ArrayList<>();/*0 : connected node index,1 : distance*/

        private Node(int index) {
            this.index = index;
        }

        public void add(int toIndex, int distance) {

            connected.add(new int[]{toIndex, distance});

        }

    }


}
