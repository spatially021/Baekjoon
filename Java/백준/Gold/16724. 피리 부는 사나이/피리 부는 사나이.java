import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] visited;
    private static char[][] matrix;
    private static boolean[][] cycled;

    private static int counter = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        matrix = new char[n][m];
        cycled = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            System.arraycopy(c, 0, matrix[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) dfs(i, j);
            }
        }

        System.out.println(counter);

    }

    private static void dfs(int x, int y) {
        int dx = x;
        int dy = y;

        if (matrix[x][y] == 'D') dx++;
        else if (matrix[x][y] == 'U') dx--;
        else if (matrix[x][y] == 'R') dy++;
        else dy--;

        if (!visited[dx][dy]) {
            visited[dx][dy] = true;
            dfs(dx, dy);

        } else {
            if (!cycled[dx][dy]) counter++;
        }

        cycled[dx][dy] = true;

    }

}
