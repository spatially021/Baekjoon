import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[86401];

        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            int type = Integer.parseInt(st.nextToken());

            String[] rawT1 = st.nextToken().split(":");
            String[] rawT2 = st.nextToken().split(":");

            int h1 = Integer.parseInt(rawT1[0]);
            int m1 = Integer.parseInt(rawT1[1]);
            int s1 = Integer.parseInt(rawT1[2]);

            int h2 = Integer.parseInt(rawT2[0]);
            int m2 = Integer.parseInt(rawT2[1]);
            int s2 = Integer.parseInt(rawT2[2]);

            int t1 = h1 * 60 * 60 + m1 * 60 + s1;
            int t2 = h2 * 60 * 60 + m2 * 60 + s2;

            int sum = 0;

            for (int i = t1; i < t2; i++) {

                if (type == 1) times[i]++;
                sum += times[i];

            }

            if (type == 2) bw.write(sum + "\n");

        }


        bw.flush();

    }

}
