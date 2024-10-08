import java.io.*;
import java.util.*;

public class Main {

    private static int max;

    private static int R;
    private static int L;

    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    private static char[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        matrix=new char[R][L];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<L;j++){
                matrix[i][j]=s.charAt(j);
            }
        }

        max = -1;

        Set<Character> set=new HashSet<>();
        set.add(matrix[0][0]);

        dfs(0,0,1,set);

        System.out.println(max);

    }


    private static void dfs(int x, int y, int depth, Set<Character> set) {

        max = Math.max(depth, max);

        for (int i = 0; i < 4; i++) {

            int dx = x + DX[i];
            int dy = y + DY[i];

            if (dx >= 0 && dx < R && dy >= 0 && dy < L) {

                char c = matrix[dx][dy];

                if (!set.contains(c)) {
                    set.add(c);
                    dfs(dx, dy, depth + 1, set);
                    set.remove(c);
                }

            }

        }

    }


}
