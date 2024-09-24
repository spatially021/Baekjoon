import java.io.*;
import java.util.*;

public class Main {

    private static Node[] nodes;
    private static int K;
    private static int V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());/*node count*/
        int E = Integer.parseInt(st.nextToken());/*line count*/

        K = Integer.parseInt(br.readLine());/*start node*/

        nodes = new Node[V + 1];

        for (int i = 1; i < V + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int index = Integer.parseInt(st.nextToken());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[index].add(v, w);

        }

        StringBuilder sb=new StringBuilder();

        int[] dis= dijkstra();


        for(int i=1;i<dis.length;i++){
            sb.append(dis[i]==Integer.MAX_VALUE?"INF":dis[i]).append("\n");
        }

        System.out.println(sb);

    }


    private static int[] dijkstra() {

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparing(a->a[1]));

        int[] dist=new int[V+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[K]=0;

        pq.add(new int[]{K,0});

        while (!pq.isEmpty()){

            int[] current=pq.poll();

            int u=current[0];
            int distance=current[1];

            if(distance>dist[u]) continue;

            for(int v:nodes[u].connected){

                int weight=nodes[u].getWeight().get(v);
                int newDist=dist[u]+weight;
                if(newDist<dist[v]){
                    dist[v]=newDist;
                    pq.add(new int[]{v,newDist});
                }

            }


        }

        return dist;


    }


    private static class Node {

        final int index;
        private final HashMap<Integer,Integer> weight =new HashMap<>();
        private final ArrayList<Integer> connected=new ArrayList<>();

        public Node(int i) {
            index = i;
        }

        public void add(int to, int weight) {
            if(!connected.contains(to)){
                connected.add(to);
                this.weight.put(to,weight);
            }else{
                this.weight.put(to,Math.min(this.weight.get(to),weight));
            }

        }

        public HashMap<Integer, Integer> getWeight() {
            return weight;
        }

        public ArrayList<Integer> getConnected() {
            return connected;
        }
    }

}
