import java.io.*;
import java.util.*;

public class Main {
    private static int[][] matrix;
    private static int t, r, c;
    private static int counter = 0;
    private final static int[] DX = {1, 0, -1, 0};
    private final static int[] DY = {0, 1, 0, -1};
    private static final ArrayList<int[]> conditioner = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    conditioner.add(new int[]{i, j});
                }
                matrix[i][j] = num;
            }
        }
        timeCheck(0);
        System.out.println(counter);
    }

    private static void timeCheck(int depth) {
        if (depth == t) {
            for (int[] row : matrix) {
                for (int value : row) {
                    if (value != -1) {
                        counter += value;
                    }
                }
            }
            return;
        }
        spread();
        conditioner();
        timeCheck(depth + 1);
    }

    private static void spread() {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] += matrix[i][j]; // Carry over the original value
                if (matrix[i][j] > 0) {
                    int s = matrix[i][j] / 5;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int dx = i + DX[k];
                        int dy = j + DY[k];
                        if (dx >= 0 && dx < r && dy >= 0 && dy < c && matrix[dx][dy] != -1) {
                            temp[dx][dy] += s;
                            cnt++;
                        }
                    }
                    temp[i][j] -= s * cnt; // Subtract the spread portion from the original place
                }
            }
        }
        matrix = temp;
    }

    private static void conditioner() {
        int top = conditioner.get(0)[0];
        int bottom = conditioner.get(1)[0];

        // Top conditioner
        for (int x = top - 1; x > 0; x--) matrix[x][0] = matrix[x - 1][0];
        for (int y = 0; y < c - 1; y++) matrix[0][y] = matrix[0][y + 1];
        for (int x = 0; x < top; x++) matrix[x][c - 1] = matrix[x + 1][c - 1];
        for (int y = c - 1; y > 1; y--) matrix[top][y] = matrix[top][y - 1];
        matrix[top][1] = 0;

        // Bottom conditioner
        for (int x = bottom + 1; x < r - 1; x++) matrix[x][0] = matrix[x + 1][0];
        for (int y = 0; y < c - 1; y++) matrix[r - 1][y] = matrix[r - 1][y + 1];
        for (int x = r - 1; x > bottom; x--) matrix[x][c - 1] = matrix[x - 1][c - 1];
        for (int y = c - 1; y > 1; y--) matrix[bottom][y] = matrix[bottom][y - 1];
        matrix[bottom][1] = 0;
    }
}
