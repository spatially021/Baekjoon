import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb=new StringBuilder();

        while (true){

            st=new StringTokenizer(br.readLine()," ");
            int[] arr=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            if(arr[0]==0) break;

            if(arr[0]==arr[1]&&arr[1]==arr[2]) sb.append("Equilateral\n");
            else{
                Arrays.sort(arr);

                if(arr[2]<arr[1]+arr[0]){
                    if(arr[0]==arr[1]||arr[1]==arr[2]) sb.append("Isosceles\n");
                    else sb.append("Scalene\n");
                }else sb.append("Invalid\n");
            }

        }

        System.out.println(sb);

    }

}
