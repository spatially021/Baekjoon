import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            String methodLine = br.readLine();
            methodLine = methodLine.replace("RR", ""); // RR을 하나의 R로 최적화

            char[] methods = methodLine.toCharArray();

            int len = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();
            String input = br.readLine();

            if (len > 0) {
                input = input.substring(1, input.length() - 1); // 대괄호 제거
                String[] S = input.split(",");
                for (String num : S) {
                    deque.add(Integer.parseInt(num)); // 숫자를 덱에 추가
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char c : methods) {
                if (c == 'R') {
                    isReversed = !isReversed; // R 연산은 리버스 플래그를 반전
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break; // 에러 상황 처리
                    }
                    if (isReversed) {
                        deque.removeLast(); // 리버스 상태에서는 뒤에서 제거
                    } else {
                        deque.removeFirst(); // 일반 상태에서는 앞에서 제거
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}
