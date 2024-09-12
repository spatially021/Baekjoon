import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static Integer[] arr;
    private static int[] result;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        arr = new Integer[N];
        result = new int[M];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(scan.nextInt());
        }

        arr = set.toArray(new Integer[0]);

        Arrays.sort(arr);

        N=arr.length;

        dfs(0, 0);

    }

    private static void dfs(int cnt, int index) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                System.out.print(result[i] + " ");
            System.out.println();
        } else {
            int before = 0;
            for (int i = index; i < N; i++) {

                if (before <= arr[i]) {
                    result[cnt] = arr[i];
                    before = arr[i];
                    dfs(cnt + 1, i);
                }
            }
        }
    }

}
