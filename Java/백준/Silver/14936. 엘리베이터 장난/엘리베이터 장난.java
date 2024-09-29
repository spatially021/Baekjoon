import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int m;
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int t1=N;
        int t2=N/2;
        int t3=(N+1)/2;
        int t4=(N-1)/3+1;

        int ans=1;

        // 동작 1 (모든버튼)
        if (t1 <= m) ans++;

        // 동작 2 (짝수버튼)
        if (N > 1 && t2 <= m) ans++;

        // 동작 3 (홀수버튼)
        if (N > 1 && t3 <= m) ans++;

        // 동작 4 (3k+1버튼)
        if (N > 2 && t4 <= m) ans++;

        // 동작 2 & 동작 4 (짝수버튼 & 3k+1버튼)
        if (N >= 3 && t2 + t4 <= m) ans++;

        // 동작 3 & 동작 4 (홀수버튼 & 3k+1버튼)
        if (N >= 3 && t3 + t4 <= m) ans++;

        // 동작 1 & 동작 4 (모든버튼 & 3k+1버튼)
        if (N >= 3 && t1 + t4 <= m) ans++;

        System.out.println(ans);

    }


}
