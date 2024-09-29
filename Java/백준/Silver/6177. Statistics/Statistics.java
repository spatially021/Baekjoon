import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        float[] numbers=new float[N];
        int sum=0;

        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());
            numbers[i]=input;
            sum+=input;
        }

        Arrays.sort(numbers);

        System.out.printf("%f\n%f",sum/(float)N,N%2==0?(numbers[N/2]+numbers[N/2-1])/2f:numbers[N/2]);

    }
}
