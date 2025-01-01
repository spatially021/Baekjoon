import java.io.*;
import java.util.*;

public class Main {

    private static int[][] matrix = new int[501][501];
    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);

            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);

            for (int y = startY; y <= endY; y++) for (int x = startX; x <= endX; x++) matrix[x][y] = 1;
        }

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);

            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);
            for (int y = startY; y <= endY; y++)
                for (int x = startX; x <= endX; x++)
                    matrix[x][y] = -1;
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();

    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] hp = new int[501][501];
        int INF = 501 * 501;
        for (int[] I : hp) Arrays.fill(I, INF);

        q.add(new int[]{0, 0});
        hp[0][0] = 0;

        while (!q.isEmpty()) {
            int[] I = q.poll();
            int x = I[0];
            int y = I[1];

            for (int i = 0; i < 4; i++) {

                int dx = DX[i] + x;
                int dy = DY[i] + y;

                if (dx >= 0 && dx < 501 && dy >= 0 && dy < 501) {
                    if (matrix[dx][dy] != -1) {
                        if (hp[dx][dy] != INF) {
                            int sum = matrix[dx][dy] + hp[x][y];
                            if (sum < hp[dx][dy]) {
                                hp[dx][dy] = sum;
                                q.add(new int[]{dx, dy});
                            }
                        } else {
                            hp[dx][dy] = matrix[dx][dy] + hp[x][y];
                            q.add(new int[]{dx, dy});
                        }
                    }
                }

            }

        }

        return hp[500][500] == INF ? -1 : hp[500][500];
    }

}
