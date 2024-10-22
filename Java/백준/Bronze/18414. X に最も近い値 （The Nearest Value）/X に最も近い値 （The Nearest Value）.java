import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine()," ");

        int[] boundary=new int[2];

        boundary[0]=Integer.parseInt(st.nextToken());
        boundary[1]=Integer.parseInt(st.nextToken());

        int X=Integer.parseInt(st.nextToken());

        Arrays.sort(boundary);

        if(boundary[0]>=X) System.out.println(boundary[0]);
        else if(boundary[1]<=X) System.out.println(boundary[1]);
        else System.out.println(X);

    }

}
