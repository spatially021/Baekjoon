import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        ArrayList<int[]> arr=new ArrayList<>();
        String[] names=new String[n];

        for(int i=0;i<n;i++){

            st=new StringTokenizer(br.readLine()," ");

            int age=Integer.parseInt(st.nextToken());

            String name=st.nextToken();
            names[i]=name;

            arr.add(new int[]{i,age});

        }

        arr.sort((o1, o2) -> o1[1] - o2[1]);

        StringBuilder sb=new StringBuilder();

        for(int[] I:arr){
            sb.append(I[1]).append(" ").append(names[I[0]]).append("\n");
        }

        System.out.println(sb);

    }
}