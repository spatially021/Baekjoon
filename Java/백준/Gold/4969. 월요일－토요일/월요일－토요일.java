import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BitSet B = new BitSet(300_001);
        ArrayList<Integer> monSat = new ArrayList<>();

        for (int i = 8; i < 300_001; i += 7) {
            monSat.add(i);
            B.set(i);
        }
        for (int i = 6; i < 300_001; i += 7) {
            monSat.add(i);
            B.set(i);
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) break;

            bw.write(num + ": ");

            BitSet prim = new BitSet(300_001);
            prim.or(B);

            for (int i : monSat) {
                if (num % i == 0) {
                    for (int j = i * 2; j < 300_001; j += i) prim.clear(j);
                } else prim.clear(i);
            }

            for (int i : prim.stream().toArray()) bw.write(i + " ");

            bw.write("\n");
        }

        bw.flush();
    }
}
