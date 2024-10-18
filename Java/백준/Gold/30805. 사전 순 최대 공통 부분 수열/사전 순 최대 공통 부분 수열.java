import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!a.isEmpty() && !b.isEmpty()) {
            int aMaxValue = Collections.max(a);
            int bMaxValue = Collections.max(b);

            if (aMaxValue == bMaxValue) {
                ans.add(aMaxValue);

                a.subList(0, a.indexOf(aMaxValue) + 1).clear();
                b.subList(0, b.indexOf(bMaxValue) + 1).clear();
            } else if (aMaxValue > bMaxValue) {
                a.remove(Integer.valueOf(aMaxValue));
            } else {
                b.remove(Integer.valueOf(bMaxValue));
            }
        }

        if (ans.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(ans.size()).append("\n");
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }
}

