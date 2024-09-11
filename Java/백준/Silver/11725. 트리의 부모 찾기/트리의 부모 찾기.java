import java.util.*;

public class Main {

    private static int[] parents;
    private static Node[] nodes;

    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        int N=scan.nextInt();

        nodes=new Node[N+1];
        parents=new int[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            nodes[i]=new Node(i);
        }

        for(int i=0;i<N-1;i++){
            int a= scan.nextInt();;
            int b=scan.nextInt();
            nodes[a].add(b);
            nodes[b].add(a);
        }

        bfs();

        for(int i=2;i<N+1;i++){
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(){

        Queue<Node> queue=new LinkedList<>();
        queue.add(nodes[1]);
        visited[1]=true;

        while (!queue.isEmpty()){

            Node node=queue.poll();

            for(int i: node.connected){
                if(!visited[i]){
                    queue.add(nodes[i]);
                    parents[i]=node.getIndex();
                    visited[i]=true;
                }
            }
        }

    }

    private static class Node{
       private final ArrayList<Integer> connected=new ArrayList<>();
       private final int index;

       public Node(int i){
           index=i;
       }

        public int getIndex() {
            return index;
        }

        public void add(int i){
           connected.add(i);
       }
    }
}
