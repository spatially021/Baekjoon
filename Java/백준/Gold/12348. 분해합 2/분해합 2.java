import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input=br.readLine();

        long n=Long.parseLong(input);

        long start=n-(input.length()* 9L);


        for(long i=start;i<n;i++){

            long temp=i;
            long num=i;

            while (temp>0){
                num+=temp%10;
                temp/=10;
            }

            if(num==n){
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);

    }


}
