import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<m;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb=new StringBuilder();

        while (!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);

    }

}
