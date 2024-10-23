import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int T = 0; T < tc; T++) {

            st = new StringTokenizer(br.readLine(), " ");

            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int need = E - C;
            if (need <= 0) {
                sb.append(0).append("\n");
                continue;
            }
            if (G == 1)
                sb.append(need).append("\n");
            else if (G == 2)
                sb.append(need * 3).append("\n");
            else
                sb.append(need * 5).append("\n");
        }

        System.out.println(sb);

    }

}
