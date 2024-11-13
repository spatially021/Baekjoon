import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] times = new int[n + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] nodes = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            int[] indegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodes[from].add(to);
                indegree[to]++;
            }

            int target = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            Arrays.fill(dp, INF);

            dp[1]=times[1];

            Queue<Integer> queue = new LinkedList<>();

            for(int i=1;i<n+1;i++){
                dp[i]=times[i];
                if(indegree[i]==0) queue.add(i);
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : nodes[current]) {
                    dp[next]=Math.max(dp[next],dp[current]+times[next]);
                    indegree[next]--;

                    if(indegree[next]==0) queue.add(next);

                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}
