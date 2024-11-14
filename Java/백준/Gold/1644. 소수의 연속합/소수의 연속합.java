import java.io.*;
import java.util.*;

public class Main {
    private static int[] prim;

    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] B = Eratosthenes(n);

        prim = new int[counter];

        int index = 0;

        int i = 0;
        for (boolean b : B) {
            if (b) {
                prim[index] = i;
                index++;
            }
            i++;
        }

        System.out.println(find(n));

    }

    private static boolean[] Eratosthenes(int max) {
        boolean[] B = new boolean[max + 1];

        Arrays.fill(B, true);
        B[0] = B[1] = false;

        for (int i = 2; i <= max; i++) {
            if (B[i]) {
                counter++;
                for (int j = i * 2; j <= max; j += i) {
                    B[j] = false;
                }
            }
        }

        return B;
    }

    private static int find(int target) {

        int left = 0;
        int right = 0;

        int result = 0;

        while (left<=right&&right<counter) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += prim[i];
            }

            if (sum == target) {
                result++;
                left++;
            } else if (sum < target) right++;
            else left++;

        }

        return result;
    }
}
