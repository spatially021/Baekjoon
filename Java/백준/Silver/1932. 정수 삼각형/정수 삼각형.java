import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static Integer[][] dp;
    private static int N;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));


    }

    private static int find(int depth, int index) {

        if (depth == N - 1) return dp[depth][index];

        if (dp[depth][index] == null)
            dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1))+arr[depth][index];

        return dp[depth][index];

    }

}
