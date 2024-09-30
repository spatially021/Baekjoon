import java.io.*;
import java.util.*;

public class Main {

    private final static int[] DX = new int[]{1, 0, -1, 0};
    private final static int[] DY = new int[]{0, 1, 0, -1};


    private static int[][] matrix;

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                matrix[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});

        int[][] distance = new int[N + 1][M + 1];
        boolean[][][] visited = new boolean[N + 1][M + 1][2];

        distance[1][1] = 1;

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            int x = pos[0];
            int y = pos[1];

            boolean destroyed = pos[2] == 1;

            if(x==N&&y==M) return distance[N][M];

            for (int i = 0; i < 4; i++) {

                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx > 0 && dx < N + 1 && dy > 0 && dy < M + 1) {
                    if (matrix[dx][dy] == 1) {
                        if (!destroyed) {
                            queue.add(new int[]{dx, dy, 1});
                            visited[dx][dy][1] = true;
                            distance[dx][dy] = distance[x][y] + 1;
                        }
                    } else {
                        if (!visited[dx][dy][destroyed ? 1 : 0]) {
                            queue.add(new int[]{dx, dy, destroyed ? 1 : 0});
                            visited[dx][dy][destroyed ? 1 : 0] = true;
                            distance[dx][dy] = distance[x][y] + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }


}
