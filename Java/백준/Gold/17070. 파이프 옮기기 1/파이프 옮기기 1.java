import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] matrix;
    private static int N ;
    private static int counter=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        dfs(1,0,0);

        System.out.println(counter);

    }

    private static void dfs(int x,int y,int degree) {

        if(x==N-1&&y==N-1){
            counter++;
            return;
        }

        if(degree==0){
            if(x+1<N&&!matrix[x+1][y]){
                dfs(x+1,y,0);
            }

            if(x+1<N&&y+1<N&&(!matrix[x+1][y]&&!matrix[x+1][y+1]&&!matrix[x][y+1])){
                dfs(x+1,y+1,45);
            }

        }else if(degree==45){
            if(x+1<N&&!matrix[x+1][y]){
                dfs(x+1,y,0);
            }
            if(x+1<N&&y+1<N&&!matrix[x+1][y]&&!matrix[x+1][y+1]&&!matrix[x][y+1]){
                dfs(x+1,y+1,45);
            }
            if(y+1<N&&!matrix[x][y+1]){
                dfs(x,y+1,90);
            }

        }else if(degree==90){
            if(x+1<N&&y+1<N&&!matrix[x+1][y]&&!matrix[x+1][y+1]&&!matrix[x][y+1]){
                dfs(x+1,y+1,45);
            }
            if(y+1<N&&!matrix[x][y+1]){
                dfs(x,y+1,90);
            }
        }


    }


}
