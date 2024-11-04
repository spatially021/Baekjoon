import java.util.*;

public class Main {

    private static int[][][] graph;
    private static int[][][] distance;
    private static int M, N, H;

    private static int count;

    private static int[] DX = new int[]{1, 0, -1, 0, 0, 0};
    private static int[] DY = new int[]{0, 1, 0, -1, 0, 0};
    private static int[] DZ = new int[]{0, 0, 0, 0, 1, -1};

    private static ArrayList<int[]> pos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        graph = new int[H][N][M];
        distance = new int[H][N][M];

        count = M * N * H;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int input = scan.nextInt();
                    graph[h][n][m] = input;
                    if (input == 1) {
                        pos.add(new int[]{h, n, m});
                        distance[h][n][m] = 0;
                        count--;
                    } else if (input == -1) count--;
                }
            }
        }

        if (bfs()) {
            int maxDistance = Arrays.stream(distance)
                    .flatMap(Arrays::stream)
                    .flatMapToInt(Arrays::stream)
                    .max()
                    .orElse(-1);
            System.out.println(maxDistance);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean bfs() {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[H][N][M];
        int counter = 0;

        for (int[] I : pos) {
            int z = I[0];
            int x = I[1];
            int y = I[2];

            queue.add(I);
            visited[z][x][y] = true;
        }

        while (!queue.isEmpty()) {

            int[] n = queue.poll();

            int z = n[0];
            int x = n[1];
            int y = n[2];

            for (int i = 0; i < 6; i++) {

                int dx = x + DX[i];
                int dy = y + DY[i];
                int dz = z + DZ[i];

                if (dx >= 0 && dx < N && dy >= 0 && dy < M && dz >= 0 && dz < H && !visited[dz][dx][dy] && graph[dz][dx][dy] == 0) {
                    counter++;
                    queue.add(new int[]{dz, dx, dy});
                    visited[dz][dx][dy] = true;
                    distance[dz][dx][dy] = distance[z][x][y] + 1;
                    graph[dz][dx][dy] = 1;
                }
            }
        }

        return counter == count;
    }
}
