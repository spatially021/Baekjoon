import java.io.*;
import java.util.*;

public class Main {

    private static Node[] nodes;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];

        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int city = Integer.parseInt(st.nextToken());
            Line line = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            nodes[city].add(line);
        }

        st=new StringTokenizer(br.readLine()," ");
        int start=Integer.parseInt(st.nextToken());
        target=Integer.parseInt(st.nextToken());

        System.out.println(find(start));

    }

    private static int find(int start) {
        int[] dist=new int[nodes.length];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

        PriorityQueue<Line> priorityQueue=new PriorityQueue<>(Comparator.comparing(l->l.cost));

        priorityQueue.add(new Line(start,0));

        while (!priorityQueue.isEmpty()){

            Line current=priorityQueue.poll();
            int city=current.to;
            int cost=current.cost;

            if(cost>dist[city]) continue;

            for(Line line:nodes[city].getConnected()){
                int next=line.to;
                int nextCost=cost+line.cost;

                if(nextCost<dist[next]){
                    dist[next]=nextCost;
                    priorityQueue.add(new Line(next,nextCost));
                }
            }

        }

        return dist[target];

    }

    private static class Node {
        private final int city;
        private final ArrayList<Line> connected = new ArrayList<>();

        public Node(int i) {
            city = i;
        }

        public void add(Line line) {
            connected.add(line);
        }

        public ArrayList<Line> getConnected() {
            return connected;
        }

        public int getCity() {
            return city;
        }
    }

    private static class Line {
        int to;
        int cost;

        public Line(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

    }


}
