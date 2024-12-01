import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), "/");

        int k=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());

        System.out.println(k+a<d||d==0?"hasu":"gosu");


    }
}
