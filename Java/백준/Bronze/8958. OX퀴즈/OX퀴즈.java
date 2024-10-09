import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {

            int succeed = 0;
            int sum = 0;

            char[] input = br.readLine().toCharArray();

            for (char c : input) {

                if (c == 'O') sum += ++succeed;
                else succeed=0;

            }

            sb.append(sum).append("\n");

        }

        System.out.println(sb);

    }
}
