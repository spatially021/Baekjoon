import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        for (int i = n - 5; i < n; i++) bw.write(s[i]);

        bw.flush();

    }
}
