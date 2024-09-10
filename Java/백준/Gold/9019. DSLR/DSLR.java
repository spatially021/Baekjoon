import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scan.nextInt();

        for(int t=0;t<T;t++){
            sb.append(bfs(scan.nextInt(),scan.nextInt())).append("\n");
        }

        System.out.println(sb);

    }

    private static String bfs(int a,int b){

        Queue<Integer> queue=new LinkedList<>();
        queue.add(a);

        boolean[] visited=new boolean[10001];
        visited[a]=true;

        String[] result=new String[10001];

        Arrays.fill(result,"");

        while (!queue.isEmpty()&&!visited[b]){

            int n=queue.poll();

            int D = (2 * n) % 10000;
            int S = n == 0 ? 9999 : n - 1;
            int L = (n % 1000) * 10 + n / 1000;
            int R = (n % 10) * 1000 + n / 10;

            if(!visited[D]){
                queue.add(D);
                visited[D]=true;
                result[D]=result[n]+"D";
            }
            if(!visited[S]){
                queue.add(S);
                visited[S]=true;
                result[S]=result[n]+"S";
            }
            if(!visited[L]){
                queue.add(L);
                visited[L]=true;
                result[L]=result[n]+"L";
            }
            if(!visited[R]){
                queue.add(R);
                visited[R]=true;
                result[R]=result[n]+"R";
            }

        }

        return result[b];

    }

}
