import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int tc=Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){
            char[] C=br.readLine().toCharArray();
            int cnt=0;

            for(char c:C){
                if(c=='D') break;
                cnt++;
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);

    }


}
