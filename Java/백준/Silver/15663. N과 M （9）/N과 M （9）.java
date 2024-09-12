import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[N];
        visited = new boolean[N];
        result=new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        dfs(0);

    }

    private static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                System.out.print(result[i] + " ");
            System.out.println();
        } else {
            int before = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;

                if (before != arr[i]) {
                    visited[i] = true;
                    result[cnt] = arr[i];
                    before = arr[i];
                    dfs(cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
