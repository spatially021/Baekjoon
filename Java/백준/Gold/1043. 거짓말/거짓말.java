import java.io.*;
import java.util.*;

public class Main {

    private static int[] parents;
    private static final List<Integer> kPeople=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        parents=new int[n+1];
        for(int i=1;i<n+1;i++){
            parents[i]=i;
        }

        st=new StringTokenizer(br.readLine()," ");
        int kNum=Integer.parseInt(st.nextToken());

        if(kNum==0){
            System.out.println(m);
            return;
        }else{
            for(int i=0;i<kNum;i++){
                kPeople.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer>[] parties=new List[m];
        for(int i=0;i<m;i++){
            parties[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int pNum=Integer.parseInt(st.nextToken());

            int x=Integer.parseInt(st.nextToken());
            parties[i].add(x);

            for(int j=1;j<pNum;j++){
                int y=Integer.parseInt(st.nextToken());
                union(x, y);
                parties[i].add(y);
            }

        }

        int counter=0;

        for(int i=0;i<m;i++){
            boolean flag=true;
            for(int num:parties[i]){
                if(kPeople.contains(find(parents[num]))){
                    flag=false;
                    break;
                }
            }
            if(flag) counter++;
        }

        System.out.println(counter);

    }

    private static int find(int x){
        if(x== parents[x]) return x;
        return find(parents[x]);
    }

    private static void union(int x,int y){

       int nx=find(x);
       int ny=find(y);

        if(kPeople.contains(ny)){
            int temp=nx;
            nx=ny;
            ny=temp;
        }

        parents[ny]=nx;

    }

}
