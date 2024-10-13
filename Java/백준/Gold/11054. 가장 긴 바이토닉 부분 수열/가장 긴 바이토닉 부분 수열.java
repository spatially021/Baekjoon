import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[n];
        dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            lts(i);
            lis(i);
        }

        int[] result=new int[n];

        for(int i=0;i<n;i++){
            result[i]=dp[i][0]+dp[i][1];
        }

        System.out.println(Arrays.stream(result).max().getAsInt()-1);

    }

    private static int lts(int index) {


        if (dp[index][0] == 0) {

            dp[index][0] = 1;

            for (int i = index - 1; i >= 0; i--) {
                if (arr[i] < arr[index]) dp[index][0] = Math.max(dp[index][0], lts(i)+1);
            }
        }

        return dp[index][0];
    }

    private static int lis(int index) {

        if (dp[index][1] == 0) {
            dp[index][1] = 1;

            for (int i = index + 1; i < n; i++) {
                if (arr[i] < arr[index]) dp[index][1] = Math.max(dp[index][1], lis(i)+1);
            }
        }

        return dp[index][1];
    }


}
