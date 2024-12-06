import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long sum = 0;

        for (long i = 1; i < n + 1; i++) {
            sum += i * i * i;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        
    }
}
