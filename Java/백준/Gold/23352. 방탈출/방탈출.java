import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] matrix;

    private static int maxDistance = -1;
    private static int value = 0;

    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        boolean[][] canStart = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) canStart[i][j] = true;
                matrix[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canStart[i][j]) bfs(i, j);
            }
        }

        bw.write(String.valueOf(value));
        bw.flush();

    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {

                int dx = pos[0] + DX[i];
                int dy = pos[1] + DY[i];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && matrix[dx][dy] != 0) {

                    int dis = distance[pos[0]][pos[1]] + 1;
                    distance[dx][dy] = dis;
                    visited[dx][dy] = true;
                    q.add(new int[]{dx, dy});

                    if (dis > maxDistance) {
                        maxDistance = dis;
                        value = matrix[startX][startY] + matrix[dx][dy];
                    } else if (dis == maxDistance) value = Math.max(value, matrix[startX][startY] + matrix[dx][dy]);


                }

            }

        }

    }

}
