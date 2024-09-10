import java.util.*;

public class Main {
    private static int[][] matrix;
    private static int N;
    private static int M;
    private static boolean[][] visited;

    private static int max = 0;

    private static int[] DX = new int[]{1, 0, -1, 0};
    private static int[] DY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        matrix = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, matrix[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 3) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + DX[i];
            int dy = y + DY[i];

            if (dx >= 0 && dx < N && dy >= 0 && dy < M && !visited[dx][dy]) {

                if (depth == 1) {
                    visited[dx][dy] = true;
                    dfs(x, y, depth + 1, sum + matrix[dx][dy]);
                    visited[dx][dy] = false;
                }

                visited[dx][dy] = true;
                dfs(dx,dy, depth + 1, matrix[dx][dy] + sum);
                visited[dx][dy] = false;
            }
        }


    }

}
