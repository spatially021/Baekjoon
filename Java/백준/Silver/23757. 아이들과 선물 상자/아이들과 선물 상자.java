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

        PriorityQueue<Integer> gifts = new PriorityQueue<>((o1, o2) -> o2 - o1);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) gifts.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        boolean flag = true;

        for (int i = 0; i < m; i++) {
            int want = Integer.parseInt(st.nextToken());
            int now = gifts.poll();
            if (now < want) {
                flag = false;
                break;
            }
            gifts.add(now - want);

        }

        bw.write(flag ? "1" : "0");
        bw.flush();
    }


}
