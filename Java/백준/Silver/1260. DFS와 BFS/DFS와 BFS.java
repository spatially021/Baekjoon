import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static StringBuilder sb;

    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);

        }

        for (ArrayList<Integer> arr : graph) {
            arr.sort((o1, o2) -> o1 - o2);
        }

        sb = new StringBuilder();

        boolean[] visited = new boolean[n + 1];

        visited[v] = true;
        dfs(v, visited);
        sb.append("\n");
        bfs(v);


        System.out.println(sb);

    }

    private static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n + 1];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int index = q.poll();
            sb.append(index).append(" ");
            for (int i : graph[index]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        sb.append("\n");

    }

    private static void dfs(int index, boolean[] visited) {
        sb.append(index).append(" ");
        for (int i : graph[index]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited);
            }
        }

    }

}
