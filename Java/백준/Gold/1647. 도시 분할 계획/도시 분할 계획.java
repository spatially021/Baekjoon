import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Edge>[] graph;
    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph=new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Edge(w, cost));
            graph[w].add(new Edge(v, cost));
        }

        System.out.println(prim());

    }

    private static int prim() {

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 0));

        int total = 0;
        int max=0;

        while (!pq.isEmpty()) {

            Edge edge = pq.poll();

            int v = edge.w;
            int cost = edge.cost;

            if (visited[v]) continue;

            max=Math.max(max,cost);

            visited[v] = true;
            total += cost;

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }

        }

        return total-max;

    }

    private static class Edge implements Comparable<Edge> {

        final int w;
        final int cost;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
