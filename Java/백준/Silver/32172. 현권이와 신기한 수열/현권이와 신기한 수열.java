import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[20000000];
        used[0] = true;

        int before = 0;

        for (int i = 1; i < n + 1; i++) {

            int temp = before - i;

            if (temp < 0 || used[temp])
                before = before + i;
            else
                before = temp;
            used[before]=true;

        }

        System.out.println(before);

    }
}
