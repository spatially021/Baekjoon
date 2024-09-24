import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS()-1);

    }

    private static int BFS() {

        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[MAX];

        queue.add(N);

        time[N] = 1;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int n = queue.poll();

            if (n == K) min = Math.min(min, time[K]);


            if (n * 2 < MAX && (time[n * 2] == 0)) {
                queue.add(n * 2);
                time[n * 2] = time[n];
            }

            if (n - 1 >= 0 && time[n - 1] == 0) {
                queue.add(n - 1);
                time[n - 1] = time[n] + 1;
            }

            if (n + 1 < MAX && time[n + 1] == 0) {
                queue.add(n + 1);
                time[n + 1] = time[n] + 1;
            }

        }
        return min;
    }

}
