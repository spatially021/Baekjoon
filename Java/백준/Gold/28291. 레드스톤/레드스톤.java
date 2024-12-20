import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] matrix;

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
        for (int[] I : matrix) Arrays.fill(I, 15);

        int lamps = 0;

        ArrayList<int[]> blocks = new ArrayList<>();

        int lines = Integer.parseInt(br.readLine());

        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (s.equals("redstone_block")) {
                blocks.add(new int[]{x, y});
                matrix[x][y] = 16;
            } else if (s.equals("redstone_lamp")) {
                matrix[x][y] = -1;
                lamps++;
            } else {
                matrix[x][y] = 0;
            }
        }

        bw.write(lamps == bfs(blocks) ? "success" : "failed");
        bw.flush();

    }


    private static int bfs(ArrayList<int[]> blocks) {

        Queue<int[]> q = new LinkedList<>(blocks);

        int counter = 0;
        boolean[][] visited = new boolean[n][m];

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = pos[0] + DX[i];
                int dy = pos[1] + DY[i];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                    if (matrix[dx][dy] == -1 && !visited[dx][dy] && matrix[pos[0]][pos[1]] != 1) {
                        counter++;
                        visited[dx][dy] = true;
                    } else if (matrix[dx][dy] < matrix[pos[0]][pos[1]] - 1 && matrix[pos[0]][pos[1]] != 1) {
                        q.add(new int[]{dx, dy});
                        matrix[dx][dy] = matrix[pos[0]][pos[1]] - 1;
                    }
                }
            }
        }


        return counter;

    }


}
