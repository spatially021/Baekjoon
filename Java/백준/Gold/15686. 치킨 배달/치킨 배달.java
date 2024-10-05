import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int min = Integer.MAX_VALUE;

    private static final ArrayList<int[]> house = new ArrayList<>();
    private static final ArrayList<int[]> chicken = new ArrayList<>();
    private static int[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) house.add(new int[]{i, j});
                else if (num == 2) chicken.add(new int[]{i, j});
            }
        }

        selected = new int[M];

        dfs(0, 0);

        System.out.println(min);
    }

    private static int calculateDistance() {
        int totalDistance = 0;

        for (int[] h : house) {
            int hx = h[0];
            int hy = h[1];
            int minDistance = Integer.MAX_VALUE;

            for (int i : selected) {
                int[] c = chicken.get(i);
                int cx = c[0];
                int cy = c[1];
                minDistance = Math.min(minDistance, Math.abs(hx - cx) + Math.abs(hy - cy));
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }

    private static void dfs(int depth, int start) {
        if (depth == M) {
            min = Math.min(min, calculateDistance());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1);
        }
        
    }
}
