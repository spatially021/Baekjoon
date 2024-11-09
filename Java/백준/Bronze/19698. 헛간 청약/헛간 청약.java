import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());

        System.out.println(Math.min(((w / l) * (h / l)), n));

    }

}
