import java.io.*;
import java.util.*;

public class Main {

    private static int[][] matrix;
    private static int[][] copied;

    private static int N;
    private static int M;
    private static int size;

    private static int max = -1;

    private static final ArrayList<int[]> virus = new ArrayList<>();

    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        copied = new int[N][M];
        size = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                matrix[i][j] = input;
                copied[i][j] = input;
                if (input == 2) virus.add(new int[]{i, j});
                else if(input==1) size--;
            }
        }

        size-=3;

        dps(0);

        System.out.println(max);

    }

    private static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int counter = 0;

        for (int i = 0; i < N; i++) {
            copied[i] = matrix[i].clone();
        }

        for (int[] I : virus) {
            queue.add(I);
            visited[I[0]][I[1]] = true;
            counter++;
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx >= 0 && dx < N && dy >= 0 && dy < M && !visited[dx][dy] && copied[dx][dy] != 1) {
                    queue.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                    counter++;
                }
            }
        }

        return size - counter;
    }

    private static void dps(int depth) {
        if (depth == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    dps(depth + 1);
                    matrix[i][j] = 0;
                }
            }
        }
    }


}
