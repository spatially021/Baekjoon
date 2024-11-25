import java.io.*;
import java.util.*;

public class Main {


    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] cycled;
    private static int counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {

            int n = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];
            cycled = new boolean[n + 1];
            arr = new int[n + 1];
            counter = 0;

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i < n + 1; i++)
                arr[i] = Integer.parseInt(st.nextToken());


            for (int i = 1; i < n + 1; i++)
                dfs(i);


            sb.append(n - counter).append("\n");

        }

        System.out.println(sb);

    }

    private static void dfs(int index) {
        if (visited[index]) return;

        visited[index] = true;
        int next = arr[index];

        if (!visited[next]) dfs(next);
        else if (!cycled[next]) { // 사이클이 형성된 경우
            counter++;
            for (int i = next; i != index; i = arr[i]) counter++;
        }

        cycled[index] = true; // 현재 노드 처리 완료
    }

}
