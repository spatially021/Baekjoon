import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        int N=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());


        int[] w=new int[N+1];
        int[] v=new int[N+1];

        int[][] dp=new int[N+1][W+1];

        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(br.readLine()," ");
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<W+1;j++){

                if(w[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }

            }
        }

        System.out.println(dp[N][W]);

    }

}
