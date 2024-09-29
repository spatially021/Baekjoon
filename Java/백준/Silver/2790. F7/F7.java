import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max=-1;
        int[] drivers=new int[n];

        for(int i=0;i<n;i++){
            drivers[i]=Integer.parseInt(br.readLine());
            if(max<drivers[i]) max=drivers[i];
        }

        Arrays.sort(drivers);
        max++;
        int cnt=1;

        for(int i=n-2;i>=0;i--){
            int a=drivers[i]+n;
            if(max>a) break;

            int b=drivers[i]+n-i;
            max=Math.max(max,b);
            cnt++;
        }

        System.out.println(cnt);

    }

}
