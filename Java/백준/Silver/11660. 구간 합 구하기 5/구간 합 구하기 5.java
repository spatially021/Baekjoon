import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;


        st=new StringTokenizer(br.readLine()," ");

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] dp=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                dp[i][j]=Integer.parseInt(st.nextToken())+dp[i][j-1];
            }
        }

        for(int i=0;i<M;i++){
            int sum=0;
            st=new StringTokenizer(br.readLine()," ");
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int j=x1;j<=x2;j++){
                sum+=dp[j][y2]-dp[j][y1-1];
            }

            sb.append(sum).append("\n");

        }

        System.out.println(sb);

    }
}
