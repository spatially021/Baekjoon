import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int num = sum(arr.get(i), arr.get(j));

                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else 
                    min2 = Math.min(min2,num);
                
            }

            result = Math.min(result, min1 + min2);
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }

    private static int sum(int[] I1, int[] I2) {
        return Math.abs(I1[0] - I2[0]) + Math.abs(I1[1] - I2[1]) + Math.abs(I1[2] - I2[2]);
    }


}
