import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        int[] inputs = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            int parent = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                nodes[parent].add(num);
                inputs[num]++;
                parent=num;
            }
        }

        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (inputs[i] == 0) q.add(i);
        }

        int counter=0;

        while (counter!=n){

            while (!q.isEmpty()) {

                int v = q.poll();
                counter++;
                sb.append(v).append("\n");

                for (int i : nodes[v]) {
                    inputs[i]--;
                    if (inputs[i] == 0) q.add(i);
                }
            }

            if(counter==n) break;

            for(int i=1;i<n+1;i++){
                inputs[i]--;
                if(inputs[i]<0){
                    System.out.println(0);
                    return;
                }else if(inputs[i]==0) q.add(i);
            }

        }



        System.out.println(sb);

    }
}
