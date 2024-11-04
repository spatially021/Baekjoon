import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= m) {
                min = Math.min(min, high - low + 1);
                sum -= arr[low++];
            } else {
                if (++high == n) break;
                sum += arr[high];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
