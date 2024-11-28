import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = matrix[0][i] % m;
        }

        loop1:
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % m != arr[j]) {
                    flag = false;
                    break loop1;
                }
            }
        }

        for (int[] I : matrix) {
            Arrays.sort(I);
        }

        loop1:
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] - matrix[i][j - 1] != 1) {
                    flag = false;
                    break loop1;
                }
            }
        }


        System.out.println(flag ? 1 : 0);

    }

}
