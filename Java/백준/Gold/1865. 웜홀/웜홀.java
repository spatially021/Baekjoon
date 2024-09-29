import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Edge> graph;
    private static Node[] nodes;
    private static ArrayList<Integer> starts=new ArrayList<>();
    private static boolean[] visited;

    private static int N;
    private static int M;
    private static int W;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            nodes=new Node[N+1];
            visited=new boolean[N+1];

            for(int i=1;i<N+1;i++){
                nodes[i]=new Node(i);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));

                nodes[s].add(e);
                nodes[e].add(s);

            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, -t));
                nodes[s].add(e);
            }

            for(int i=1;i<N+1;i++){
                if(!visited[i]){
                    starts.add(i);
                    BFS(i);
                }
            }

            boolean hasNegative = check();

            sb.append(hasNegative ? "YES" : "NO").append("\n");

        }

        System.out.println(sb);

    }

    private static boolean check(){
        for(int i:starts){
            if(bellmanFord(i)) return true;
        }
        return false;
    }

    private static void BFS(int start) {

        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;

        while (!queue.isEmpty()){
            int n=queue.poll();
            for(int i:nodes[n].connected){
                if(!visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }

    }


    private static boolean bellmanFord(int start) {

        int[] dist = new int[N + 1];
        final int INF = (int) 1e8;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        // N - 1번 반복 (노드 수 - 1)
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < graph.size(); j++) {

                Edge edge = graph.get(j);

                // dist[edge.v]가 INF가 아니어야 하고, 더 짧은 경로가 발견되면 갱신
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        // 음수 사이클 확인: 한 번 더 반복하면서 갱신이 일어나는지 확인
        for (int j = 0; j < graph.size(); j++) {
            Edge edge = graph.get(j);

            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                return true; // 음수 사이클이 존재함
            }
        }

        return false; // 음수 사이클이 없음
    }


    private static class Edge {

        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {

            this.v = v;
            this.w = w;
            this.cost = cost;

        }

    }

    private static class Node {
        final int index;
        final ArrayList<Integer> connected=new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        public void add(int i){
            connected.add(i);
        }


    }

}
