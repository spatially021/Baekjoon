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

        HashMap<String, int[][]> map = new HashMap<>();
        HashMap<String, int[][]> counter = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String s = st.nextToken();

            int day = Integer.parseInt(st.nextToken());

            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            int[][] temp = new int[m / 7][1];

            int week = day / 7 + (day % 7 == 0 ? -1 : 0);

            temp[week][0] += endTime - startTime;

            int[][] I = map.getOrDefault(s, new int[m / 7][1]);
            I[week][0] += temp[week][0];
            map.put(s, I);

            I = counter.getOrDefault(s, new int[m / 7][1]);
            I[week][0]++;
            counter.put(s, I);
        }

        int cnt = 0;

        ArrayList<String> arr = new ArrayList<>();

        for (String s : map.keySet()) {

            int[][] times = map.get(s);
            int[][] counts = counter.get(s);

            boolean flag = true;

            for (int i = 0; i < m / 7; i++) {
                if (times[i][0] < 60 * 60 || counts[i][0] < 5) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
                arr.add(s);
            }

        }

        if (cnt == 0) bw.write("-1");
        else {
            Collections.sort(arr);
            for (String s : arr) bw.write(s + "\n");
        }
        bw.flush();
    }
}
