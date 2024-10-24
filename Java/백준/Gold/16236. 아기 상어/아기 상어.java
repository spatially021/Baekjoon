import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    private static int[][] matrix;

    private static int count = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];

        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 9) {
                    start[0] = i;
                    start[1] = j;
                } else if (num != 0) count++;
            }
        }

        System.out.println(bfs(start));

    }

    private static int bfs(int[] p) {
        int size = 2;
        int eatCount = 0;
        int time = 0;
        int[] start = p;

        while (count > 0) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            boolean[][] visited = new boolean[n][n];
            int[][] distance = new int[n][n];
            visited[start[0]][start[1]] = true;
            matrix[start[0]][start[1]] = 0;

            List<int[]> candidates = new ArrayList<>();
            int minDist = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = pos[0] + DX[i];
                    int dy = pos[1] + DY[i];

                    if (dx >= 0 && dx < n && dy >= 0 && dy < n && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        distance[dx][dy] = distance[pos[0]][pos[1]] + 1;

                        if (matrix[dx][dy] == 0 || matrix[dx][dy] == size) {
                            queue.add(new int[]{dx, dy});
                        } else if (matrix[dx][dy] < size) {
                            if (distance[dx][dy] <= minDist) {
                                minDist = distance[dx][dy];
                                candidates.add(new int[]{dx, dy});
                            }
                        }
                    }
                }
            }

            if (candidates.isEmpty()) {
                return time;  // 더 이상 먹을 수 있는 물고기가 없을 때
            }

            // 가장 위쪽, 왼쪽의 먹이 선택
            candidates.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            int[] chosen = candidates.get(0);
            time += distance[chosen[0]][chosen[1]];
            eatCount++;
            count--;
            matrix[chosen[0]][chosen[1]] = 0;
            start = chosen;

            if (eatCount == size) {
                size++;
                eatCount = 0;
            }
        }
        return time;
    }



}
