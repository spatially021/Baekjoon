import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[S];
        long totalLength = 0;  

        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            totalLength += arr[i];
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[S - 1];
        int result = 0;


        while (left <= right) {
            int mid = (left + right) / 2;
            int counter = 0;

            for (int i = 0; i < S; i++) {
                counter += arr[i] / mid;
            }

            if (counter >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long usedLength = (long) result * C;
        long leftover = totalLength - usedLength;

        System.out.println(leftover);
    }
}
