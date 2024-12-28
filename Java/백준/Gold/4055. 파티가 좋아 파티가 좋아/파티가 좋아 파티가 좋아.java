import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int days = 1;

        while (true) {
            int p = Integer.parseInt(br.readLine());
            if (p == 0) break;
            bw.write("On day " + days + " Emma can attend as many as ");

            Party[] parties = new Party[p];

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                parties[i] = new Party(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }


            Arrays.sort(parties, Comparator.comparingInt(o -> o.end));

            int[] timeTable = new int[24];

            int cnt = 0;

            for (Party party : parties) {
                for (int i = party.start; i < party.end; i++) {
                    timeTable[i]++;
                    if (timeTable[i] <= 2) {
                        cnt++;
                        break;
                    }
                }
            }
            bw.write(cnt + " parties.\n");
            days++;
        }
        bw.flush();
    }

}

class Party {

    final int start;
    final int end;

    Party(int start, int end) {
        this.start = start;
        this.end = end;
    }


}