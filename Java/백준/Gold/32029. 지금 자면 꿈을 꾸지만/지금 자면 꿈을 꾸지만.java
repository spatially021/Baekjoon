import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] task = new int[n];

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            task[i] = num;
        }

        Arrays.sort(task);

        int max = 0;

        for (int x = a - 1; x >= 0; x--) {

            for (int i = 0; i < n; i++) {
                int time = 0;
                int cnt = 0;
                for (int j = 0; j < i; j++) {
                    time += a;
                    if (time <= task[j]) cnt++;
                    else time -= a;
                }

                int minusTime = a - x;
                time += b * x;
                for (int j = i; j < n; j++) {
                    time += minusTime;
                    if (time <= task[j]) cnt++;
                    else time -= minusTime;
                }
                max = Math.max(max, cnt);
            }


            if (max == n) break;


        }

        bw.write(String.valueOf(max));
        bw.flush();

    }

}
