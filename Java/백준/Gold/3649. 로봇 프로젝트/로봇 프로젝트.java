import java.io.*;
import java.util.*;

public class Main {

    private static final long CONVERT = 1000_0000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String s = br.readLine();
            if (s == null||s.equals("")) break;

            long x = Integer.parseInt(s) * CONVERT;
            int n = Integer.parseInt(br.readLine());

            int[] lines = new int[n];

            for (int i = 0; i < n; i++) lines[i] = Integer.parseInt(br.readLine());


            Arrays.sort(lines);

            int left = 0;
            int right = n - 1;
            boolean flag = false;


            while (left < right) {

                long sum = lines[left] + lines[right];

                if (sum == x) {
                    flag = true;
                    break;
                } else {
                    if (sum > x) right--;
                    else left++;
                }

            }


            if (flag) sb.append("yes ").append(lines[left]).append(" ").append(lines[right]).append("\n");
            else sb.append("danger\n");


        }

        bw.write(sb.toString());
        bw.flush();

    }

}