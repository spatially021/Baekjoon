import java.io.*;
import java.util.ArrayList;

public class Main {

    private static char[] c1;
    private static char[] c2;
    private static Integer[][] dp;

    private static final ArrayList<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        c1 = br.readLine().toCharArray();
        c2 = br.readLine().toCharArray();

        dp = new Integer[c1.length][c2.length];

        int len = lcs(c1.length - 1, c2.length - 1);

        if (len == 0) {
            System.out.println(len);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");

        char[] temp=new  char[len];

        for (int i = result.size() - 1; i >= 0; i--) {
            int[] pos = result.get(i);
            if (dp[pos[0]][pos[1]] == len) {
                temp[len-1]=c1[pos[0]];
                len--;
            }

        }

        for(char c:temp){
            sb.append(c);
        }

        System.out.println(sb);

    }

    private static int lcs(int x, int y) {

        if (x == -1 || y == -1) return 0;

        if (dp[x][y] == null) {

            dp[x][y] = 0;

            if (c1[x] == c2[y]) {
                dp[x][y] = lcs(x - 1, y - 1) + 1;
                result.add(new int[]{x, y});
            } else dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));

        }

        return dp[x][y];

    }

}
