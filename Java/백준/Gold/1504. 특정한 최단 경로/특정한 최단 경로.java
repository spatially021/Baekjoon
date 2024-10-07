import java.io.*;
import java.util.*;

public class Main {
    private static Node[] nodes;
    private static boolean[] visited;

    private static int N;

    private static final int INF=(int) 1e+7;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[index].add(to, cost);
            nodes[to].add(index, cost);

        }

        st=new StringTokenizer(br.readLine()," ");
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());

        int result1=dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,N);
        int result2=dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,N);

        if(result1>=INF&&result2>=INF) System.out.println(-1);
        else System.out.println(Math.min(result1,result2));


    }

    private static int dijkstra(int start,int end) {

        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);

        dist[start]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        pq.add(new int[]{start,dist[start]});

        while (!pq.isEmpty()){
            int[] u=pq.poll();
            for(int[] I:nodes[u[0]].connected){

                int alt=dist[u[0]]+I[1];
                if(alt<dist[I[0]]){
                    visited[I[0]]=true;
                    dist[I[0]]=alt;
                    pq.add(new int[]{I[0],alt});
                }
            }
        }

        return dist[end];
    }

    private static class Node {

        public final int index;
        public final ArrayList<int[]> connected = new ArrayList<>();

        public Node(int i) {
            index = i;
        }

        public void add(int i, int i1) {
            connected.add(new int[]{i, i1});
        }


    }


}
