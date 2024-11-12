import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent=new int[n+1];

        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }



        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(findParent(a)!=findParent(b)) union(a,b);
            else{
                System.out.println(i+1);
                return;
            }

        }

        System.out.println(0);

    }

    private static int findParent(int x){
        if(x!=parent[x]) parent[x]=findParent(parent[x]);
        return parent[x];
    }

    private static void union(int a,int b){
        int x=findParent(a);
        int y=findParent(b);

        if(x<y) parent[x]=y;
        else parent[y]=x;
    }

}
