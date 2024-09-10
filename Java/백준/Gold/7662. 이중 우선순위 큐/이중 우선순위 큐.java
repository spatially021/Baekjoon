import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {

                int cnt = Integer.parseInt(br.readLine());

                TreeMap<Integer, Integer> map = new TreeMap<>();

                for (int i = 0; i < cnt; i++) {

                    String[] input = br.readLine().split(" ");

                    int num = Integer.parseInt(input[1]);

                    if (input[0].equals("I")) map.put(num, map.getOrDefault(num, 0) + 1);
                    else {
                        if (!map.isEmpty()) {
                            int key;
                            if (num == 1) {
                                key = map.lastKey();
                            } else {
                                key = map.firstKey();
                            }
                            if (map.get(key) == 1) map.remove(key);
                            else map.put(key,map.get(key)-1);
                        }
                    }
                }

                sb.append(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");

            }

            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
