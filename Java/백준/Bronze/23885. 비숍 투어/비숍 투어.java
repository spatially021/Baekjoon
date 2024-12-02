import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] start = new int[2];
        int[] end = new int[2];

        st = new StringTokenizer(br.readLine(), " ");
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        if (end[0] > n || end[1] > m) {
            bw.write("NO");
            bw.flush();

        } else if (end[0] < 1 || end[1] < 1) {
            bw.write("NO");
            bw.flush();

        } else {
            boolean flag = false;
            for (int i = start[0]; i <= n; i += 2) {
                if (i == end[0]) {
                    flag = true;
                    break;
                }
            }

            for (int i = start[0]; i > 0; i -= 2) {
                if (i == end[0]) {
                    flag = true;
                    break;
                }
            }
            bw.flush();

            if (!flag) {
                bw.write("NO");
                bw.flush();

                return;
            }

            for (int i = start[1]; i <= m; i += 2) {
                if (i == end[1]) {
                    bw.write("YES");
                    bw.flush();

                    return;
                }
            }

            for (int i = start[1]; i > 0; i -= 2) {
                if (i == end[1]) {
                    bw.write("YES");
                    bw.flush();

                    return;
                }
            }

            bw.write("NO");
            bw.flush();


        }
    }

}