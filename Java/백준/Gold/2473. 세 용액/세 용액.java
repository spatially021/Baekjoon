import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int[] result = new int[3];

        // 3포인터 탐색
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (absSum < min) {
                    min = absSum;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    // 정확히 0이라면 더 탐색할 필요 없음
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    return;
                }
            }
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
