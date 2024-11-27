import java.io.*;
import java.util.*;

public class Main {

    private static int[][] Mdp;
    private static int[][] mdp;
    private static char[][] matrix;

    private static int n;

    private static final int[] DX = new int[]{1, 0};
    private static final int[] DY = new int[]{0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        matrix = new char[n + 1][n + 1];
        Mdp = new int[n + 1][n + 1];
        mdp = new int[n + 1][n + 1];

        for (int[] I : mdp) Arrays.fill(I, Integer.MAX_VALUE);
        for(int[] I:Mdp) Arrays.fill(I,Integer.MIN_VALUE);

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                matrix[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(matrix[1][1], 1, 1, matrix[1][1]-'0');

        System.out.println(Mdp[n][n] + " " + mdp[n][n]);

    }

    private static void dfs(char operator, int x, int y, int sum) {
        Mdp[x][y] = Math.max(Mdp[x][y], sum);
        mdp[x][y] = Math.min(mdp[x][y], sum);

        if (x == n && y == n) {
            return;
        }

        if (operator == '+') {
            for (int i = 0; i < 2; i++) {
                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx > 0 && dx < n + 1 && dy > 0 && dy < n + 1) {
                    dfs(matrix[dx][dy], dx, dy, sum + (matrix[dx][dy] - '0'));
                }
            }
        } else if (operator == '-') {
            for (int i = 0; i < 2; i++) {

                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx >= 1 && dx <= n && dy >= 1 && dy <= n) {
                    dfs(matrix[dx][dy], dx, dy, sum - (matrix[dx][dy] - '0'));
                }

            }
        } else if (operator == '*') {
            for (int i = 0; i < 2; i++) {

                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx >= 1 && dx <= n && dy >= 1 && dy <= n) {
                    dfs(matrix[dx][dy], dx, dy, sum * (matrix[dx][dy] - '0'));
                }

            }
        } else {
            for (int i = 0; i < 2; i++) {

                int dx = x + DX[i];
                int dy = y + DY[i];

                if (dx >= 1 && dx <= n && dy >= 1 && dy <= n) {
                    dfs(matrix[dx][dy], dx, dy, sum);
                }

            }
        }

    }

}
