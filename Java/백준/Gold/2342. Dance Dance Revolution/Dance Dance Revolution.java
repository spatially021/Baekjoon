import java.io.*;
import java.util.*;

public class Main {

    private static int index;
    private static final int[] move = new int[10_0001];


    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");


        index = 0;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n != 0) move[index++] = n;
        }
        dp = new int[5][5][index];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(find(0, 0, 0));

    }

    private static int find(int left, int right, int depth) {

        if (depth == index) return 0;
        if (dp[left][right][depth] != -1) return dp[left][right][depth];

        dp[left][right][depth] = Math.min(find(move[depth], right, depth + 1) + power(left, move[depth]), find(move[depth], left, depth + 1) + power(right, move[depth]));

        return dp[left][right][depth];

    }

    private static int power(int from, int to) {

        if (from == 0) return 2;
        if (from == to) return 1;

        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }


}