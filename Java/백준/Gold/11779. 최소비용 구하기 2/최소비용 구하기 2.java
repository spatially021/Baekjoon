import java.io.*;
import java.util.*;

public class Main {

    private static List<Line>[] graph;
    private static int n;
    private static int[] route;
    private static final int INF = (int) 1e8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());  
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        route = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Line(to, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int cost = dijkstra(start, end);

        ArrayList<Integer> routes = new ArrayList<>();
        for (int current = end; current != 0; current = route[current]) {
            routes.add(current);
            if (current == start) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cost).append("\n");
        sb.append(routes.size()).append("\n");

        for (int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int curNode = u[0], curDist = u[1];

            if (visited[curNode]) continue;
            visited[curNode] = true;

            for (Line line : graph[curNode]) {
                int nextNode = line.to;
                int newDist = curDist + line.cost;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    route[nextNode] = curNode;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        return dist[end];
    }

    private static class Line {
        final int to;
        final int cost;

        public Line(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
