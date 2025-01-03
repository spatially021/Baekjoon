import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        int max = 0;

        while (max < n && arr[max] < k) {
            max++;
        }

        int left = 0, right = max - 1;
        int cnt = n - max;

        while (left < right) {
            if (arr[right] >= k) {
                cnt++;
                right--;
            } else if (arr[left] + arr[right] >= k) {
                cnt++;
                left++;
                right--;
            } else {
                left++;
            }
        }

        if (cnt == 0) {
            bw.write("-1\n");
        } else {
            bw.write(cnt + "\n");
        }

        bw.flush();
    }
}
