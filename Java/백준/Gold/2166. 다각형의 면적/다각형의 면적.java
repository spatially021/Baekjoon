import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        double v1 = 0;
        double v2 = 0;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                v1 += arr[n - 1][0] * arr[0][1];
                v2 += arr[n - 1][1] * arr[0][0];
            } else {
                v1 += arr[i][0] * arr[i + 1][1];
                v2 += arr[i][1] * arr[i + 1][0];
            }
        }

        System.out.printf("%.1f%n", Math.abs(v1 - v2) * 0.5f);

    }

}
