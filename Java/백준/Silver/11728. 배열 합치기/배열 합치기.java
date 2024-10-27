import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < n || pointer2 < m) {

            if (pointer1 >= n) {
                sb.append(arr2[pointer2++]).append(" ");
                continue;
            }
            if (pointer2 >= m) {
                sb.append(arr1[pointer1++]).append(" ");
                continue;
            }

            if (arr1[pointer1] < arr2[pointer2]) sb.append(arr1[pointer1++]).append(" ");
            else sb.append(arr2[pointer2++]).append(" ");

        }

        System.out.println(sb);

    }

}
