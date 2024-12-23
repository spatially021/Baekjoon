import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Stack<Integer> front = new Stack<>();
        Stack<Integer> back = new Stack<>();

        int current = -1;

        for (int Q = 0; Q < q; Q++) {

            st = new StringTokenizer(br.readLine(), " ");

            char c = st.nextToken().toCharArray()[0];

            if (c == 'B') {
                if (!back.isEmpty()) {
                    if (current != -1) front.add(current);
                    current = back.pop();
                }
            } else if (c == 'F') {
                if (!front.isEmpty()) {
                    if (current != -1) back.add(current);
                    current = front.pop();
                }
            } else if (c == 'A') {
                front.clear();
                if (current != -1) back.add(current);
                current = Integer.parseInt(st.nextToken());
            } else {
                if (!back.isEmpty()) {
                    int before = back.pop();
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(before);
                    while (!back.isEmpty()) {
                        int num = back.pop();
                        if (num != before) temp.add(num);
                        before = num;
                    }
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        back.add(temp.get(i));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(current).append("\n");

        if (back.isEmpty()) sb.append("-1\n");
        else {
            while (!back.isEmpty()) {
                sb.append(back.pop()).append(" ");
            }
            sb.append("\n");
        }

        if (front.isEmpty()) sb.append("-1\n");
        else {
            while (!front.isEmpty()) {
                sb.append(front.pop()).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }


}
