import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }

        int[] result = new int[n + 1];
        int[] index = new int[max + 1];

        for (int i = 0; i < n; i++) index[arr[i]] = i + 1;

        for (int x : arr) {
            for (int i = x * 2; i <= max; i += x) {
                if (index[i] != 0) {
                    result[index[x]]++;
                    result[index[i]]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
