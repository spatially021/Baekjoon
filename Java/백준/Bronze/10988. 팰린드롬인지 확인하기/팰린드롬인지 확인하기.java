import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c=br.readLine().toCharArray();

        int n=c.length;

        boolean flag=true;

        for(int i=0;i<n/2;i++){
            if(c[i]!=c[n-i-1]){
                flag=false;
                break;
            }
        }

        System.out.println(flag?1:0);

    }
}
