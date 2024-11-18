import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] arr;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] inputs = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
            inputs[a]++;
        }


        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> result=new Stack<>();

        for (int i = 1; i < n + 1; i++) {
            if (inputs[i] == 0) q.add(i);
        }

        while (!q.isEmpty()){

            int v=q.poll();
            stack.add(v);

            for(int i:arr[v]){
                inputs[i]--;
                if(inputs[i]==0) q.add(i);
            }

        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }


}
