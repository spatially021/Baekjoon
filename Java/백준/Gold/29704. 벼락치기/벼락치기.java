import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][t + 1];

        int sum = 0;
        int values = 0;

        for (int i = 1; i < n + 1; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            w[i] = num;
            int value = Integer.parseInt(st.nextToken());
            v[i] = value;
            values += value;
            sum += num;
        }

        if (sum <= t) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < t + 1; j++) {
                if (w[i] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        bw.write(String.valueOf(values - dp[n][t]));
        bw.flush();
    }

}