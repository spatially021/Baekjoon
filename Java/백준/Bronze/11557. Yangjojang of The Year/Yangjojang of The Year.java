import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int tc=Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){

            int N=Integer.parseInt(br.readLine());
            String[] s=new String[N];
            int[] I=new int[N];

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine()," ");
                s[i]=st.nextToken();
                I[i]=Integer.parseInt(st.nextToken());
            }

            int max=-1;
            int maxIndex=-1;

            for(int i=0;i<N;i++){
                if(max<I[i]){
                    max=I[i];
                    maxIndex=i;
                }
            }

            sb.append(s[maxIndex]).append("\n");

        }

        System.out.println(sb);
    }
}
