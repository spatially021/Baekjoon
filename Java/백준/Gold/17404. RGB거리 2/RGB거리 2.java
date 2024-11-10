import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000 * 1_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int answer = INF;

        int[][] arr = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[1][i] = arr[1][i];
                else dp[1][i] = INF;
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }

            for (int i = 0; i < 3; i++)
                if (i != k) answer = Math.min(answer, dp[n][i]);
        }

        System.out.println(answer);

    }


}
