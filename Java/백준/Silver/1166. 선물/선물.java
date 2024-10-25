import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long L = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long H = Integer.parseInt(st.nextToken());

        double low = 0;
        double high = Math.min(L, Math.min(W, H));


        while (low < high) {

            double mid = ((low + high) / 2.0f);

            long l = (long) (L / mid);
            long w = (long) (W / mid);
            long h = (long) (H / mid);

            if (l * w * h < n) {
                if (high == mid) break;
                high = mid;
            } else {
                if (low == mid) break;
                low = mid;
            }

        }

        System.out.println(low);

    }


}
