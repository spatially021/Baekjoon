import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int l=Integer.parseInt(br.readLine());

        System.out.println((s+m*2+l*3)>=10?"happy":"sad");


    }



}
