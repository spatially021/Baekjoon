import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr=new long[n];

        st = new StringTokenizer(br.readLine());

        boolean flag = false;


        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int low=0;
        int high=n-1;

        int alMid=0;
        int acMid=0;

        long min=Long.MAX_VALUE;

        while (low<high){

            long sum=arr[low]+arr[high];

            if(min>Math.abs(sum)){
                min=Math.abs(sum);
                alMid=low;
                acMid=high;
            }
            if(sum>=0) high--;
            else low++;

        }

        System.out.printf("%d %d",arr[alMid],arr[acMid]);

    }

}
