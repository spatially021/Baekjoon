import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(calc(t) - calc(s - 1)));
        bw.flush();
    }

    private static long calc(int num) {
        long sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += num / i * (i % 2 == 0 ? 1 : -1);

        }

        return sum;
    }
    
}
