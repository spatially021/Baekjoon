import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        while (true) {

            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            ArrayList<int[]>[] roads = new ArrayList[n];

            for (int i = 0; i < n; i++) roads[i] = new ArrayList<>();

            int sum = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                roads[x].add(new int[]{y, z});
                roads[y].add(new int[]{x, z});

                sum += z;

            }

            bw.write(String.valueOf(sum - prim(n, roads)));
            bw.write("\n");

        }


        bw.flush();
    }

    private static int prim(int n, ArrayList<int[]>[] roads) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        boolean[] visited = new boolean[n];
        int total = 0;

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] road = pq.poll();

            if (visited[road[0]]) continue;

            visited[road[0]] = true;

            total += road[1];

            for (int[] I : roads[road[0]]) {
                if (!visited[I[0]]) pq.add(I);
            }

        }

        return total;

    }

}

