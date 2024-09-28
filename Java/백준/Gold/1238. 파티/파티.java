import java.io.*;
import java.util.*;

public class Main {

    private static List<int[]>[] graph;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to, cost});
        }

        // x로부터 각 노드까지의 최단 거리
        int[] distFromX = dijkstra(x);

        // 각 노드에서 x까지의 최단 거리
        int maxRoundTrip = 0;
        for (int i = 1; i <= N; i++) {
            if (i == x) continue;
            int[] distToX = dijkstra(i);
            maxRoundTrip = Math.max(maxRoundTrip, distFromX[i] + distToX[x]);
        }

        System.out.println(maxRoundTrip);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int currDist = curr[1];

            if (currDist > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                int alt = currDist + weight;
                if (alt < dist[v]) {
                    dist[v] = alt;
                    pq.add(new int[]{v, alt});
                }
            }
        }
        return dist;
    }
}
