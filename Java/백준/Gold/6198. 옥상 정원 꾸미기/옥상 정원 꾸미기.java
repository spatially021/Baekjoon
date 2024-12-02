import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        long cnt = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() <= height[i]) stack.pop();
            cnt += stack.size();
            stack.add(height[i]);

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(cnt));
        bw.close();
    }

}