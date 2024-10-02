import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());

        int temp=Math.min(k+60,n);

        System.out.println(temp*1500+(n-temp)*3000);

    }


}
