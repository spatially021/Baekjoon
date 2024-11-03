import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer,Integer> setX=new HashMap<>();
        HashMap<Integer,Integer> setY=new HashMap<>();

        for(int i=0;i<3;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            setX.put(x,setX.getOrDefault(x, 0)+1);
            setY.put(y,setY.getOrDefault(y,0)+1);
        }

        StringBuilder sb=new StringBuilder();

        for(int i:setX.keySet()){
            if(setX.get(i)==1){
                sb.append(i).append(" ");
            }
        }

        for(int i:setY.keySet()){
            if(setY.get(i)==1){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

}
