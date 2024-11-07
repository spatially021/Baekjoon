import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] c=new int[n];

        for(int i=0;i<n;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }

        int m=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();

        for(int t=0;t<m;t++){
            st=new StringTokenizer(br.readLine()," ");

            int start=Integer.parseInt(st.nextToken())-1;
            int end=Integer.parseInt(st.nextToken())-1;

            int len=(end-start+1)/2;

            boolean flag=true;

            for(int i=0;i<len;i++){
                if(c[start+i]!=c[end-i]){
                    flag=false;
                    break;
                }
            }

            sb.append(flag?1:0).append("\n");

        }

        System.out.println(sb);

    }

}
