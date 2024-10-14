import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static final int MAX = (int) 1e7 + 1;
    private static final int[] distance = new int[MAX];
    private static int n;
    private static int k;
    private static int counter = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(distance, (int) 1e8);
        bfs();
        System.out.printf("%d\n%d%n", distance[k] - 1, counter);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        distance[n] = 1; // 시작점의 거리를 1로 설정 (방문 표시)
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            // 목표 위치에 도달한 경우
            if (pos == k) {
                if (distance[pos] < min) {
                    counter = 1;
                    min = distance[pos];
                } else if (distance[pos] == min) {
                    counter++;
                }
                continue;
            }
            if(distance[pos]>=min) continue;
            if (pos * 2 < MAX && distance[pos * 2] >= distance[pos] + 1) {
                queue.add(pos * 2);
                distance[pos * 2] = distance[pos] + 1;
            }
            if (pos - 1 >= 0 && distance[pos - 1] >= distance[pos] + 1) {
                queue.add(pos - 1);
                distance[pos - 1] = distance[pos] + 1;
            }
            if (pos + 1 < MAX && distance[pos + 1] >= distance[pos] + 1) {
                queue.add(pos + 1);
                distance[pos + 1] = distance[pos] + 1;
            }

        }
    }
}
