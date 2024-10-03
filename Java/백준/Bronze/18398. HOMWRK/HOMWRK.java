import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int tc=Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){

            int n=Integer.parseInt(br.readLine());

            for(int i=0;i<n;i++){

                st=new StringTokenizer(br.readLine()," ");

                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                sb.append(a+b).append(" ").append(a*b).append("\n");

            }

        }


        System.out.println(sb);

    }


}
