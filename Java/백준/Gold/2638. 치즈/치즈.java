import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static boolean[][] matrix;
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = "1".equals(st.nextToken());
            }
        }

        int times = 0;

        while (true) {
            ArrayList<int[]> arr = new ArrayList<>();

            boolean[][] air = bfs();  // 외부 공기 탐색

            // 치즈 조각 탐색 및 녹일 조각 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] && countExposedAir(i, j, air) >= 2) {
                        arr.add(new int[]{i, j});
                    }
                }
            }

            // 더 이상 녹일 치즈가 없으면 종료
            if (arr.isEmpty()) break;

            // 치즈 녹이기
            for (int[] pos : arr) {
                matrix[pos[0]][pos[1]] = false;
            }

            times++;
        }

        System.out.println(times);
    }

    // 주어진 좌표가 외부 공기와 접촉한 면의 개수를 세는 메서드
    private static int countExposedAir(int x, int y, boolean[][] air) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int dx = x + DX[k];
            int dy = y + DY[k];
            if (dx >= 0 && dx < n && dy >= 0 && dy < m && air[dx][dy]) {
                count++;
            }
        }
        return count;
    }

    // BFS를 통해 외부 공기를 탐색하는 메서드
    private static boolean[][] bfs() {
        boolean[][] air = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        air[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = pos[0] + DX[i];
                int dy = pos[1] + DY[i];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !matrix[dx][dy] && !air[dx][dy]) {
                    queue.add(new int[]{dx, dy});
                    air[dx][dy] = true;
                }
            }
        }

        return air;
    }
}
