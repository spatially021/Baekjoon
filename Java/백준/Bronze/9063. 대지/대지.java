import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            maxX=Math.max(maxX,x);
            minX=Math.min(minX,x);

            maxY=Math.max(maxY,y);
            minY=Math.min(minY,y);

        }

        System.out.println((maxX-minX)*(maxY-minY));


    }

}
