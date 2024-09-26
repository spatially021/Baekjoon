import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX= (int) 1.0e+8;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr=new int[N+1][N+1];

        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                arr[i][j]=MAX;
                if(i==j) arr[i][j]=0;
            }
        }

        for(int i=0;i<m;i++){

            StringTokenizer st=new StringTokenizer(br.readLine()," ");

            int index=Integer.parseInt(st.nextToken());

            int to=Integer.parseInt(st.nextToken());

            int cost=Integer.parseInt(st.nextToken());

            arr[index][to]=Math.min(arr[index][to],cost );

        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }


        StringBuilder sb=new StringBuilder();

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                sb.append(arr[i][j]>=MAX?0:arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}
