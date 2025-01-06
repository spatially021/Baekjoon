import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> monSat = new ArrayList<>();
        boolean[] B = new boolean[300_001];

        for (int i = 8; i < 300_001; i += 7) {
            monSat.add(i);
            B[i] = true;
        }
        for (int i = 6; i < 300_001; i += 7) {
            monSat.add(i);
            B[i] = true;
        }

        Collections.sort(monSat);

        boolean[] prim = new boolean[300_001];

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) break;

            bw.write(num + ": ");
            System.arraycopy(B, 0, prim, 0, 300_001); // 기존 배열을 복사하지 않고 메모리 효율적으로 초기화

            for (int i : monSat) {
                if (num % i == 0) {
                    for (int j = i * 2; j < 300_001; j += i) prim[j] = false;
                } else prim[i] = false;
            }

            for (int i : monSat) if (prim[i]) bw.write(i + " ");
            bw.write("\n");
        }

        bw.flush();
    }
}
